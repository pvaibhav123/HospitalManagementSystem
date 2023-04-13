package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.EmpDao;

/**
 * Servlet implementation class DeletePatientDetails_Servlet
 */
@WebServlet("/DeletePatientDetails_Servlet")
public class DeletePatientDetails_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePatientDetails_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
int id=Integer.parseInt(request.getParameter("id"));
		
		int status=EmpDao.Deletepatientdata(id);
		
		if(status>0)
		{
			pw.print("<script> alert('Your data has been successfully deleted')</script>");
		    RequestDispatcher rd=request.getRequestDispatcher("ViewAllPatientController_Servlet");
		    rd.forward(request, response);
		}
		else
		{
			pw.print("<script> alert('Something went wront try again!!!')</script>");
		    RequestDispatcher rd=request.getRequestDispatcher("ViewAllPatientController_Servlet");
		    rd.include(request, response);
		}
		
	}

}
