package neskj.RepairJournal.Models.PersistenceEntitys;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue
    private long id;
    private String defect;
    private final String date=new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    private String status="В ремонте";

    @ManyToOne
    @JoinColumn(name = "unitid")
    private Unit unit;

    public long getId() {
        return id;
    }

    public String getDefect() {
        return defect;
    }

    public String getDate() { return date; }

    public String getStatus() { return status; }

    public Unit getUnit() {
        return unit;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public void setStatus(String status) { this.status = status; }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
