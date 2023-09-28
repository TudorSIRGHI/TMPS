package behavioral;

import behavioral.command.WorkTypeDeterminer;
import behavioral.command.ground_work.*;
import behavioral.command.work.HandWork;
import behavioral.command.work.TractorWork;
import behavioral.command.work.WorkFunctions;
import behavioral.iterator.GrainClass;
import behavioral.iterator.GrainCollection;
import behavioral.observer.IntroducerObserver;
import behavioral.observer.Observer;
import behavioral.observer.GrainSowUse;
import behavioral.strategy.GrainStock;
import behavioral.strategy.Grain;

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

