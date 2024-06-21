package neskj.RepairJournal.Models.Response;

public class RepairUnit {

    private String type;
    private String serial;
    private String date;
    private String defect;
    private String complete;
    private String status;

    public static class Builder{

       private RepairUnit repairUnit;

        Builder(){

            repairUnit=new RepairUnit();
        }

        public Builder addType(String type){

            repairUnit.type=type;
            return this;
        }

        public Builder addSerial(String serial){

            repairUnit.serial=serial;
            return this;
        }

        public Builder addDate(String date){

            repairUnit.date=date;
            return this;
        }

        public Builder addDefect(String defect){

            repairUnit.defect=defect;
            return this;
        }

        public Builder addComplete(String complete){

            repairUnit.complete=complete;
            return this;
        }

        public Builder addStatus(String status){

            repairUnit.status=status;
            return this;
        }

        public RepairUnit build(){

            return repairUnit;
        }

    }
}
