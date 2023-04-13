package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bo.EmpInfoBo;
import com.Dao.EmpDao;

/**
 * Servlet implementation class AddEmpController_servlet
 */
@WebServlet("/AddEmpController_servlet")
public class AddEmpController_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpController_servlet() {
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
		String specialisation=request.getParameter("specialisation");
		String address=request.getParameter("address");
		
		EmpInfoBo eb=new EmpInfoBo(name,email,phone,specialisation,address);
		
		int status=EmpDao.Addemp(eb);
		
		if(status>0)
		{
			pw.print("<script>alert('Data has been Successfully updated')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("home.html");
			rd.forward(request, response);	
		}
		else {
			pw.print("<script>alert('Data has been Successfully updated')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("login_page.html");
			rd.include(request, response);	
			
		}
	}

}
