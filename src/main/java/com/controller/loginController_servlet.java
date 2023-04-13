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
 * Servlet implementation class loginController_servlet
 */
@WebServlet("/loginController_servlet")
public class loginController_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String confirm=request.getParameter("confirm");
		
		boolean status=false;
		
		status=EmpDao.loginvalidate(email, password, confirm);
		
		if(status)
		{
			RequestDispatcher rd=request.getRequestDispatcher("home.html");
		   rd.forward(request, response);
		}
		else
		{
			pw.print("<script> alert('invalid username and password !!')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("login_page.html");
			rd.include(request, response);
		}
		
	}

}
