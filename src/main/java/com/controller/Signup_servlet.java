package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bo.EmpBo;
import com.Dao.EmpDao;

/**
 * Servlet implementation class Signup_servlet
 */
@WebServlet("/Signup_servlet")
public class Signup_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		String confirm=request.getParameter("confirm");
		
		EmpBo eb=new EmpBo(name,email,phone,password,confirm);
		
		int status=EmpDao.save(eb);
		
		if(status>0)
		{
			pw.print("<script> alert('You have successfully signed up')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("login_page.html");
			rd.forward(request, response);	
		}
		else
		{
			pw.print("<script>alert('Sorry Something went wrong!!!')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("login_page.html");
			rd.include(request, response);	
		}
		
	//	pw.print("Name:"+name+" Email id:"+email+" Password:"+password);
		
//		pw.print("Name"+name);
//		pw.print("Email id: "+email);
//		pw.print("Password: "+password);
	}

}
