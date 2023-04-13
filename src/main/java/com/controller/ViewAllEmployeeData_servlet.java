package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bo.EmpInfoBo;
import com.Dao.EmpDao;

/**
 * Servlet implementation class ViewAllEmployeeData_servlet
 */
@WebServlet("/ViewAllEmployeeData_servlet")
public class ViewAllEmployeeData_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllEmployeeData_servlet() {
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
		pw.print("<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>");
		
		pw.print("<link rel=\"stylesheet\" href=\"css/ViewAllEmployeeDetails.css\">");
		
		List<EmpInfoBo> list=EmpDao.ViewAllEmployeeData();
		
		pw.print("<h2> All Doctor Details</h2>");
		pw.print("<table border='1px solid black'; width='100%'>");
		
		pw.print("<tr> <th>Id </th> <th>Name </th> <th>Email </th> <th>Phone </th> <th>Specialisation </th> <th>Address </th> <th>Edit </th> <th>Delete </th> </tr>");
	  
		for(EmpInfoBo eb:list)
			
			pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getPhone()+"</td><td>"+eb.getspecialisation()+"</td><td>"+eb.getAddress()+"</td><td>"+"<a href='EditServlet2?id="+eb.getId()+"'><button style='font-size:24px'><i class='fas fa-edit'></i></button></a> </td> <td><a href='DeleteServlet?id="+eb.getId()+"'><i class=\"material-icons\" style=\"font-size:30px;color:black\">delete</i> </a></td></tr>");
		
		pw.print("</table>");
		 
	}

}
