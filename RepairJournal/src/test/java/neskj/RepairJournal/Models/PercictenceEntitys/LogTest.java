package neskj.RepairJournal.Models.PercictenceEntitys;

import neskj.RepairJournal.Models.PersistenceEntitys.Log;
import neskj.RepairJournal.Models.PersistenceEntitys.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LogTest {

    private Log log;
    private Unit testUnit;

    @BeforeEach
    void init() {
        testUnit = new Unit();

        log = new Log();
        log.setDefect("Оторван разъем");
        log.setUnit(testUnit);
    }

    @Test
    public void createNotNull() {

        assertNotNull(log);
    }

    @Test
    public void gettersTestHappyFlow() {

        String expectDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

        assertEquals("Оторван разъем", log.getDefect());
        assertEquals(expectDate, log.getDate());
        assertEquals("В ремонте", log.getStatus());
        assertEquals(testUnit, log.getUnit());
    }

    @Test
    public void settersTestHappyFlow() {

        Unit expectUnit = new Unit();

        log.setDefect("Не работает укладчик");
        log.setStatus("Готово");
        log.setUnit(expectUnit);

        assertEquals("Не работает укладчик", log.getDefect());
        assertEquals("Готово", log.getStatus());
        assertEquals(expectUnit, log.getUnit());
    }
}
