package neskj.RepairJournal.Models.HttpData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HttpDataTest {

    private HttpData httpData;

    @BeforeEach
    public void init() {

        httpData = new HttpData("FW-100", "FAY1234", "Пробой сегмента светодиодов доп. подсветки");
    }

    @Test
    public void createNotNull() {

        assertNotNull(httpData);
    }

    @Test
    public void gettersTestHapyFlow() {

        assertEquals("FW-100", httpData.getType());
        assertEquals("FAY1234", httpData.getSerial());
        assertEquals("Пробой сегмента светодиодов доп. подсветки", httpData.getDefect());
    }

    @Test
    public void returnCorrectString() {

        String expectString = "HttpData{type='FW-100', " +
                "serial='FAY1234', defect='Пробой сегмента светодиодов доп. подсветки'}";

        assertEquals(expectString, httpData.toString());
    }
}
