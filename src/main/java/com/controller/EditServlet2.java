package com.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bo.EmpInfoBo;
import com.Dao.EmpDao;

/**
 * Servlet implementation class EebtServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
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
		  
		  EmpInfoBo eb=EmpDao.getInfoById(idd);
		  
		  pw.print("<form  action='UpdateController_Servlet' method='get'> ");
		    
			pw.print("<table>");
			
			pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
			pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
			pw.print("<tr><td>Email-id: </td> <td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
		   	pw.print("<tr><td>Phone: </td> <td><input type='text' name='phone' value='"+eb.getPhone()+"'/></td></tr>");
		   	pw.print("<tr><td>Specialisation:</td> <td><input type='text' name='specialisation' value='"+eb.getspecialisation()+"'/></td></tr>");
		   	pw.print("<tr><td>Address:</td> <td><input type='text' name='address' value='"+eb.getAddress()+"'/></td></tr>");
		    pw.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
		    
		   	pw.print("</table>");
			
			pw.print("</form>");
			
			
	
	}
	
}
		
		
	

	


