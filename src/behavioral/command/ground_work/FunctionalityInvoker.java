package behavioral.command.ground_work;

public class FunctionalityInvoker {

    public Command command;

    public FunctionalityInvoker(Command c) {
        this.command = c;
    }

    public String execute() {
        return this.command.execute();
    }
}
