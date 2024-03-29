package edu.mu.vehicles.manager;
import java.io.BufferedReader;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.CompactNumberFormat;
import java.text.NumberFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import edu.mu.vehicles.*;

public class VehicleManager {
	
	private static VehicleManager instance;
    private String vehicleFilePath;
    public static List<Vehicle> vehicleList;
    
    
    private VehicleManager() {
        vehicleFilePath = "src/dataFile/vehicleList.csv"; 
        vehicleList = new ArrayList<>();
    }

    public static VehicleManager getInstance() {
        if (instance == null) {
            instance = new VehicleManager();
        }
        return instance;
    }
    

// Reads CSV 
    public boolean initializeVehicle() {
        try (BufferedReader reader = new BufferedReader(new FileReader(vehicleFilePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(","); 
                String type = tokens[0];
                String brand = tokens[1];
                String make = tokens[2];
                Long modelYear = Long.parseLong(tokens[3]);
                Double price = Double.parseDouble(tokens[4]);
                VehicleColor color = VehicleColor.valueOf(tokens[5].toUpperCase()); 
                FuelType fuelType = FuelType.valueOf(tokens[6].toUpperCase());
                Double mileage = Double.parseDouble(tokens[7]);
                Double mass = Double.parseDouble(tokens[8]);
                int cylinders = Integer.parseInt(tokens[9]);
                Double gasTankCapacity = Double.parseDouble(tokens[10]);
                StartMechanism startType = StartMechanism.valueOf(tokens[11].toUpperCase());

                                
// Creates Vehicle object based on the type
                Vehicle vehicle;
                switch (type) {
                    case "Truck":
                        vehicle = new Truck(type, brand, make, modelYear, price,  color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                        break;
                    case "Car":
                        vehicle = new Car(type, brand, make, modelYear, price,  color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                        break;
                    case "SUV":
                        vehicle = new SUV(type, brand, make, modelYear, price,  color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                        break;
                    case "MotorBike":
                        vehicle = new MotorBike(type, brand, make, modelYear, price,  color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                        break;
                    default:
                        continue;
                }
                
                vehicleList.add(vehicle);
            }
            return !vehicleList.isEmpty();
        }catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("An error occurred while reading the inventory file.");
            return false;
        }
    }
    
    public void displayAllCarInformation(double distance, double fuel) 
    {
    	for (Vehicle vehicle : vehicleList) 
    	{
    	    if (vehicle instanceof Car) 
    	    {
    	        try 
    	        {
    	            double cost = vehicle.calculateMaintenanceCost(distance);
    	            String fuelCost = String.format("%.2f", vehicle.calculateFuelEfficiency(distance, fuel));
    	            System.out.println(vehicle.getMake()+": Maintenance Cost: " + cost + ", Fuel Effiency: " + fuelCost + ", Vehicle Start: " + vehicle.getStartType());
    	        }
    	        catch (NumberFormatException | ArrayIndexOutOfBoundsException e) 
    	        {
    	            e.printStackTrace();
    	            System.out.println("An error occurred while calculating the information.");
    	          
    	        }
    	    }
    	}
    }

    public void displayAllTruckInformation(double distance, double fuel) 
    {
    	for (Vehicle vehicle : vehicleList) 
    	{
    	    if (vehicle instanceof Truck) 
    	    {
    	        try 
    	        {
    	            double cost = vehicle.calculateMaintenanceCost(distance);
    	            String fuelCost = String.format("%.2f", vehicle.calculateFuelEfficiency(distance, fuel));
    	            System.out.println(vehicle.getMake()+": Maintenance Cost: " + cost + ", Fuel Effiency: " + fuelCost + ", Vehicle Start: " + vehicle.getStartType());
    	        }
    	        catch (NumberFormatException | ArrayIndexOutOfBoundsException e) 
    	        {
    	            e.printStackTrace();
    	            System.out.println("An error occurred while calculating the information.");
    	        }
    	    }
    	}
    }
    
    public void displayAllSUVInformation(double distance, double fuel) 
    {
    	for (Vehicle vehicle : vehicleList) 
    	{
    	    if (vehicle instanceof SUV) 
    	    {
    	        try 
    	        {
    	            double cost = vehicle.calculateMaintenanceCost(distance);
    	            String fuelCost = String.format("%.2f", vehicle.calculateFuelEfficiency(distance, fuel));
    	            System.out.println(vehicle.getMake()+": Maintenance Cost: " + cost + ", Fuel Effiency: " + fuelCost + ", Vehicle Start: " + vehicle.getStartType());
    	        }
    	        catch (NumberFormatException | ArrayIndexOutOfBoundsException e) 
    	        {
    	            e.printStackTrace();
    	            System.out.println("An error occurred while calculating the information.");
    	        }
    	    }
    	}
    }
    
    public void displayAllMotorBikeInformation(double distance, double fuel) throws IOException 
    {
    	for (Vehicle vehicle : vehicleList) 
    	{
    	    if (vehicle instanceof MotorBike) 
    	    {
    	        try 
    	        {
    	            double cost = vehicle.calculateMaintenanceCost(distance);
    	            String fuelCost = String.format("%.2f", vehicle.calculateFuelEfficiency(distance, fuel));
    	            System.out.println(vehicle.getMake()+": Maintenance Cost: " + cost + ", Fuel Effiency: " + fuelCost + ", Vehicle Start: " + vehicle.getStartType());
    	        }
    	        catch (NumberFormatException | ArrayIndexOutOfBoundsException e) 
    	        {
    	            e.printStackTrace();
    	            System.out.println("An error occurred while calculating the information.");
    	           }
    	    }
    	}
    }
    
    public void displayVehicleInformation(Vehicle v, double distance, double fuel) {
        boolean vehicleFound = false;
        for (Vehicle vehicle : vehicleList) 
        {
            if (vehicle.equals(v)) 
            {
                try 
                {
                    double cost = vehicle.calculateMaintenanceCost(distance);
                    String fuelEfficiency = String.format("%.2f", vehicle.calculateFuelEfficiency(distance, fuel));
                    System.out.println(vehicle.getMake()+": Maintenance Cost: " + cost + ", Fuel Efficiency: " + fuelEfficiency + ", Vehicle Start: " + vehicle.getStartType());
                    vehicleFound = true;
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                    System.out.println("An error occurred while calculating the information.");
                }
                break; // No need to continue iterating if the vehicle is found
            }
        }
        
        if (vehicleFound == false) 
        {
            System.out.println("Vehicle not found in the vehicle list.");
        }
    }

    public void displayAllVehicleInformation(double distance, double fuel) 
    {
    	if(vehicleList.isEmpty()) 
    	{
    		System.out.println("The list is empty.");
    		return;
    	}
    	
    	for (Vehicle vehicle : vehicleList) 
    	{
    		try 
    		{
    			double cost = vehicle.calculateMaintenanceCost(distance);
    	        String fuelCost = String.format("%.2f", vehicle.calculateFuelEfficiency(distance, fuel));
    	        System.out.println(vehicle.getMake()+": Maintenance Cost: " + cost + ", Fuel Effiency: " + fuelCost + ", Vehicle Start: " + vehicle.getStartType());
    	    }
    		catch (NumberFormatException | ArrayIndexOutOfBoundsException e) 
    		{
    	    	e.printStackTrace();
    	        System.out.println("An error occurred while calculating the information.");
    	    }
    	}
    }
    
    public boolean removeVehicle(Vehicle vehicle) 
    {
    	for(Vehicle current: vehicleList) 
    	{
    		if(current.equals(vehicle))
    		{
    			vehicleList.remove(current);
    			System.out.println("Removed.");
    			return true;
    		}
    	}
    	System.out.println("Unable to remove or find vehicle.");
		return false;
    }
    
    public boolean addVehicle(Vehicle vehicle) 
    {
    	if(vehicleList.add(vehicle)) 
    	{
    		System.out.println("Added.");
    		return true;
    	}
    	System.out.println("Unable to add.");
    	return false;
    }
    
    public boolean saveVehicleList() {
    	
    	try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(vehicleFilePath));
			
			writer.write("Type,Model,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType\n");
			
			for(Vehicle item : vehicleList) 
			{
				String line = String.format("%s,%s,%s,%d,%.2f,%s,%s,%.2f,%.2f,%d,%.2f,%s", 
					    item.getType(), item.getBrand(), item.getMake(), item.getModelYear(), item.getPrice(), item.getColor(), item.getFueltype(),
					    item.getMileage(), item.getMass(), item.getCylinders(), item.getGasTankCapacity(), item.getStartType());
				
				writer.write(line);
			}
		
			writer.close();
			return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    	
    }
    
    
    private boolean isVehicleType(Vehicle v, Class<?> clazz)
    {
		if(clazz.isInstance(v))
		{
			return true;
		}
		else
		{
    	
    	return false;
		}	
    }
    
    public int getNumberOfVehichlesByType(Class<?> clazz)
    {
		int count;
		count = 0;
		for(Vehicle test : vehicleList)
		{
			if(isVehicleType(test, clazz))
			{
				count++;
			}
		}
		return count;
    	
    }
    
    public Vehicle getVehicleWithHighestMaintenanceCost(double distance)
    {
		List<Vehicle> vehicle = new ArrayList<>(); 
		double highestCost = 0.0;
		double temp;
		for(Vehicle test : vehicleList)
		{
			temp = test.calculateMaintenanceCost(distance);
			if(temp > highestCost)
			{
				vehicle.clear();
				vehicle.add(test);
				highestCost = temp;
				temp = Double.MIN_VALUE;
			}
			
			if(temp == highestCost)
			{
				vehicle.add(test);
			}
				
		}
		
		int size = vehicle.size();
    				
    	if(size > 1)
    	{
    		Random rand = new Random();
    		Vehicle randVehicle = vehicle.get(rand.nextInt(vehicle.size()));
    		return randVehicle;
    		
    	}
    	else
    	{
    		return vehicle.get(0);
    	}
    	
    	
    }
    
    public Vehicle getVehicleWithLowestMaintenanceCost(double distance)
    {
    	List<Vehicle> vehicle = new ArrayList<>(); 
		double lowestCost = Double.MAX_VALUE;
		double temp;
		for(Vehicle test : vehicleList)
		{
			temp = test.calculateMaintenanceCost(distance);
			if(temp < lowestCost)
			{
				vehicle.clear();
				vehicle.add(test);
				lowestCost = temp;
				temp = Double.MAX_VALUE;
			}
			
			if(temp == lowestCost)
			{
				vehicle.add(test);
			}
				
		}
		
		int size = vehicle.size();
    				
    	if(size > 1)
    	{
    		Random rand = new Random();
    		Vehicle randVehicle = vehicle.get(rand.nextInt(vehicle.size()));
    		return randVehicle;
    		
    	}
    	else
    	{
    		return vehicle.get(0);
    	}
    	
    }
    
    public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice)
    {
    	ArrayList<Vehicle> vehicle = new ArrayList<>();
    	double highestFuel = Double.MIN_VALUE;
    	double temp;
    	
    	for(Vehicle test : vehicleList)
		{
			temp = test.calculateFuelEfficiency(distance, fuelPrice);
			if(temp > highestFuel)
			{
				vehicle.clear();
				vehicle.add(test);
				highestFuel = temp;
				temp = Double.MIN_VALUE;
			}
			
			if(temp == highestFuel)
			{
				vehicle.add(test);
			}
			
		}
    	
    	return vehicle;
    }
    	
    
    public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice)
    {
    	ArrayList<Vehicle> vehicle = new ArrayList<>();
    	double lowestFuel = Double.MAX_VALUE;
    	double temp;
    	
    	for(Vehicle test : vehicleList)
		{
			temp = test.calculateFuelEfficiency(distance, fuelPrice);
			if(temp < lowestFuel)
			{
				vehicle.clear();
				vehicle.add(test);
				lowestFuel = temp;
				temp = Double.MAX_VALUE;
			}
			
			if(temp == lowestFuel)
			{
				vehicle.add(test);
			}
			
		}
    	
    	return vehicle;
    	
    }
    
    public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice)
    {
		double totalFuel = 0;
		int size = getNumberOfVehichlesByType(SUV.class);
		
		for(Vehicle test : vehicleList)
		{
			if(isVehicleType(test, SUV.class))
			{
				totalFuel = totalFuel + test.calculateFuelEfficiency(distance, fuelPrice);
			}
		}		
		return (totalFuel / size);
    }
    
    
}
