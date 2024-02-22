package edu.mu.vehicles.manager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
                        vehicle = new Truck(brand, make, modelYear, price,  color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                        break;
                    case "Car":
                        vehicle = new Car(brand, make, modelYear, price,  color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                        break;
                    case "SUV":
                        vehicle = new SUV(brand, make, modelYear, price,  color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                        break;
                    case "MotorBike":
                        vehicle = new MotorBike(brand, make, modelYear, price,  color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
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

}
