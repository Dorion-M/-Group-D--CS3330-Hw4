package edu.mu;

import java.util.List;

import edu.mu.vehicles.Vehicle;
import edu.mu.vehicles.manager.VehicleManager;

public class Main {

	public static void main(String[] args) {
		
		VehicleManager vehicleManager = VehicleManager.getInstance();
		
	    if (vehicleManager.initializeVehicle()) {
	        List<Vehicle> vehicleList = vehicleManager.vehicleList;
	        for (Vehicle vehicle : vehicleList) {
	            System.out.println(vehicle);
	        }
	    }
				
	}

}
