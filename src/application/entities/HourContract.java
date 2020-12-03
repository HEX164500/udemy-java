package application.entities;

import java.util.Date;

public class HourContract {
	private Integer ID;
	private Date date;
	private Double valuePerHour;
	private Double hours;
	
	public Double totalValue() {
		return hours * valuePerHour;
	}
	
	public HourContract() {
		
	}

	public HourContract(Integer ID, Date date, Double valuePerHour, Double hours) {
		this.ID = ID;
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}
}
