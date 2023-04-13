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
 * Servlet implementation class UpdateController_Servlet
 */
@WebServlet("/UpdateController_Servlet")
public class UpdateController_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController_Servlet() {
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
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String specialisation=request.getParameter("specialisation");
		String address=request.getParameter("address");
		
		EmpInfoBo eb=new EmpInfoBo(id,name,email,phone,specialisation,address);
		
		int  status=EmpDao.updateEmployee(eb);
		
		if(status>0)
		{
			pw.print("<script>alert('Your data has been successfully updated')</script>" );
			RequestDispatcher rd=request.getRequestDispatcher("ViewAllEmployeeData_servlet");
			rd.include(request, response);
			
		}else
		{
			pw.print("<script>alert('Something went wrong please try again!!!!')</script>" );
			RequestDispatcher rd=request.getRequestDispatcher("ViewAllEmployeeData_servlet");
			rd.include(request, response);

		}
		
	}

	
}
