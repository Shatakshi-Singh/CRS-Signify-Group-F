/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.bean.Payment;
import com.signify.constants.SQLConstants;
import com.signify.helper.IDs;
import com.signify.utils.DBUtils;

/**
 * @author BHAVISH
 *
 */
public class PaymentDAOImplementation implements PaymentDAOInterface {

	 Connection conn = null;
	 PreparedStatement stmt = null;
	   
	@Override
	public void add(String userId, Payment payment) {
		// TODO Auto-generated method stub

		   try{
			      conn = DBUtils.getConnection();
			      stmt = conn.prepareStatement(SQLConstants.ADD_PAYMENT);
			   
			      stmt.setInt(1, Integer.parseInt(userId));
			      stmt.setString(2, payment.getUpiId());
			      stmt.setString(3, payment.getChequeNumber());
			      stmt.setString(4, payment.getReferenceId());
			      stmt.setString(5, payment.getCardNumber());
			      stmt.setString(6, payment.getCvv());
			      stmt.setString(7, payment.getCardType());
			      stmt.setString(8, "20000");
			      stmt.executeUpdate();
			      stmt.close();
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			      e.printStackTrace();
			   }
	}
	public Payment getAmount(String userId) {
		Payment payment = new Payment();

		   try{
			      conn = DBUtils.getConnection();
			      stmt = conn.prepareStatement(SQLConstants.GET_PAMENT + userId);
			   
			     ResultSet rs = stmt.executeQuery();
			     if(rs.next()) {
			    	 payment.setReferenceId(rs.getString("referenceId"));
			    	 payment.setAmount(Float.parseFloat(rs.getString("amount")));
			    	 payment.setUpiId(rs.getString("upiId"));
			    	 payment.setCardNumber(rs.getString("cardNumber"));
			    	 payment.setCardType(rs.getString("cardType"));
			    	 payment.setChequeNumber(rs.getString("chequeNumber"));
			    	 payment.setStudentId(userId);
			     }
			      
			   }catch(SQLException e){		//Handle errors for JDBC
			      e.printStackTrace();
			   }catch(Exception e){ 	      //Handle errors for Class.forName
			     // e.printStackTrace();
			   }
		   return payment;
		
	}

}
