package solid.comapny;

import solid.client.Client;

import java.util.ArrayList;
import java.util.List;
//Open-Closed Principle (We added EmployeeManagement and ITCompany)
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