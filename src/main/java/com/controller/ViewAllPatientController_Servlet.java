package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import com.Bo.AddpatientBo;
import com.Bo.EmpInfoBo;
import com.Dao.EmpDao;

/**
 * Servlet implementation class ViewAllPatientController_Servlet
 */
@WebServlet("/ViewAllPatientController_Servlet")
public class ViewAllPatientController_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllPatientController_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		
		
		pw.print("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">");
		pw.print("<link rel=\"stylesheet\" href=\"css/ViewAllPatientDetails.css\">");
		
		List<AddpatientBo> list=EmpDao.ViewAllPatientData();
		
		pw.print("<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>");
		
		pw.print("<h2> All Patient Details</h2>");
		pw.print("<table border='1px solid black'; width='100%'>");
		
		pw.print("<tr> <th>Id</th> <th>Full Name</th> <th>Date</th> <th>Email-id</th> <th>Phone</th> <th>Diesease</th> <th>Alloted Doctor</th> <th>Registration Fee</th> <th>Edit</th> <th>Delete</th> </tr>");

		
		for(AddpatientBo eb:list)
			
			pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getDate()+"</td></td><td>"+eb.getEmail()+"</td><td>"+eb.getPhone()+"</td><td>"+eb.getdiesease()+"</td><td>"+eb.getAlloted_doctor()+"</td><td>"+eb.getRegistration_fee()+"</td><td>"+"<a href='ViewAllPatientController_Servlet2?id="+eb.getId()+"'><button style='font-size:24px'><i class='fas fa-edit'></i></button></a> </td> <td><a href='DeletePatientDetails_Servlet?id="+eb.getId()+"'><i class=\"material-icons\" style=\"font-size:30px;color:black\">delete</i> </a></td></tr>");
		
		pw.print("</table>");

	}
	
	

}
