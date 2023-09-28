package behavioral.command;

import behavioral.command.work.HandWork;
import behavioral.command.work.TractorWork;
import behavioral.command.work.WorkFunctions;

public class WorkTypeDeterminer {

    public static WorkFunctions getWorkType(WorkFunctions workFunctions) {
        if (workFunctions.getClass().equals(TractorWork.class)) {
            return new TractorWork();
        } else {
            return new HandWork();
        }
    }

}