package neskj.RepairJournal.Controllers.Services;

import neskj.RepairJournal.Models.HttpData.HttpData;
import neskj.RepairJournal.Models.PersistenceEntitys.Unit;
import neskj.RepairJournal.Repositoryes.UnitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DataServiceTest {

    @Mock
    private Logger logger;

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

    public void addDataCreateNewUnit() {

    }


}
