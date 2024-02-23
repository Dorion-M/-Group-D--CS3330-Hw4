package edu.mu;

import java.io.IOException;
import java.util.List;

import edu.mu.vehicles.Vehicle;
import edu.mu.vehicles.manager.VehicleManager;

public class Main {

	public static void main(String[] args) {
		
		VehicleManager vehicleManager = VehicleManager.getInstance();
		
	    if (vehicleManager.initializeVehicle()) {
	        List<Vehicle> vehicleList = vehicleManager.vehicleList;
//	        for (Vehicle vehicle : vehicleList) {
//	            System.out.println(vehicle);
//	        }
//	        for (Vehicle vehicle : vehicleList) {
//	            System.out.println(vehicle);
//	        }
	        
	        try {
	        	vehicleManager.displayAllCarInformation(2000000, 10);
		        vehicleManager.displayAllTruckInformation(2000000, 10);
		        vehicleManager.displayAllSUVInformation(2000000, 10);
				vehicleManager.displayAllMotorBikeInformation(2000000, 10);
				vehicleManager.displayAllVehicleInformation(0, 0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    }
				
	}

}
