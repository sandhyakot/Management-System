package controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ValidatorDao;
import model.User;


/**
 * Servlet implementation class Validator
 */
@WebServlet("/Validator")
public class Validator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public Validator() {
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		//create session
		HttpSession session= request.getSession();
		//set session attribute Sessionid  
		session.setAttribute("SessionId", session.getId());

		User u = null;
		ValidatorDao vDao =new ValidatorDao();
		int empId=Integer.parseInt(request.getParameter("empid"));
		String password=request.getParameter("password");
		//check for user name validation 
		u = vDao.validate(empId);
		//set employee attribute into session to be used in every page
		session.setAttribute("user", u);

		if(u!=null)//if object not null
		{
			System.out.println(password.equals(u.getPassword()));
			System.out.println(u.getPassword());
			System.out.println(password);
			if(!password.equals(u.getPassword()))
			{
				System.out.println("fjk");
				request.setAttribute("msg", "Wrong Password Retry...");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else{
				if("A".equalsIgnoreCase(u.getRole()))
				{
					response.sendRedirect("Admin.jsp");


				}
				else
				{
					response.sendRedirect("User.jsp");


				}
			}

		}
		else
		{
			request.setAttribute("msg", "Either Wrong id /You are Not registered....");



			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);

		}

	} 



}

