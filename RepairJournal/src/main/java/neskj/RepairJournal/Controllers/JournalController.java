package neskj.RepairJournal.Controllers;

import neskj.RepairJournal.Models.Log;
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

    @PostMapping("/test")
    public void test(){

        Unit unit1=new Unit();
        unit1.setType("Кабельный барабан");
        unit1.setSerial("106701234");

        Log log1=new Log();
        log1.setDefect("Оторван разъем");
        log1.setUnit(unit1);

        unit1.getLogs().add(log1);

        repository.save(unit1);

        Unit unit2=new Unit();
        unit2.setType("Робот FW-100");
        unit2.setSerial("FAY-0156");

        Log log2=new Log();
        log2.setDefect("Сгорел светильник");
        log2.setUnit(unit2);

        unit2.getLogs().add(log2);
        repository.save(unit2);


    }
}
