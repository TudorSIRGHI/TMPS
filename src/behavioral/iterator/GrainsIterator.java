package behavioral.iterator;

import behavioral.strategy.Grain;

public class GrainsIterator implements Iterator {
    Grain[] grains;

    int pos = 0;

    public GrainsIterator(Grain[] grains) {
        this.grains = grains;
    }

    public Object next() {
        Grain grain = grains[pos];
        pos += 1;
        return grain;
    }

    public boolean hasNext() {
        if (pos >= grains.length ||
                grains[pos] == null)
            return false;
        else
            return true;
    }
}
