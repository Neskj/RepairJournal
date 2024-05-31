package neskj.RepairJournal.Repositoryes;

import neskj.RepairJournal.Models.PersistenceEntitys.Unit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UnitRepository extends CrudRepository<Unit,Long> {

    @Query("select u.type,u.serial,l.defect from Unit u join u.logs l where l.defect is not null ")
    Iterable<Unit> customGetAllData();
}
