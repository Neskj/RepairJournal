package neskj.RepairJournal.Models.HttpData;

public class HttpData {

    private final String type;
    private final String serial;
    private final String defect;

    HttpData(String type, String serial, String defect) {

        this.type = type;
        this.serial = serial;
        this.defect = defect;
    }

    public String getType() {
        return type;
    }

    public String getSerial() {
        return serial;
    }

    public String getDefect() {
        return defect;
    }
}
