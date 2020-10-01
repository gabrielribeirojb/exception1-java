    package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer number;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation() {
	}
	
	public Reservation(Integer number, Date checkIn, Date checkOut) {
		this.number = number;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}
	
	private long duration(){
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDate(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room: "
				+ number
				+ ", checkin: "
				+ sdf.format(checkIn)
				+ ", checkout: "
				+ sdf.format(checkOut)
				+ ", duration: "
				+ duration()
				+ "nights";
	}
}

    
