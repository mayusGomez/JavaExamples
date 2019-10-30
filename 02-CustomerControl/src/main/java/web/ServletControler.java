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
        
        String action = request.getParameter("action");
        
        if (action != null) {
            switch (action) {
                case "edit":
                    this.customerEdit(request, response);
                    break;
                default:
                    this.defaultAction(request, response);
            }
        } else {
            this.defaultAction(request, response);
        }
    }
    
    
    private void customerEdit(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        CustomerDao customerDao = new CustomerDaoJDBC();
        Customer customer = customerDao.find(new Customer(idCustomer));
        request.setAttribute("customer", customer);
        String jspEdit = "/WEB-INF/pages/customer/editCustomer.jsp";
        request.getRequestDispatcher(jspEdit).forward(request, response);
    }
            
    
    private void defaultAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerDao customerDao = new CustomerDaoJDBC();
        List<Customer> customers = customerDao.select();
        System.out.println("Customers:" + customers);
        /*request.setAttribute("customers", customers);
        request.setAttribute("totalCustomers", customers.size());
        request.setAttribute("totalBalance", this.totalBalance(customers));
        request.getRequestDispatcher("customers.jsp").forward(request, response);
        */
        
        HttpSession session = request.getSession();
        System.out.println("set att");
        session.setAttribute("customers", customers);
        session.setAttribute("totalCustomers", customers.size());
        session.setAttribute("totalBalance", this.totalBalance(customers));
        System.out.println("redirect");
        response.sendRedirect("customers.jsp");
    }


    
    private double totalBalance(List<Customer> customers){
        double totalBalance = 0;
        for (Customer customer: customers){
            totalBalance += customer.getBalance();
        }
        return totalBalance;
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {
        String action = request.getParameter("action");
        System.out.println("doPost: action:" + action);
        if (action != null){
            switch (action) {
                case "insert":
                    this.customerInsert(request, response);
                    break;
                case "modify":
                    this.customerModify(request, response);
                    break;
                case "delete":
                    this.customerDelete(request, response);
                default:
                    this.defaultAction(request, response);
            }
        }else{
            this.defaultAction(request, response);
        }
    }
    
    
    private void customerModify(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String stringBalance = request.getParameter("balance");
        
        double balance = 0;
        if (stringBalance != null && !"".equals(stringBalance)){
            balance = Double.parseDouble(stringBalance);
        }
        
        Customer customer = new Customer(idCustomer, name, lastname, email, phone, balance);
        CustomerDao customerDao = new CustomerDaoJDBC();
        
        //Insert in DB
        int modifiedRows = customerDao.update(customer);
        System.out.println("modifiedRows = " + modifiedRows);

        // Redirect
        this.defaultAction(request, response);
        
    }
    
    private void customerDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
              
        Customer customer = new Customer(idCustomer);
        CustomerDao customerDao = new CustomerDaoJDBC();
        
        //Insert in DB
        int modifiedRows = customerDao.delete(customer);
        System.out.println("delete Rows = " + modifiedRows);

        List<Customer> customers = customerDao.select();
        System.out.println("Customers:" + customers);
        request.setAttribute("customers", customers);
        request.setAttribute("totalCustomers", customers.size());
        request.setAttribute("totalBalance", this.totalBalance(customers));
        request.getRequestDispatcher("customers.jsp").forward(request, response);
        
    }
    
    
    private void customerInsert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario agregarCliente
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        double balance = 0;
        String balanceString = request.getParameter("balance");
        if (balanceString != null && !"".equals(balanceString)) {
            balance = Double.parseDouble(balanceString);
        }

        Customer customer = new Customer(name, lastname, email, phone, balance);  
        
        CustomerDao customerDao = new CustomerDaoJDBC();
        
        //Insert in DB
        int modifiedRows = customerDao.insert(customer);
        System.out.println("modifiedRows = " + modifiedRows);


        // Redirect
        this.defaultAction(request, response);
    }    

}
