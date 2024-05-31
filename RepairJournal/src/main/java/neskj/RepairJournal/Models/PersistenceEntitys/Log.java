package neskj.RepairJournal.Models.PersistenceEntitys;

import jakarta.persistence.*;

@Entity
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue
    private long id;
    private String defect;

    @ManyToOne
    @JoinColumn(name = "unitid")
    private Unit unit;

    public long getId() {
        return id;
    }

    public String getDefect() {
        return defect;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
