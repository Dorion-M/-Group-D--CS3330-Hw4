# [Group-D]-CS3330-Hw4


# Vehicle Management System

## Project Overview
This Java project aims to create a vehicle management system. The system allows users to perform various operations such as initializing vehicles from a file, displaying vehicle information, and obtaining statistics about the vehicles in the system as well as other managment options.

## Project Structure
The project consists of the following files:

1. `Main.java`: This is the main file used to execute the program. It interacts with the `VehicleManager` class to manage vehicles.
2. `VehicleManager.java`: This file contains the `VehicleManager` class, which is responsible for managing vehicles. It includes methods for initializing vehicles from a file, displaying various types of vehicle information, and calculating statistics such as average fuel efficiency and lowest maintenance cost.
3. `Vehicle.java`, `Car.java`, `Truck.java`, `SUV.java`, `MotorBike.java`: These files define different types of vehicles and their properties.
4. `VehicleColor.java`: This file contains the `VehicleColor` enum, which represents the colors of vehicles.
5. `StartMechanism.java`: This file contains the `StartMechanism` enum, which represents the start mechanisms of vehicles.
6. `FuelType.java`: This file contains the `FuelType` enum, which represents the fuel types of vehicles.

## Vehicle Classes
The project includes subclasses of the `Vehicle` class, each representing a specific type of vehicle:

- `Car.java`: Represents a car with properties such as brand, make, model year, price, color, fuel type, mileage, mass, cylinders, gas tank capacity, and start mechanism. It includes methods to calculate maintenance cost and fuel efficiency specific to cars.
- `Truck.java`: Represents a truck with similar properties and methods as the car class.
- `SUV.java`: Represents an SUV with similar properties and methods as the car class.
- `MotorBike.java`: Represents a motorbike with similar properties and methods as the car class.

## Methods of the Project
The vehicle management system allows users to perform various operations on vehicles, including:

- Initializing vehicles from a CSV file.
- Displaying information about all vehicles or specific types of vehicles.
- Calculating statistics such as average fuel efficiency, maintenance cost, and more.
- Adding and removing vehicles from the system.
- Saving the current state of the vehicle list to a file.

## How to Run the Project
To run the project:

1. Clone the GitHub repository containing the project files.
2. Open the project in your preferred IDE.
3. Make sure you have JDK installed on your machine.
4. Compile and run the `Main.java` file.

## Dependencies
The project requires the following dependencies:

- Java Development Kit (JDK) to compile and run the program.

## Contributors
- Seth keenan (Implemented methods to display information about the vehicles + Lists of vehicles, added features to vehicle subclasses, Implemented methods to main class)  
- Paul Maschhoff (Implemented Vehicle effeiency methods, Vehicle Cost methods, Vehicle maintenance methods)
- Dorion Massengill (Set up projet files and all classes/subclass/enums, implemented CSV reader and Initialization of vehicles, ReadME)
