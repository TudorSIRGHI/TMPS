package behavioral.command.ground_work;

import behavioral.command.work.WorkFunctions;
//a afina pamantul
public class Loosen implements Command {

    private WorkFunctions workFunctions;

    public Loosen(WorkFunctions fs){
        this.workFunctions =fs;
    }
    @Override
    public String execute() {
        return this.workFunctions.loosen();
    }

}
