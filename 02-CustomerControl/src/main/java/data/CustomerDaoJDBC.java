package data;

import domain.Customer;
import java.sql.*;
import java.util.*;

/**
 *
 * @author agomez
 */
public class CustomerDaoJDBC implements CustomerDao{
    private static final String SQL_SELECT = "SELECT id_customer, name, lastname, email, phone, balance FROM customer";
    private static final String SQL_SELECT_BY_ID = "SELECT id_customer, name, lastname, email, phone, balance FROM customer WHERE id_customer = ?";
    private static final String SQL_INSERT = "INSERT INTO customer (name, lastname, email, phone, balance) values(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE customer SET name=?, lastname=?, email=?, phone=?, balance=? WHERE id_customer = ?";
    private static final String SQL_DELETE = "DELETE from customer WHERE id_customer = ?";

    @Override
    public List<Customer> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Customer customer = null;
        List<Customer> customers = new ArrayList<Customer>();

        try {
            conn = Connect.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCustomer = rs.getInt("id_customer");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                double balance = rs.getDouble("balance");

                customer = new Customer(idCustomer, name, lastname, email, phone, balance);

                customers.add(customer);
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            Connect.close(rs);
            Connect.close(stmt);
            Connect.close(conn);
        }

        return customers;
    }
    
    @Override
    public Customer find(Customer customer){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Connect.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, customer.getIdCustomer());
            rs = stmt.executeQuery();
            rs.absolute(1);  
            
            String name = rs.getString("name");
            String lastname = rs.getString("lastname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            double balance = rs.getDouble("balance");
            
            customer.setName(name);
            customer.setLastname(lastname);
            customer.setEmail(email);
            customer.setPhone(phone);
            customer.setBalance(balance);
            
        } 
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            Connect.close(rs);
            Connect.close(stmt);
            Connect.close(conn);
        }

        return customer;

    }

    @Override
    public int insert(Customer customer) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Connect.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getLastname());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhone());
            stmt.setDouble(5, customer.getBalance());
            
            rows = stmt.executeUpdate();
        } 
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            Connect.close(stmt);
            Connect.close(conn);
        }

        return rows;    
    }

    @Override
    public int update(Customer customer) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Connect.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getLastname());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhone());
            stmt.setDouble(5, customer.getBalance());
            stmt.setInt(6, customer.getIdCustomer());
            
            rows = stmt.executeUpdate();
            
        } 
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            Connect.close(stmt);
            Connect.close(conn);
        }

        return rows;    
    }

    @Override
    public int delete(Customer customer) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Connect.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, customer.getIdCustomer());
            
            rows = stmt.executeUpdate();
            
        } 
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            Connect.close(stmt);
            Connect.close(conn);
        }

        return rows;   
    }
    
    
}
