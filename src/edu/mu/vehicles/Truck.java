package edu.mu.vehicles;

import java.time.Year;

public class Truck extends Vehicle {

	public Truck(String type, String brand, String make, long modelYear, Double price, VehicleColor color, FuelType fueltype,
			Double mileage, double mass, int cylinders, Double gasTankCapacity, StartMechanism startType) {
		super(type, brand, make, modelYear, price, color, fueltype, mileage, mass, cylinders, gasTankCapacity, startType);
	}
	
	public Truck(Truck copy) {
		super(copy);
	}

	@Override
	public double calculateMaintenanceCost(double distance) 
	{
		return distance * mass * (Year.now().getValue()-modelYear) * cylinders * 0.002;
	}
	
	public double calculateFuelEfficiency(double distance, double fuelPrice) 
	{
		return cylinders * gasTankCapacity * fuelPrice / distance * 0.1;
	}
	
}
	

