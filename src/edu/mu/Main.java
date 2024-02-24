package edu.mu;
import edu.mu.vehicles.manager.*;
import edu.mu.vehicles.*;

import java.io.IOException;
import java.util.ArrayList;
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
	    
	    int number = vehicleManager.getNumberOfVehichlesByType(SUV.class);
	    System.out.println("The number of SUVs is" + number);
	    
	    Vehicle test = vehicleManager.getVehicleWithLowestMaintenanceCost(300);
	    System.out.println("The name of the vehicle is" + test.getMake());
	    
	    System.out.println("Testing HightFuelEfficiency\n");
	    ArrayList<Vehicle> fuel = vehicleManager.getVehicleWithHighestFuelEfficiency(300, 3.25);
	    for (Vehicle element : fuel) {
	        System.out.println(element);
	    }
	    
	    System.out.println("Testing LowestFuelEfficiency\n");
	    ArrayList<Vehicle> fuels = vehicleManager.getVehicleWithLowestFuelEfficiency(300, 3.25);
	    for (Vehicle element : fuels) {
	        System.out.println(element);
	    }
	    
	    double fueling = vehicleManager.getAverageFuelEfficiencyOfSUVs(300, 3.25);
	    System.out.println("The average SUV fuel efficiency is: " + fueling);

	    
	    

	}
}