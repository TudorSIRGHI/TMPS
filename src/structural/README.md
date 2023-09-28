# Author: Sirghi Tudor

----

# Topic: *Structural Design Patterns*
## Objectives:
&ensp; &ensp; __1. Study and understand the Structural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

&ensp; &ensp; __3. Implement some additional functionalities, or create a new project using structural design patterns.__

## Theoretical background:
&ensp; &ensp; Structural design patterns are a category of design patterns that focus on the composition of classes and objects to form larger structures and systems. They provide a way to organize objects and classes in a way that is both flexible and efficient, while allowing for the reuse and modification of existing code. Structural design patterns address common problems encountered in the composition of classes and objects, such as how to create new objects that inherit functionality from existing objects, how to create objects that share functionality without duplicating code, or how to define relationships between objects in a flexible and extensible way.

&ensp; &ensp; Some examples of from this category of design patterns are:

* Adapter
* Bridge
* Composite
* Decorator
* Facade
* Flyweight
* Proxy

## Implementation

* Introduction

I decided to implement Adapter, Bridge, Composite and Decorator design patterns.
I created a java program where there is are Planes and Tanks and they have motors and guns, then we adapt tank to plane .

* Snippets from your files.

* Adapter:

```java
public class TankAdapter implements PlaneAction {
    Tank tank;
    public TankAdapter(Tank tank) {
        this.tank = tank;
    }

    public void fly() {
        tank.shot();
    }
}

```

* Bridge:

```java
public abstract class MotorBridge {
    protected Motor motor;

    public MotorBridge(Motor motor){
        this.motor = motor;
    }

    abstract public int addVolume();
}
```

* Composite:

```java
public class GunBuilding {
    private int price;

    public GunBuilding(int price) {
        this.price = price;
    }

    private List<Gun> guns = new ArrayList<>();

    public void add(Gun s){
        this.guns.add(s);
    }

    public void remove(Gun s){
        guns.remove(s);
    }

    public int getPrice() {
        return price * guns.size();
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
```

* Decorator:

```java
public class TankDecorator implements Tank {
    protected Tank tank;

    public TankDecorator(Tank c) {
        this.tank = c;
    }

    @Override
    public void shot() {
        System.out.println("Shot");
    }

    @Override
    public int speed() {
        return this.tank.speed();
    }

}
```

Main class:

```java
 public class Main {
    public static void main(String[] args) {
        //Bridge
        MotorBridge motorUpgrade = new MotorUpgrade(new SimpleMotor(), 100);
        motorUpgrade.addVolume();

        MotorBridge motorExtraUpgrade = new MotorExtraUpgrade(new TurbineMotor(), 200);
        motorExtraUpgrade.addVolume();

        //Composite
        Gun smallGun = new SmallGun();
        Gun smallGun1 = new SmallGun();
        Gun heavyGun = new HeavyGun();

        GunBuilding gunBuilding = new GunBuilding(100);
        gunBuilding.add(smallGun1);
        gunBuilding.add(smallGun1);
        gunBuilding.add(heavyGun);
        gunBuilding.add(smallGun);
        gunBuilding.add(heavyGun);


//        Decorator
        Tank tank = new MiddleTank(new SmallTank("Fat Helga", 50, gunBuilding), 10);
        System.out.println(tank.speed());

        Tank tank1 = new MiddleTank(new GiantTank(new SmallTank("Florentia", 40, gunBuilding), 10), 15);
        System.out.println(tank1.speed());

//        Adapter
        PlaneAction PlaneAction = new Plane(motorExtraUpgrade, 500);
        PlaneAction tankAdapter = new TankAdapter(tank);
        tankAdapter.fly();
    }
}
```
## Conclusion
To sum up, I have created a simple code that implement the 4 design patterns that I have chosen.
In my code I managed to implement somehow 4 structural design patterns. Moreover, I managed not only to copy and use them,
but also to interconnect them.