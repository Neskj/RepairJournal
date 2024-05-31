package neskj.RepairJournal.Controllers;

import neskj.RepairJournal.Controllers.Services.DataService;
import neskj.RepairJournal.Models.HttpData.HttpData;
import neskj.RepairJournal.Models.PersistenceEntitys.Log;
import neskj.RepairJournal.Models.PersistenceEntitys.Unit;
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

    private final DataService dataService;

    @Autowired
    JournalController(DataService dataService){
        this.dataService=dataService;
    }

    @PostMapping("/data")
    public void newUnit(@RequestBody HttpData incomingData){

        logger.info("\n\nMethod POST get a new data: \n"+incomingData.toString()+"\n");

        dataService.addData(incomingData);
    }

    @GetMapping("/data")
    public Iterable<Unit>viewUnits(){

       return dataService.getAllData();
    }
}
