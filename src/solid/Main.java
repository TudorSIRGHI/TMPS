package solid;

import solid.comapny.ClientsIncome;
import solid.comapny.ClientActions;
import solid.comapny.BusinessComapny;
import solid.comapny.IncomeCalculate;
import solid.client.CheapClient;
import solid.client.ExpensiveClient;
import solid.client.Client;

public class Main {
    public static void main(String[] args) {
        //interface segregation
        IncomeCalculate clientsIncome = new ClientsIncome();
        ClientActions businessComapny = new BusinessComapny(clientsIncome);

        //Liskov Substitution
        Client cheapClient = new CheapClient("Valeriu", 10, 100, 2);
        Client expensiveClient = new ExpensiveClient("Jana", 8, 200, 2);

        businessComapny.work(cheapClient);
        businessComapny.work(expensiveClient);

        businessComapny.paySalaries();
    }
}
