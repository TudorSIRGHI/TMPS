# Author: Sirghi Tudor

----

# Topic: *SOLID PRINCIPLES*
## Objectives:


&ensp; &ensp; __1. Study and understand the SOLID Principles.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp;__3. Create a sample project that respects SOLID Principles.__

## Implementation

* Introduction

I have have created a simulation of an Bussiness office  with clients, the class to count their income.

* Snippets from your files.

* S -> Single Responsibility:
```java
public class Client {
    private String name;
    private int numberOfTasks;
    private int income;

    public Client(String name, int numberOfTasks, int income) {
        this.name = name;
        this.numberOfTasks = numberOfTasks;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfTasks(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
```
* O -> Open Close:

I have added ClientIncome and IncomeCalculate.

* L -> Liskov Substitution:
```java
Client cheapClient = new CheapClient("Valeriu", 10, 100, 2);
Client expensiveClient = new ExpensiveClient("Jana", 8, 200, 2);
```
* I -> Interface Segregation:
```java
IncomeCalculate clientsIncome = new ClientsIncome();
```

* D -> Dependency Inversion:
```java
public class BusinessComapny implements ClientActions {
    private List<Client> clients;

    //Dependency Inversion
    private IncomeCalculate incomeCalculate;

    public BusinessComapny(IncomeCalculate incomeCalculate) {
        clients = new ArrayList<>();
        //dependency injection in the constructor
        this.incomeCalculate = incomeCalculate;
    }

    @Override
    public void work(Client client) {
        clients.add(client);
    }

    @Override
    public void paySalaries() {
        for (Client client : clients) {
            System.out.println(client.getName() + " " + incomeCalculate.calculateSalary(client));
        }
    }
}
```

## Conclusion
To sum up, I have created a simulation of Business company that have clients and the unction to count their income.
In my code I managed to implement somehow all SOLID principles and I learned all tactics used in the SOLID design principles.