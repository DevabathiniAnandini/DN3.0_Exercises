interface CustomerRepository {
    Customer findCustomerById(String customerId);
}

 class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String customerId) {
        return new Customer(customerId, "John Doe");
    }
}
 class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
 class CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(String customerId) {
        return customerRepository.findCustomerById(customerId);
    }
}
public class DependencyInjection {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);
        Customer customer = customerService.getCustomerById("1");
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Name: " + customer.getName());
    }
}
