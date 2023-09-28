package behavioral.observer;

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