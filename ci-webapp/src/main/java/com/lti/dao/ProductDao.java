package com.lti.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lti.dao.util.ConnManager;
import com.lti.entity.Product;

public class ProductDao {
	public Product select(int id) {
		Connection conn=null;
		PreparedStatement stmt =null;
		ResultSet rs=null;
		try {
			conn=ConnManager.connect();
			System.out.println("Connection Successful");
			String sql="SELECT * From tbl_product where id= ?";
		    stmt = conn.prepareStatement(sql);
		    stmt.setInt(1,id);
		    rs=stmt.executeQuery();
		    if(rs.next()) {     //Agar multiple rows then if ki gajah while
		    	Product product= new Product();
		    	product.setId(rs.getInt("id"));
		    	product.setName(rs.getString("name"));
		    	product.setPrice(rs.getDouble("price"));
		    	return product;
		    }
		    return null;//very bad should throw3 n exception indicating that no product found
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
			}
		finally {
			try {conn.close();} catch(Exception e) { }
		}
		
	}
	
	public List<Product> selectAll(){
		
		Connection conn=null;
		PreparedStatement stmt =null;
		ResultSet rs=null;
		try {
			conn=ConnManager.connect();
			System.out.println("Connection Successful");
			String sql="SELECT * From tbl_product";
		    stmt = conn.prepareStatement(sql);
		    rs=stmt.executeQuery();
		    List<Product> list=new ArrayList<>();
		    while(rs.next()) {     
		    	Product product= new Product();
		    	product.setId(rs.getInt("id"));
		    	product.setName(rs.getString("name"));
		    	product.setPrice(rs.getDouble("price"));
		    	list.add(product);
		    }
		    return list;//very bad should throw n exception indicating that no product found
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
			}
		finally {
			try {conn.close();} catch(Exception e) { }
		}
			
		}
		
	
	public void insert(Product product) {
		Connection conn=null;
		PreparedStatement stmt =null;
		//ResultSet rs=null;
		try {
			conn=ConnManager.connect();
			System.out.println("Connection Successful");
		//Statement st = conn.createStatement();
		String sql="insert into tbl_product values(?,?,?)";
		stmt = conn.prepareStatement(sql);
	    stmt.setInt(1,product.getId());
	    stmt.setString(2,product.getName());
	    stmt.setDouble(3,product.getPrice());
	    int count=stmt.executeUpdate();
	    //checking count important in case of update/delete statements
	    //for ex: if(count ==0) indicates no rows got updated or deleted
		}
	catch(SQLException e) {
		e.printStackTrace();
		}
	finally {
		try {conn.close();} catch(Exception e) { }
	}
	}

}
