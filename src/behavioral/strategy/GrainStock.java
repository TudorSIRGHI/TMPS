package behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class GrainStock {
    List<Grain> grains;
    public GrainStock() {
        this.grains = new ArrayList<>();
    }
    public void addGrain(Grain grain) {
        this.grains.add(grain);
    }
    public void removeStudent(Grain grain) {
        this.grains.remove(grain);
    }
    public int calculateTotal() {
        return grains.size();
    }
    public void sow(SowStrategy sowStrategy) {
        sowStrategy.sow(calculateTotal());
    }
}
