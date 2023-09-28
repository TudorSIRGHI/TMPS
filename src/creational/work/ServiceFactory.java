package creational.work;

public class ServiceFactory {
    // Factory patern is used when we have a super class with multiple sub-classes and based on input, we need to return one of the sub-class.
    // Create a function that returns a Work type that you mentioned

    public Work setWork(String work)
    {
        if (work == null || work.isEmpty())
            return null;
        return switch (work) {
            case "Dig" -> new Dig();
            case "Leave" -> new Leave();
            case "Sow" -> new Sow();
            default -> throw new IllegalArgumentException("Unknown work " + work);
        };
    }
}
