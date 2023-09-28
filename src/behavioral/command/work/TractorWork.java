package behavioral.command.work;

import behavioral.strategy.SowStrategy;

public class TractorWork implements SowStrategy, WorkFunctions {

    private String time;
    private String duration;

    public TractorWork(String time, String expiryDate){
        this.time = time;
        this.duration =expiryDate;
    }

    public TractorWork() {
    }

    @Override
    public void sow(int grainSorts) {
        System.out.println(grainSorts +" sowed by tractor.");
    }

    @Override
    public String dig() {
        return "Dig with Tractor";
    }

    @Override
    public String leave() {
        return "Leave with Tractor";
    }

    @Override
    public String loosen() {
        return "Loosen with Tractor";
    }
}
