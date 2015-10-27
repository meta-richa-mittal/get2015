package com.car.model;

import lombok.Data;

/**
 * 
 * @author Richa Mittal
 * Description: This class contains getter methods, setter methods and
 * is the super class of Bike and Car classes
 * 
 */
@Data
public class Vehicle {

	private String id;
	private String created_by;
	private String created_time;
	private String make;
	private String model;
	private int engineInCC;
	private int fuelCapacity;
	private int milage;
	private int price;
	private int roadTax;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getEngineInCC() {
		return engineInCC;
	}

	public void setEngineInCC(int engineInCC) {
		this.engineInCC = engineInCC;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public int getMilage() {
		return milage;
	}

	public void setMilage(int milage) {
		this.milage = milage;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRoadTax() {
		return roadTax;
	}

	public void setRoadTax(int roadTax) {
		this.roadTax = roadTax;
	}

	public int calculateOnRoadPrice() {
		return getPrice() + getRoadTax();
	}
	
	@Override
	public String toString() {
		return " Company name : "+ getMake() + " Model : "+ getModel() + " EngineInCC : "+ getEngineInCC()
		+" Mileage : "+ getMilage() +" FuelCapacity : "+ getFuelCapacity() +" Price : "+ getPrice()
		+" RoadTax : "+ getRoadTax();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((created_by == null) ? 0 : created_by.hashCode());
		result = prime * result
				+ ((created_time == null) ? 0 : created_time.hashCode());
		result = prime * result + engineInCC;
		result = prime * result + fuelCapacity;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + milage;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + price;
		result = prime * result + roadTax;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (created_by == null) {
			if (other.created_by != null)
				return false;
		} else if (!created_by.equals(other.created_by))
			return false;
		if (created_time == null) {
			if (other.created_time != null)
				return false;
		} else if (!created_time.equals(other.created_time))
			return false;
		if (engineInCC != other.engineInCC)
			return false;
		if (fuelCapacity != other.fuelCapacity)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (milage != other.milage)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price != other.price)
			return false;
		if (roadTax != other.roadTax)
			return false;
		return true;
	}
	
	
}
