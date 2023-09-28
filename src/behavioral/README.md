# Author: Sirghi Tudor

----

# Topic: *Behavioral Design Patterns*
## Objectives:
&ensp; &ensp; __1. Study and understand the Behavioral Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.__

&ensp; &ensp; __3. Create a new Project or add some additional functionalities using behavioral design patterns.__

## Theoretical background:
&ensp; &ensp; Behavioral design patterns are a category of design patterns that focus on the interaction and communication between objects and classes. They provide a way to organize the behavior of objects in a way that is both flexible and reusable, while separating the responsibilities of objects from the specific implementation details. Behavioral design patterns address common problems encountered in object behavior, such as how to define interactions between objects, how to control the flow of messages between objects, or how to define algorithms and policies that can be reused across different objects and classes.

&ensp; &ensp; Some examples from this category of design patterns are :

* Chain of Responsibility
* Command
* Interpreter
* Iterator
* Mediator
* Observer
* Strategy

## Implementation

* Introduction

I decided to implement Strategy, Iterator, Observer and Command design patterns.
I created a java simulation of Farm. The Farmers can work manually or on tractors. Also, they
have some functions for working over the ground.
The Iterator iterates the grain that can be planted. Observer notice the actions that farmers executed over the ground.

* Snippets from your files.

* Iterator:

```java
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

```

* Observer:

```java
public class IntroducerObserver implements Observer {

    private String name;
    private Use use;

    public IntroducerObserver(String nm) {
        this.name = nm;
    }

    @Override
    public void update() {
        String msg = (String) use.getUpdate(this);
        if (msg == null) {
            System.out.println(name + ":: No new message");
        } else
            System.out.println(name + ":: Consuming message::" + msg);
    }

    @Override
    public void setSubject(Use sub) {
        this.use = sub;
    }

}
```

* Command:

```java
public class WorkTypeDeterminer {

    public static WorkFunctions getWorkType(WorkFunctions workFunctions) {
        if (workFunctions.getClass().equals(TractorWork.class)) {
            return new TractorWork();
        } else {
            return new HandWork();
        }
    }

}
```

* Strategy:

```java
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
```

Main Class:

```java
public class Main {
    public static void main(String[] args) {
        //Strategy
        GrainStock grainStock = new GrainStock();

        Grain grain1 = new Grain("1234", 10);
        Grain grain2 = new Grain("5678", 40);

        grainStock.addGrain(grain1);
        grainStock.addGrain(grain2);

        //introduce by hand
        grainStock.sow(new HandWork("Serghei", "3 days"));

        //introduce importing file
        grainStock.sow(new TractorWork("12/15", "2 days"));

        //Iterator
        GrainCollection grainCollection = new GrainCollection();
        grainCollection.addGrain("Wheat", 123);
        grainCollection.addGrain("Tobacco", 321);
        GrainClass grainClass = new GrainClass(grainCollection);
        grainClass.printGrainName();

        //Command
        //Creating the receiver object
        TractorWork tractorWork = new TractorWork();
        HandWork handWork = new HandWork();
        WorkFunctions workType = WorkTypeDeterminer.getWorkType(tractorWork);
        WorkFunctions workType1 = WorkTypeDeterminer.getWorkType(handWork);

        //creating command and associating with receiver
        Command loosen = new Loosen(workType);

        //Creating invoker and associating with Command
        FunctionalityInvoker invoker = new FunctionalityInvoker(loosen);

        //perform action on invoker object
        String loosenInvoker = invoker.execute();

        Command dig = new Dig(workType);
        invoker = new FunctionalityInvoker(dig);
        String digtInvoker = invoker.execute();

        Command setMark = new Leave(workType1);
        invoker = new FunctionalityInvoker(setMark);
        String paymentInvoker = invoker.execute();

        //Observer
        //create subject
        GrainSowUse grainSowUse = new GrainSowUse();
        GrainSowUse grainSowUse1 = new GrainSowUse();

        //create observers
        Observer digObserver = new IntroducerObserver("Dig observer ");
        Observer loosenObserver = new IntroducerObserver("Loosen Observer ");


        //register observers to the subject
        grainSowUse.register(digObserver);
        grainSowUse1.register(loosenObserver);


        //attach observer to subject
        digObserver.setSubject(grainSowUse);
        loosenObserver.setSubject(grainSowUse1);

        //check if any update is available
        digObserver.update();
        loosenObserver.update();

        //now send message to subject
        grainSowUse.postMessage(loosenInvoker);
        grainSowUse1.postMessage(paymentInvoker);
    }
}
```

## Conclusion
To sum up, I have created a simple code that implement the 4 design patterns that I have chosen.
In my code I managed to implement somehow 4 behavioral design patterns. Moreover, I managed not only to copy and use them,
but also to interconnect them.