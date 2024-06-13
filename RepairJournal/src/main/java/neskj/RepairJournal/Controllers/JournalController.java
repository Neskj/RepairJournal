package neskj.RepairJournal.Controllers;

import neskj.RepairJournal.Controllers.Services.DataService;
import neskj.RepairJournal.Models.HttpData.HttpData;
import neskj.RepairJournal.Models.PersistenceEntitys.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        logger.info("\n\nMethod POST get a new data: \n" + incomingData.toString() + "\n");

        dataService.addData(incomingData);
    }

    @GetMapping("/data")
    public Iterable<Unit> viewUnits() {

        return dataService.getAllDataQuery();
    }

    @PostMapping("/setstatus")
    public void updateUnitStatus(@RequestBody HttpData incomingData) {

        dataService.updateUnitStatus(incomingData);

        logger.info("\n\nStatus is change in " + incomingData.getSerial() + "\n");
    }

    @GetMapping("/notdone")
    public Iterable<Unit> findAllNotDone(){

        logger.info("\n\nReturned all not done Units\n");

        return dataService.findNotDone();
    }

    @GetMapping("/find")
    public Iterable<Unit> findConcreteUnit(@RequestParam String serial){

        logger.info("\n\n< Find concrete unit whith > "+serial);

        return dataService.findConcreteUnit(serial);
    }

    @PostMapping("/complete")
    public void setComplete(@RequestParam String serial,@RequestParam String complete){

        dataService.setComplete(serial, complete);
    }
}
