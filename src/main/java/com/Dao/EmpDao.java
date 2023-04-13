
package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bo.AddpatientBo;
import com.Bo.EmpBo;
import com.Bo.EmpInfoBo;
import com.mysql.cj.exceptions.RSAException;

public class EmpDao 
{
   public static Connection getConnection()
   {
	   Connection con=null;
	   
	   try {
		   
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   String url="jdbc:mysql://localhost:3306/Hospital_Management_System";
		   String username="root";
		   String password="1234";
		   con=DriverManager.getConnection(url,username,password);
		   
	   }catch(Exception e)
	   {
		   System.out.println(e);
	   }  
	   
	   return con;
   }
   public static int save(EmpBo eb)
   {
	   int status=0;
	   
	   try
	   {
		   Connection con=EmpDao.getConnection();
		   String query="insert into signup(name,email,phone,password,confirm) values(?,?,?,?,?)";
		   
		   PreparedStatement ps=con.prepareStatement(query);
		   ps.setString(1, eb.getName());
		   ps.setString(2, eb.getEmail());
		   ps.setString(3, eb.getPhone());
		   ps.setString(4, eb.getPassword());
		   ps.setString(5, eb.getConfirm());
		   
		   status=ps.executeUpdate();
		   
	   }catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   
	   
	   return status;
   }
   public static boolean loginvalidate(String email,String password,String confirm)
   {
	   boolean status=false;
	   
	   try {
		   
		   Connection con=EmpDao.getConnection();
		   
		   String sql="select * from signup where email=? and password=? and confirm=?";
		   
		   PreparedStatement ps=con.prepareStatement(sql);
		   ps.setString(1, email);
		   ps.setString(2, password);
		   ps.setString(3, confirm);
		   ResultSet rs=ps.executeQuery();
		   status=rs.next();
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   
	   return status;
   }
   
   public static int Addemp(EmpInfoBo eb) 
   {
	   int status =0;
	   
	   try {
		   
		   Connection con=EmpDao.getConnection();
		   String sql="insert into Addemp(name,email,phone,specialisation,address) values(?,?,?,?,?)";
		   
		   PreparedStatement  ps=con.prepareStatement(sql);
		   ps.setString(1, eb.getName());
		   ps.setString(2, eb.getEmail());
		   ps.setString(3, eb.getPhone());
		   ps.setString(4, eb.getspecialisation());
		   ps.setString(5, eb.getAddress());
		   
		  status= ps.executeUpdate();
	      } 
	   catch (Exception e)
	   {
		System.out.println(e);
	}
	   
	   return status;
   }
   public static List ViewAllEmployeeData()
   {
	   List<EmpInfoBo> list=new ArrayList<>();
	   
	   try {
		   Connection con=EmpDao.getConnection();
		   String sql="select * from Addemp";
		   PreparedStatement ps=con.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   
		   while(rs.next())
		   {
			   EmpInfoBo eb=new EmpInfoBo();
			   eb.setId(rs.getInt(1));
			   eb.setName(rs.getString(2));
			   eb.setEmail(rs.getString(3));
			   eb.setPhone(rs.getString(4));
			   eb.setspecialisation(rs.getString(5));
			   eb.setAddress(rs.getString(6));
			   
			   list.add(eb);
		   }
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   
	   return list;
   }
   public static EmpInfoBo getInfoById(int idd)
   {
	   EmpInfoBo eb=new EmpInfoBo();
	   
	   int status=0;
	   
	   
	   
	   try {
		   Connection con=EmpDao.getConnection();
		   String sql="select * from Addemp where id=?";
		   PreparedStatement ps=con.prepareStatement(sql);
		   ps.setInt(1, idd);
		   ResultSet rs=ps.executeQuery();
		   
		   
		   if(rs.next())
		   {
			   eb=new EmpInfoBo();
			   
			   eb.setId(rs.getInt(1));
			   eb.setName(rs.getString(2));
			   eb.setEmail(rs.getString(3));
				  eb.setPhone(rs.getString(4));
				  eb.setspecialisation(rs.getString(5));
				  eb.setAddress(rs.getString(6));
				  
		   }
		   
	   }catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   
	   return eb;
   }
   public static int updateEmployee(EmpInfoBo eb)
   {
	   int status=0;
	   
	   
	   try {
		   Connection con=EmpDao.getConnection();
		   
		   String sql="update Addemp set name=?, email=?, phone=?, specialisation=?, address=? where id=?";
		   
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, eb.getName());
		ps.setString(2, eb.getEmail());
		ps.setString(3, eb.getPhone());
		ps.setString(4, eb.getspecialisation());
		ps.setString(5, eb.getAddress());
		ps.setInt(6, eb.getId());
		
		status=ps.executeUpdate();
		
	} catch (Exception e) {
		
		System.out.println(e);
	}
	     
	   
	   return status;
   }
   public static int DeleteEmployeeData(int id)
   {
	   int status=0;
	   
	   try {
		   Connection con=EmpDao.getConnection();
		   String sql="delete from Addemp where id=?";
		   PreparedStatement ps=con.prepareStatement(sql);
		   ps.setInt(1, id);
		    status=ps.executeUpdate();
		      
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   
	   
	   
	   return status;
   }
   public static int Addpatientdata(AddpatientBo eb)
   {
	   int status=0;
	   
	   try {
		   Connection con=EmpDao.getConnection();
		   String sql="insert into Addpatient(name,date,email,phone,diesease,alloted_doctor,registration_fee) values(?,?,?,?,?,?,?)";
		   
		   PreparedStatement ps=con.prepareStatement(sql);
		   ps.setString(1, eb.getName());
		   ps.setString(2, eb.getDate());
		   ps.setString(3, eb.getEmail());
		   ps.setString(4, eb.getPhone());
		   ps.setString(5, eb.getdiesease());
		   ps.setString(6, eb.getAlloted_doctor());
		   ps.setInt(7, eb.getRegistration_fee());
		   
		   status= ps.executeUpdate();
		   
	   }catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   
	   return status;
	   
   }
   public static List ViewAllPatientData()
   {
      List<AddpatientBo> list=new ArrayList<>();
	   
	   try {
		   Connection con=EmpDao.getConnection();
		   String sql="select * from Addpatient";
		   PreparedStatement ps=con.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   
		   while(rs.next())
		   {
			   AddpatientBo eb=new AddpatientBo();
			    
			   eb.setId(rs.getInt(1));
			   eb.setName(rs.getString(2));
			   eb.setDate(rs.getString(3));
			   eb.setEmail(rs.getString(4));
			   eb.setPhone(rs.getString(5));
			   eb.setdiesease(rs.getString(6));
			   eb.setAlloted_doctor(rs.getString(7));
			   eb.setRegistration_fee(rs.getInt(8));
			   
			   list.add(eb);
		   }
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   
	   return list;
   }
   
   public static AddpatientBo getInfopatientById(int id)
   {
	   AddpatientBo eb=new AddpatientBo();
	   
	   int status=0;
	   
	   
	   
	   try {
		   Connection con=EmpDao.getConnection();
		   String sql="select * from Addpatient where id=?";
		   PreparedStatement ps=con.prepareStatement(sql);
		   ps.setInt(1, id);
		   ResultSet rs=ps.executeQuery();
		   
		   
		   if(rs.next())
		   {
			   eb=new AddpatientBo();
			   
			   eb.setId(rs.getInt(1));
			   eb.setName(rs.getString(2));
			   eb.setDate(rs.getString(3));
			   eb.setEmail(rs.getString(4));
			   eb.setPhone(rs.getString(5));
			   eb.setdiesease(rs.getString(6));
			   eb.setAlloted_doctor(rs.getString(7));
			   eb.setRegistration_fee(rs.getInt(8));
				  
		   }
		   
	   }catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   
	   return eb; 
   }
   
   
   public static int updatepatientdata(AddpatientBo eb)
   {
	   int status=0;
	   
	   
	   try {
		   Connection con=EmpDao.getConnection();
		   
		   String sql="update Addpatient set name=?, date=?, email=?, phone=?, diesease=?, alloted_doctor=?, registration_fee=? where id=?";
		   
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, eb.getName());
		ps.setString(2, eb.getDate());
		ps.setString(3, eb.getEmail());
		ps.setString(4, eb.getPhone());
		ps.setString(5, eb.getdiesease());
		ps.setString(6, eb.getAlloted_doctor());
		ps.setInt(7, eb.getRegistration_fee()); 
		ps.setInt(8, eb.getId());
		
		status=ps.executeUpdate();
		
	} catch (Exception e) {
		
		System.out.println(e);
	}
	     
	   
	   return status;
   }
   public static int Deletepatientdata(int id)
   {
int status=0;
	   
	   try {
		   Connection con=EmpDao.getConnection();
		   String sql="delete from Addpatient where id=?";
		   PreparedStatement ps=con.prepareStatement(sql);
		   ps.setInt(1, id);
		    status=ps.executeUpdate();
		      
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
	     
	   return status;
   }
}
   

