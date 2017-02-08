package com.niit.bc.Controller;

import java.util.Date;

public class OutputMessage extends Message {

	private Date time;
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
  public OutputMessage()
  {
	  
  }
	public OutputMessage(Message original, Date time){
		super();
		this.time = time;
	}
}
