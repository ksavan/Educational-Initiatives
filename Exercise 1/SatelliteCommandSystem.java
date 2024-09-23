import java.util.Scanner;

class Satellite {
    private String orientation;
    private boolean solarPanelsActive;
    private int dataCollected;

    public Satellite() {
        this.orientation = "North";
        this.solarPanelsActive = false; // Panels are inactive initially
        this.dataCollected = 0;
    }

    public String getOrientation() {
        return orientation;
    }

    public boolean areSolarPanelsActive() {
        return solarPanelsActive;
    }

    public int getDataCollected() {
        return dataCollected;
    }

    // Command to rotate the satellite
    public void rotate(String direction) {
        if (direction.equalsIgnoreCase("North") || direction.equalsIgnoreCase("South") ||
                direction.equalsIgnoreCase("East") || direction.equalsIgnoreCase("West")) {
            this.orientation = direction;
            System.out.println("Satellite rotated to: " + orientation);
        } else {
            System.out.println("Invalid direction. Please choose North, South, East, or West.");
        }
    }

    // Command to activate the solar panels
    public void activatePanels() {
        if (!solarPanelsActive) {
            this.solarPanelsActive = true;
            System.out.println("Solar panels activated.");
        } else {
            System.out.println("Solar panels are already active.");
        }
    }

    // Command to deactivate the solar panels
    public void deactivatePanels() {
        if (solarPanelsActive) {
            this.solarPanelsActive = false;
            System.out.println("Solar panels deactivated.");
        } else {
            System.out.println("Solar panels are already inactive.");
        }
    }

    // Command to collect data
    public void collectData() {
        if (solarPanelsActive) {
            this.dataCollected += 10;
            System.out.println("Data collected. Total data: " + dataCollected + " units.");
        } else {
            System.out.println("Cannot collect data. Solar panels are inactive.");
        }
    }
}

public class SatelliteCommandSystem {

    public static void main(String[] args) {
        Satellite satellite = new Satellite();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("*** Satellite Command System ***");
        System.out.println("Initial State:");
        printSatelliteState(satellite);

        while (true) {
            System.out.println("\nEnter a command (rotate, activatePanels, deactivatePanels, collectData, exit): ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Satellite Command System.");
                break;
            }

            // Parsing commands
            if (command.startsWith("rotate")) {
                String[] parts = command.split("\\s+");
                if (parts.length == 2) {
                    satellite.rotate(parts[1]);
                } else {
                    System.out.println("Invalid rotate command. Usage: rotate <direction>");
                }
            } else if (command.equalsIgnoreCase("activatePanels")) {
                satellite.activatePanels();
            } else if (command.equalsIgnoreCase("deactivatePanels")) {
                satellite.deactivatePanels();
            } else if (command.equalsIgnoreCase("collectData")) {
                satellite.collectData();
            } else {
                System.out.println("Invalid command. Please try again.");
            }

            printSatelliteState(satellite);  // Display satellite's current state after each command
        }

        scanner.close();
    }

    private static void printSatelliteState(Satellite satellite) {
        System.out.println("\nSatellite State:");
        System.out.println("Orientation: " + satellite.getOrientation());
        System.out.println("Solar Panels: " + (satellite.areSolarPanelsActive() ? "Active" : "Inactive"));
        System.out.println("Data Collected: " + satellite.getDataCollected() + " units");
    }
}
