package structural;

import structural.adapter.PlaneAction;
import structural.adapter.TankAdapter;
import structural.adapter.Plane;
import structural.bridge.*;
import structural.composite.GunBuilding;
import structural.composite.HeavyGun;
import structural.composite.Gun;
import structural.composite.SmallGun;
import structural.decorator.*;
import structural.decorator.Tank;
import structural.decorator.MiddleTank;

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
