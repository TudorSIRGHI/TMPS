package behavioral.command.work;

import behavioral.strategy.SowStrategy;

public class HandWork implements SowStrategy, WorkFunctions {

    private String name;
    private String duration;

    public HandWork() {
    }

    public HandWork(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public void sow(int grainSorts) {
        System.out.println(grainSorts + " sowed manually.");
    }

    @Override
    public String dig() {
        return "Dig Manually";
    }

    @Override
    public String leave() {
        return "Leave Manually";
    }

    @Override
    public String loosen() {
        return "Loosen Manually";
    }
}
