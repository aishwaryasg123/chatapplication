package com.assignment.test.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "chatinfo")
public class ChatInfo {
	  @Id
	    @Column
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    @Column
	    private String fromEmail;
	    @Column
	    private String toEmail;
	    @Column
	    private String msg;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFromEmail() {
			return fromEmail;
		}
		public void setFromEmail(String fromEmail) {
			this.fromEmail = fromEmail;
		}
		public String getToEmail() {
			return toEmail;
		}
		public void setToEmail(String toEmail) {
			this.toEmail = toEmail;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		@Override
		public String toString() {
			return "ChatInfo [id=" + id + ", fromEmail=" + fromEmail + ", toEmail=" + toEmail + ", msg=" + msg + "]";
		}
	    
	    

}
