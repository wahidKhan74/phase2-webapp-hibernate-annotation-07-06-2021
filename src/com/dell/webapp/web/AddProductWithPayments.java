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
import com.dell.webapp.model.Payment;
import com.dell.webapp.model.Product;
import com.dell.webapp.model.ProductDetail;
import com.dell.webapp.util.HibernateSessionUtil;

/**
 * Servlet implementation class InitializeSession
 */
@WebServlet("/add-product-with-payments")
public class AddProductWithPayments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddProductWithPayments() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("add-product-with-payments.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);

		// get product details
		String productName = request.getParameter("name");
		double productPrice = Double.parseDouble(request.getParameter("price"));

		// payments 1
		String paymentOneCustomer = request.getParameter("customerName1");
		double paymentOnePrice = Double.parseDouble(request.getParameter("price1"));

		// payments 2
		String paymentTwoCustomer = request.getParameter("customerName2");
		double paymentTwoPrice = Double.parseDouble(request.getParameter("price2"));

		// build hibernate session factory
		try {
			// 1. load session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();

			// 2. create a session
			Session session = factory.openSession();

			// 3. begin transaction
			Transaction tx = session.beginTransaction();

			// 4. create a products object
			Product product = new Product(productName, productPrice);

			Payment paymentOne = new Payment(paymentOneCustomer, paymentOnePrice) ;
			
			Payment paymentTwo = new Payment(paymentTwoCustomer, paymentTwoPrice) ;

			Set<Payment> payments = new HashSet<>();
			payments.add(paymentOne);
			payments.add(paymentTwo);
			
			
			//add many payments to product
			product.setPayments(payments);
			
			// 5. save product object
			session.save(product);

			// 6. commit transaction
			tx.commit();

			if (session != null) {
				out.print("<h3 style='color:green'> Products is created with payments details sucessfully ! </h3>");
			}
			// close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>" + e);
		}
	}

}
