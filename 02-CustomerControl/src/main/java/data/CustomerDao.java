package data;

import domain.Customer;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author agomez
 */
public interface CustomerDao {
    public List<Customer> select();
    
    public Customer find(Customer customer);
    
    public int insert(Customer customer);
    
    public int update(Customer customer);
    
    public int delete(Customer customer);
}
