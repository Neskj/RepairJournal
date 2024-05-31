package neskj.RepairJournal.Controllers.Services;

import neskj.RepairJournal.Models.HttpData.HttpData;
import neskj.RepairJournal.Models.PersistenceEntitys.Log;
import neskj.RepairJournal.Models.PersistenceEntitys.Unit;
import neskj.RepairJournal.Repositoryes.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DataService {

    private final Logger logger=Logger.getLogger(DataService.class.getName());

    private final UnitRepository repository;

    @Autowired
    DataService(UnitRepository repository){

        this.repository=repository;
    }

    public void addData(HttpData incomingData){

        if(repository.checkBySerial(incomingData.getSerial())!=null){

            System.out.println("Oshibka - takoi seriynik uje est'"); //тут продолжаем. надо внедрить логику добавления новой записи в журнале

        } else {

            Unit unit = new Unit();
            unit.setType(incomingData.getType());
            unit.setSerial(incomingData.getSerial());

            Log log = new Log();
            log.setDefect(incomingData.getDefect());
            log.setUnit(unit);

            unit.getLogs().add(log);

            repository.save(unit);

            logger.info("\n\n < DataService successfully save new unit >\n");
        }
    }

    @Deprecated
    public Iterable<Unit> getAllData(){     //стандартная реализация некорректно работает

        logger.info("\n\n DataService return all logs from database");

        return repository.findAll();
    }

    public Iterable<Unit> getAllDataQuery(){

        logger.info("\n\n DataService return all logs from database");

        return repository.customGetAllData();
    }
}
