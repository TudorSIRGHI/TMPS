package behavioral.iterator;


import behavioral.strategy.Grain;

public class GrainCollection implements Collection
{
    static final int maxGrainAllowed = 10;
    int numberOfGrain = 0;
    Grain[] grains;

    public GrainCollection()
    {
        grains = new Grain[maxGrainAllowed];
    }

    public void addGrain(String str, int quantity)
    {
        Grain grain = new Grain(str, quantity);
        if (numberOfGrain >= maxGrainAllowed)
            System.err.println("Full");
        else
        {
            grains[numberOfGrain] = grain;
            numberOfGrain = numberOfGrain + 1;
        }
    }

    public Iterator createIterator()
    {
        return new GrainsIterator(grains);
    }
}