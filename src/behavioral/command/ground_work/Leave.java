package behavioral.command.ground_work;

import behavioral.command.work.WorkFunctions;

public class Leave implements Command {

    private WorkFunctions workFunctions;

    public Leave(WorkFunctions fs){
        this.workFunctions =fs;
    }
    @Override
    public String execute() {
        return this.workFunctions.leave();
    }

}