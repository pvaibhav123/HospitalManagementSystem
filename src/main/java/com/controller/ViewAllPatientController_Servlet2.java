package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bo.AddpatientBo;
import com.Dao.EmpDao;

/**
 * Servlet implementation class ViewAllPatientController_Servlet2
 */
@WebServlet("/ViewAllPatientController_Servlet2")
public class ViewAllPatientController_Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllPatientController_Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
			
		  
		  int idd= Integer.parseInt(request.getParameter("id"));
		  
		  AddpatientBo eb=EmpDao.getInfopatientById(idd);
		  
		  pw.print("<form  action='updatePatientData_Servlet' method='get'> ");
		    
			pw.print("<table>");
			
			pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
			pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
			pw.print("<tr><td>Date: </td> <td><input type='date' name='date' value='"+eb.getDate()+"'/></td></tr>");
			pw.print("<tr><td>Email-id: </td> <td><input type='email' name='email' value='"+eb.getEmail()+"'/></td></tr>");
		   	pw.print("<tr><td>Phone: </td> <td><input type='text' name='phone' value='"+eb.getPhone()+"'/></td></tr>");
		   	pw.print("<tr><td>Diesease:</td> <td><input type='text' name='diesease' value='"+eb.getdiesease()+"'/></td></tr>");
		   	pw.print("<tr><td>Alloted_doctor:</td> <td><input type='text' name='alloted_doctor' value='"+eb.getAlloted_doctor()+"'/></td></tr>");
		   	pw.print("<tr><td>Registration_fee: </td> <td><input type='text' name='registration_fee' value='"+eb.getRegistration_fee()+"'/></td></tr>");
		    pw.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
		    
		   	pw.print("</table>");
			
			pw.print("</form>");
			
	}

	
}
