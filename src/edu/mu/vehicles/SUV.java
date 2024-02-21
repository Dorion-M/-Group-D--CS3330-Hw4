package edu.mu.vehicles;

public class SUV extends Vehicle {
	
	public SUV(String brand, String make, long modelYear, Double price, VehicleColor color, FuelType fueltype,
			Double mileage, double mass, int cylinders, Double gasTankCapacity, StartMechanism startType) {
		super(brand, make, modelYear, price, color, fueltype, mileage, mass, cylinders, gasTankCapacity, startType);
	}
	
	public SUV(SUV copy) {
		super(copy);
	}
	
}


