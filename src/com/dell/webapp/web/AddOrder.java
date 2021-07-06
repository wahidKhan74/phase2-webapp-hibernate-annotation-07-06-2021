package com.dell.webapp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dell.webapp.model.Order;
import com.dell.webapp.model.Product;
import com.dell.webapp.model.ProductDetail;
import com.dell.webapp.util.HibernateSessionUtil;


/**
 * Servlet implementation class InitializeSession
 */
@WebServlet("/add-order")
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AddOrder() { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("add-order.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		
		//get order params
		String orderName = request.getParameter("orderName");
		double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
		String customerName = request.getParameter("customerName");
		String customerPhone = request.getParameter("customerPhone");
		
		//get product details
		String productOneName = request.getParameter("product1_name");
		double productOnePrice = Double.parseDouble(request.getParameter("product1_price"));
		
		String productTwoName = request.getParameter("product2_name");
		double productTwoPrice = Double.parseDouble(request.getParameter("product2_price"));
	
		
		
		// build hibernate session factory
		try {
			// 1. load session factory 
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();
			
			// 2. create a session
			Session session = factory.openSession();
			
			// 3. begin transaction
			Transaction tx = session.beginTransaction();
			
			// 4. create a Order object
			Order order = new Order(orderName, totalPrice, customerName, customerPhone);
			
			Set<Product> products = new HashSet<Product>();
					
			Product product1 = new Product(productOneName, productOnePrice);
			Product product2 = new Product(productTwoName, productTwoPrice);
			products.add(product1);
			products.add(product2);
			
			// add product to order
			order.setProducts(products);
			
			
			// 5. save product object
			session.save(order);
			
			// 6. commit transaction
			tx.commit();
			
			if(session != null) {
				out.print("<h3 style='color:green'> Order is created with product details sucessfully ! </h3>");
			}
			// close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
		}
	}

}
