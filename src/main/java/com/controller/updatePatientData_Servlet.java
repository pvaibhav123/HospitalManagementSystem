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
import com.Bo.EmpInfoBo;
import com.Dao.EmpDao;

/**
 * Servlet implementation class updatePatientData_Servlet
 */
@WebServlet("/updatePatientData_Servlet")
public class updatePatientData_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePatientData_Servlet() {
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
		String date=request.getParameter("date");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String diesease=request.getParameter("diesease");
		String alloted_doctor=request.getParameter("alloted_doctor");
        int register=Integer.parseInt(request.getParameter("registration_fee"));
		
		
        AddpatientBo eb=new AddpatientBo(id,name,date,email,phone,diesease,alloted_doctor,register);
		
		int  status=EmpDao.updatepatientdata(eb);
		
		if(status>0)
		{
			pw.print("<script>alert('Your data has been successfully updated')</script>" );
			RequestDispatcher rd=request.getRequestDispatcher("ViewAllPatientController_Servlet");
			rd.forward(request, response);
			
		}
		else
		{
			pw.print("<script>alert('Something went wrong please try again!!!!')</script>" );
			RequestDispatcher rd=request.getRequestDispatcher("ViewAllPatientController_Servlet");
			rd.include(request, response);

		}
	}

	
}
