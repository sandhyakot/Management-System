package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookAppointmentDao;
import dao.RegisterDao;
import model.Appointment;
import model.User;

/**
 * Servlet implementation class BookAppointment
 */
@WebServlet("/BookAppointment")
public class BookAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		//Register DAO
		BookAppointmentDao rdao=new BookAppointmentDao();
		HttpSession session= request.getSession();
		//set session attribute Sessionid  
		System.out.println(session);
		System.out.println(session.getAttribute("user"));
		//getting parameters from Register.jsp page
		User ur=(User) session.getAttribute("user");
		int empid=(Integer)(ur.getEmpid());
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		System.out.println(time);
		
		
		
		Appointment u = new Appointment(empid, date, time,"pending");//"U" user only can register
		int row = 0;

		try 
		{
			row=rdao.bookappointment(u);//Inserting employee object into database

		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		if(row!=0)//if successfully registered 
		{
			request.setAttribute("Msg", "Your appointment is successfully registered ");
			RequestDispatcher rd=request.getRequestDispatcher("User.jsp");
			rd.forward(request, response);
		}
		else//if registration failed
		{
			request.setAttribute("registerMsg", "Unable to register, please try again...");
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		}
	}

}
