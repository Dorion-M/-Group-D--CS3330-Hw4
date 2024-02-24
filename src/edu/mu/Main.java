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
		
	    if (vehicleManager.initializeVehicle()) 
	    {
	        List<Vehicle> vehicleList = vehicleManager.vehicleList;
            System.out.println("Vehicles Read from file: ");
	        
	        for (Vehicle vehicle : vehicleList) 
	        {
	        	System.out.println(vehicle);
	        }
	        	
			try 
			{
			    //All
				System.out.println("\nThere are " + vehicleManager.getNumberOfVehichlesByType(Vehicle.class) + " vehicles.");
				System.out.println("All Vehicle Information (At distance=300,fuel=3.25): ");
				vehicleManager.displayAllVehicleInformation(300, 3.25);
				
				//Cars
				System.out.println("\nThere are " + vehicleManager.getNumberOfVehichlesByType(Car.class) + " Cars.");
				System.out.println("All Car Information (At distance=300,fuel=3.25): ");
				vehicleManager.displayAllCarInformation(300, 3.25);
				
				//Trucks
				System.out.println("\nThere are " + vehicleManager.getNumberOfVehichlesByType(Truck.class) + " Trucks.");
				System.out.println("All Truck Information (At distance=300,fuel=3.25): ");
				vehicleManager.displayAllTruckInformation(300, 3.25);
				
				//SUVs
				System.out.println("\nThere are " + vehicleManager.getNumberOfVehichlesByType(SUV.class) + " SUVs.");
				System.out.println("All SUV Information (At distance=300,fuel=3.25): ");
				vehicleManager.displayAllSUVInformation(300, 3.25);
				double fueling = vehicleManager.getAverageFuelEfficiencyOfSUVs(300, 3.25);
			    System.out.println("\nThe average SUV fuel efficiency is: " + fueling);
				
			    //MotorBikes
			    System.out.println("\nThere are " + vehicleManager.getNumberOfVehichlesByType(MotorBike.class) + " Motorbikes.");
				System.out.println("All MotorBike Information (At distance=300,fuel=3.25): ");
				vehicleManager.displayAllMotorBikeInformation(300, 3.25);
				
				//Lowest Maintenance
				Vehicle test = vehicleManager.getVehicleWithLowestMaintenanceCost(300);
			    System.out.println("\nThe vehicle with the lowest maintenance cost is: " + test.getMake());
			    
			    //Highest Fuel Efficiency
			    System.out.println("\nHighestFuelEfficiency:");
			    System.out.println(vehicleManager.getVehicleWithHighestFuelEfficiency(300, 3.25));	    
			    
			    //Lowest Fuel Efficiency
			    System.out.println("\nTesting LowestFuelEfficiency");
			    System.out.println(vehicleManager.getVehicleWithLowestFuelEfficiency(300, 3.25));
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	    }    
	}
}