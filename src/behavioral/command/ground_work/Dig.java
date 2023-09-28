package behavioral.command.ground_work;

import behavioral.command.work.WorkFunctions;

public class Dig implements Command {

    private WorkFunctions workFunctions;

    public Dig(WorkFunctions fs){
        this.workFunctions =fs;
    }
    @Override
    public String execute() {
       return this.workFunctions.dig();
    }

}