package neskj.RepairJournal.Models.PersistenceEntitys;

import jakarta.persistence.*;
import neskj.RepairJournal.Models.PersistenceEntitys.Log;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "units")
public class Unit {

    @Id
    @GeneratedValue
    private long id;
    private String type;
    private String serial;

    @OneToMany(mappedBy = "unit", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Log> logs=new ArrayList<>();

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

    public List<Log> getLogs() {
        return logs;
    }
}
