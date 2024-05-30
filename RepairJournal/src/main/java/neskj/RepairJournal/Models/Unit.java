package neskj.RepairJournal.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "units")
public class Unit {

    @Id
    @GeneratedValue
    private long id;
    private String type;
    private String serial;

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSerial() {
        return serial;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}
