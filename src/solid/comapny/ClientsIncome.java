package solid.comapny;

import solid.client.Client;
//Open-Closed Principle (We added ProstituteIncome and IncomeCalculate)
public class ClientsIncome implements IncomeCalculate {
    @Override
    public int calculateSalary(Client client) {
        return client.getIncome()* client.getNumberOfTasks();
    }
}