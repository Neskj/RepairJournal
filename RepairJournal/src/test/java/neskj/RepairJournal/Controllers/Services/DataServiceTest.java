package neskj.RepairJournal.Controllers.Services;

import neskj.RepairJournal.Models.HttpData.HttpData;
import neskj.RepairJournal.Models.PersistenceEntitys.Log;
import neskj.RepairJournal.Models.PersistenceEntitys.Unit;
import neskj.RepairJournal.Repositoryes.UnitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DataServiceTest {

    @Mock
    private UnitRepository repository;

    @InjectMocks
    private DataService dataService;

    @Test
    public void createNotNull() {

        assertNotNull(dataService);
    }

    @Test
    public void addDataFindUnitInTable() {

        HttpData testData = new HttpData("FW-100", "12345", "Разгерметизация");

        Unit expectUnit = new Unit();
        expectUnit.setType("FW-100");
        expectUnit.setSerial("12345");

        when(repository.checkBySerial(testData.getSerial())).thenReturn(expectUnit);

        dataService.addData(testData);

        assertEquals(1, expectUnit.getLogs().size());
        verify(repository).save(expectUnit);
    }

    @Test
    public void addDataCreateNewUnit() {

        HttpData testData = new HttpData("Vcam 6", "9990111", "Пропадает видеосигнал");

        when(repository.checkBySerial(testData.getSerial())).thenReturn(null);

        dataService.addData(testData);

        verify(repository).save(any(Unit.class));
    }

    @Test
    public void getAllDataQueryHappyFlow() {

        Unit expectUnit = new Unit();
        expectUnit.setSerial("99112233");

        List<Unit> expectList = new ArrayList<>();
        expectList.add(expectUnit);

        when(repository.customGetAllData()).thenReturn(expectList);

        List<Unit> resultList = (List<Unit>) dataService.getAllDataQuery();

        assertEquals(1, resultList.size());
        verify(repository, times(1)).customGetAllData();
    }

    @Test
    public void updateUnitStatusHappyFlow() {

        HttpData testData = new HttpData("FW-100", "12345", "Разгерметизация");

        Log testLog = new Log();
        testLog.setDefect("Разгерметизация");

        Unit expectUnit = new Unit();
        expectUnit.getLogs().add(testLog);

        when(repository.checkBySerial(testData.getSerial())).thenReturn(expectUnit);

        dataService.updateUnitStatus(testData);

        assertEquals("Готов", expectUnit.getLogs().getFirst().getStatus());
        verify(repository).save(expectUnit);
    }

    @Test
    public void findNotDoneHappyFlow() {

        Unit firstUnit = new Unit();
        Log firstLog = new Log();
        firstUnit.getLogs().add(firstLog);

        Unit secondUnit = new Unit();
        Log secondLog = new Log();
        firstUnit.getLogs().add(secondLog);

        List<Unit> testList = new ArrayList<>(Arrays.asList(firstUnit, secondUnit));

        when(repository.findAllNotDone()).thenReturn(testList);

        List<Unit> resultList = (List<Unit>) dataService.findNotDone();

        assertEquals(2, resultList.size());
        verify(repository, times(1)).findAllNotDone();
    }

    @Test
    public void findConcreteUnit() {

        String testSerial = "FAY1234";

        Unit expectUnit = new Unit();
        expectUnit.setSerial("FAY1234");

        List<Unit> expectList = new ArrayList<>(Arrays.asList(expectUnit));  // вообще там Unit, непонятно почему я решил что интерфейс вернет Iterable

        when(repository.findUnitBySerial(testSerial)).thenReturn(expectList);

        List<Unit> resultList = (List<Unit>) dataService.findConcreteUnit(testSerial);

        assertEquals(expectList, resultList);
        verify(repository, times(1)).findUnitBySerial(testSerial);
    }
}
