package edu.mu.vehicles;

public abstract class Vehicle {
	
	protected String type;
	protected String brand;
	protected String make;
	protected long modelYear;
	protected Double price;
	protected VehicleColor color;
	protected FuelType fueltype;
	protected Double mileage;
	protected double mass;
	protected int cylinders;
	protected Double gasTankCapacity;
	protected StartMechanism startType;
	
	
	public Vehicle(String type, String brand, String make, long modelYear, Double price, VehicleColor color, FuelType fueltype,
			Double mileage, double mass, int cylinders, Double gasTankCapacity, StartMechanism startType) {
		super();
		this.type = type;
		this.brand = brand;
		this.make = make;
		this.modelYear = modelYear;
		this.price = price;
		this.color = color;
		this.fueltype = fueltype;
		this.mileage = mileage;
		this.mass = mass;
		this.cylinders = cylinders;
		this.gasTankCapacity = gasTankCapacity;
		this.startType = startType;
	}
	
	public Vehicle(Vehicle copy) {
		
		this.type = copy.type;
		this.brand = copy.brand;
		this.make = copy.make;
		this.modelYear = copy.modelYear;
		this.price = copy.price;
		this.color = copy.color;
		this.fueltype = copy.fueltype;
		this.mileage = copy.mileage;
		this.mass = copy.mass;
		this.cylinders = copy.cylinders;
		this.gasTankCapacity = copy.gasTankCapacity;
		this.startType = copy.startType;
		
	}


	public String getType() {
		return type;
		
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public long getModelYear() {
		return modelYear;
	}


	public void setModelYear(long modelYear) {
		this.modelYear = modelYear;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public VehicleColor getColor() {
		return color;
	}


	public void setColor(VehicleColor color) {
		this.color = color;
	}


	public FuelType getFueltype() {
		return fueltype;
	}


	public void setFueltype(FuelType fueltype) {
		this.fueltype = fueltype;
	}


	public Double getMileage() {
		return mileage;
	}


	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}


	public double getMass() {
		return mass;
	}


	public void setMass(double mass) {
		this.mass = mass;
	}


	public int getCylinders() {
		return cylinders;
	}


	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}


	public Double getGasTankCapacity() {
		return gasTankCapacity;
	}


	public void setGasTankCapacity(Double gasTankCapacity) {
		this.gasTankCapacity = gasTankCapacity;
	}


	public StartMechanism getStartType() {
		return startType;
	}


	public void setStartType(StartMechanism startType) {
		this.startType = startType;
	}

	public abstract double calculateMaintenanceCost(double distance);
	public abstract double calculateFuelEfficiency(double distance, double fuelPrice);
	
	
	
	
	@Override
	public String toString() {
		return "type= " + type + ", brand=" + brand + ", make=" + make + ", modelYear=" + modelYear + ", price=" + price
				+ ", color=" + color + ", fueltype=" + fueltype + ", mileage=" + mileage + ", mass=" + mass
				+ ", cylinders=" + cylinders + ", gasTankCapacity=" + gasTankCapacity + ", startType=" + startType;
	}
	
	
	
	
	
	
	
	
	
	
	

}
