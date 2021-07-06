package com.dell.webapp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dell.webapp.model.Product;
import com.dell.webapp.util.HibernateSessionUtil;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

/**
 * Servlet implementation class InitializeSession
 */
@WebServlet("/list-product")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ListProduct() { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		
		// build hibernate session factory
		try {
			// 1. load session factory 
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();
			
			// 2. create a session
			Session session = factory.openSession();
			
			// 3. read product data
			List<Product> products = session.createQuery("from Product").list();
			
			//show data as table
			out.print("<h1> Product List :- </h1>");
			out.print("<style> table,td,th {"
					+ "border:2px solid red;"
					+ "padding: 10px; "
					+ "}</style>");
				out.print("<table >");
				out.print("<tr>");
				out.print("<th> Product Id</th>");
				out.print("<th> Product Name</th>");
				out.print("<th> Product Price</th>");
				out.print("<th> CreateAt </th>");
				out.print("<th> Modified </th>");
				out.print("</tr>");
			for(Product p: products) {
				out.print("<tr>");
				out.print("<td>"+p.getId()+"</td>");
				out.print("<td>"+p.getName()+"</td>");
				out.print("<td>"+p.getPrice()+"</td>");
				out.print("<td>"+p.getCreatedAt()+"</td>");
				out.print("<td>"+p.getModifiedAt()+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
			
			// close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
