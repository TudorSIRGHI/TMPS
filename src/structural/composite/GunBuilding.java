package structural.composite;

import java.util.ArrayList;
import java.util.List;

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
