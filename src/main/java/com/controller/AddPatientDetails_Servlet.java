package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bo.AddpatientBo;
import com.Dao.EmpDao;

/**
 * Servlet implementation class AddPatientDetails_Servlet
 */
@WebServlet("/AddPatientDetails_Servlet")
public class AddPatientDetails_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatientDetails_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
		String name=request.getParameter("name");
		String date=request.getParameter("date");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String diesease=request.getParameter("diesease");
		String alloted_doctor=request.getParameter("alloted_doctor");
		int registration_fee=Integer.parseInt(request.getParameter("registration_fee"));
		System.out.println(registration_fee);
		
		AddpatientBo eb=new AddpatientBo(name,date,email,phone,diesease,alloted_doctor,registration_fee);
		
		int status=EmpDao.Addpatientdata(eb);
		
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


