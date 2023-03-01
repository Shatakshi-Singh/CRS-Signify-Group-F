/**
 * 
 */
package com.signify.bean;

import java.beans.JavaBean;

import org.springframework.stereotype.Component;

/**
 * @author CRS_SIGNIFY_GROUP_H
 *
 */

@Component
public class Payment {

	private String studentId;
	private float amount;
	private String referenceId;	
	private boolean scholarship;
	private boolean offline;
	private boolean cash;
	private int bankNumber;
	private boolean status;
	private String upiId;
	private String cardNumber;
	private String cardType;
	private String bankName;
	private String chequeNumber;
	private String cvv;
	
	/**@return the StudentID **/

	public String getStudentId() {
		return studentId;
	}
	/**
	 * 
	 * @param studentId
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	/**@return the amount**/
	public float getAmount() {
		return amount;
	}
	/**
	 * 
	 * @param amount
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
//to check the scholarship
	public boolean isScholarship() {
		return scholarship;
	}
	
	/**
	 * 
	 * @param scholarship
	 */
	public void setScholarship(boolean scholarship) {
		this.scholarship = scholarship;
	}
	
	public boolean isOffline() {
		return offline;
	}
	/**
	 * 
	 * @param offline
	 */
	public void setOffline(boolean offline) {
		this.offline = offline;
	}
	public boolean isCash() {
		return cash;
	}
	/**
	 * 
	 * @param cash
	 */
	public void setCash(boolean cash) {
		this.cash = cash;
	}
	
	/**@return the banknumber **/
	public int getBankNumber() {
		return bankNumber;
	}
	
	/**
	 * 
	 * @param bankNumber
	 */
	public void setBankNumber(int bankNumber) {
		this.bankNumber = bankNumber;
	}
	
	public boolean isStatus() {
		return status;
	}
	/**
	 * 
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	/**@return the upiID **/
	public String getUpiId() {
		return upiId;
	}
	/**
	 * 
	 * @param upiId
	 */
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	
	/**@return the cardnumber **/
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * 
	 * @param cardNumber
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	/**@return the cardtype**/
	public String getCardType() {
		return cardType;
	}
	/**
	 * 
	 * @param cardType
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	/**@return the bank **/
	public String getBankName() {
		return bankName;
	}
	
	/**
	 * 
	 * @param bankName
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	/**@return the chequenumber **/
	public String getChequeNumber() {
		return chequeNumber;
	}
	
	/**
	 * 
	 * @param chequeNumber
	 */
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	
	/**@return the cvv **/
	public String getCvv() {
		return cvv;
	}
	
	/**
	 * 
	 * @param cvv
	 */
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	/**@return the reference ID **/
	public String getReferenceId() {
		return referenceId;
	}
	
	/**
	 * 
	 * @param referenceId
	 */
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	

}
