package behavioral.iterator;

import behavioral.strategy.Grain;

public class GrainClass {
    GrainCollection grainCollection;
    public GrainClass(GrainCollection grainCollection) {
        this.grainCollection = grainCollection;
    }

    public void printGrainName() {
        Iterator iterator = grainCollection.createIterator();
        while (iterator.hasNext()) {
            Grain n = (Grain) iterator.next();
            System.out.println(n.getName());
        }
    }
}
