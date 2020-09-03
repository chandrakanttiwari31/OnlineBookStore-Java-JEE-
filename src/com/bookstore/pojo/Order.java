package com.bookstore.pojo;

public class Order {

	
	
	
	private int orderId;
	private String emailId;
	private long totalBill;
	private String date;
	private String  status;
	
	
	public Order(int orderId, String emailId, long totalBill, String date, String status) {
		super();
		this.orderId = orderId;
		this.emailId = emailId;
		this.totalBill = totalBill;
		this.date = date;
		this.status = status;
	}
	
	
	
	
	
	
	




	public Order() {
		// TODO Auto-generated constructor stub
	}






	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(long totalBill) {
		this.totalBill = totalBill;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", emailId=" + emailId + ", totalBill=" + totalBill + ", date=" + date
				+ ", status=" + status + "]";
	}
	
	
}




//create table Order22377
// (orderId int(100) primary key auto_increment,emailId varchar(250)  REFERENCES customer22377(emailid),
// totalBill float not null,
//date varchar(100) default '31-05-2020',
//status varchar(100) degault 'pending');
