package neskj.RepairJournal.Controllers;

import neskj.RepairJournal.Models.Unit;
import neskj.RepairJournal.Repositoryes.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class JournalController {

    private final Logger logger=Logger.getLogger(JournalController.class.getName());

    private final UnitRepository repository;

    @Autowired
    JournalController(UnitRepository repository){
        this.repository=repository;
    }

    @PostMapping("/data")
    public void newUnit(@RequestBody Unit unit){

        logger.info("\n\nNew unit --->> "+unit.getSerial());

        repository.save(unit);

    }

    @GetMapping("/data")
    public Iterable<Unit>viewUnits(){

       Iterable allData=repository.findAll();

       for(Object x:allData){
           logger.info("\nsend data: "+x.toString());
       }

        return allData;
    }
}
