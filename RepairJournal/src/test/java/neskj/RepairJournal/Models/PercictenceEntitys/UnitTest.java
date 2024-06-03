package neskj.RepairJournal.Models.PercictenceEntitys;

import neskj.RepairJournal.Models.PersistenceEntitys.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UnitTest {

    private Unit unit;

    @BeforeEach
    void init() {

        unit = new Unit();
        unit.setType("Fw-100");
        unit.setSerial("FAY1234");
    }

    @Test
    public void createNotNull() {

        assertNotNull(unit);
    }

    @Test
    public void gettersTestHappyFlow() {

        assertEquals("Fw-100", unit.getType());
        assertEquals("FAY1234", unit.getSerial());
    }

    @Test
    public void settersTestHappyFlow() {

        unit.setType("Fw-150");
        unit.setSerial("113-0234");

        assertEquals("Fw-150", unit.getType());
        assertEquals("113-0234", unit.getSerial());
    }
}
