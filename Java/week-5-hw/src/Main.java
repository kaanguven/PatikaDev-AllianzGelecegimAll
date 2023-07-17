import model.Customer;
import model.CustomerTypeEnum;
import service.AccidentService;
import service.CustomerService;

public class Main {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();

        Customer customer1 = customerService.createCustomer("Ufuk", CustomerTypeEnum.INDIVIDUAL);

        System.out.println(customer1);
    }
}