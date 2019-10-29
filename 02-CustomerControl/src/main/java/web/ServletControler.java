/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import data.*;
import domain.Customer;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author agomez
 */
@WebServlet(name = "ServletControler", urlPatterns = {"/ServletControler"})
public class ServletControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {
        CustomerDao customerDao = new CustomerDaoJDBC();
        List<Customer> customers = customerDao.select();
        System.out.println("Customer:" + customers);
        request.setAttribute("customers", customers);
        request.setAttribute("totalCustomers", customers.size());
        request.setAttribute("totalBalance", this.totalBalance(customers));
        request.getRequestDispatcher("customers.jsp").forward(request, response);
    }
    
    private double totalBalance(List<Customer> customers){
        double totalBalance = 0;
        for (Customer customer: customers){
            totalBalance += customer.getBalance();
        }
        return totalBalance;
    }

}
