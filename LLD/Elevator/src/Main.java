import Dispatcher.ExternalDispatcher;
import Dispatcher.InternalDispatcher;
import Model.Direction;
import Model.ElevatorController;
import Model.ElevatorSystem;
import Model.Floor;
import algorithm.FirstComeFirstServe;
import algorithm.LookAlgorithm;
import algorithm.NearestCar;
import algorithm.OddEvenStrategy;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = ElevatorSystem.INSTANCE;

        elevatorSystem.setElevatorSelectionStrategy(new NearestCar());
        elevatorSystem.setElevatorControlStrategy(new LookAlgorithm());

        // Initialize dispatchers
        ExternalDispatcher externalDispatcher = new ExternalDispatcher(elevatorSystem, ElevatorSystem.getElevatorSelectionStrategy());
        InternalDispatcher internalDispatcher = new InternalDispatcher(elevatorSystem);

        // Add Floors
        for (int i = 0; i <= 50; i++) {
            elevatorSystem.addFloor(new Floor(i));
        }

        // Add Elevators
        for (int i = 1; i <= 4; i++) {
            elevatorSystem.addElevator(new ElevatorController(i));
        }

        // Set initial positions of elevators
        elevatorSystem.getElevatorControllerList().get(0).getCar().setCurrentFloor(0);   // Elevator 1
        elevatorSystem.getElevatorControllerList().get(1).getCar().setCurrentFloor(4);   // Elevator 2
        elevatorSystem.getElevatorControllerList().get(2).getCar().setCurrentFloor(10);  // Elevator 3
        elevatorSystem.getElevatorControllerList().get(3).getCar().setCurrentFloor(17);  // Elevator 4

        // EXTERNAL requests (NearestCar decides which elevator gets them)
        // External calls
        externalDispatcher.submitRequest(7, Direction.UP);
        externalDispatcher.submitRequest(13, Direction.DOWN);
        externalDispatcher.submitRequest(2, Direction.UP);
        externalDispatcher.submitRequest(18, Direction.DOWN);
        externalDispatcher.submitRequest(6, Direction.UP);

// Internal requests
        internalDispatcher.submitRequest(15, Direction.NONE, 1);
        internalDispatcher.submitRequest(1, Direction.NONE, 2);
        internalDispatcher.submitRequest(19, Direction.NONE, 3);
        internalDispatcher.submitRequest(5, Direction.NONE, 4);


        // Move each elevator using LOOK algorithm
        for (ElevatorController ec : elevatorSystem.getElevatorControllerList()) {
            elevatorSystem.getElevatorControlStrategy().moveElevator(ec);
        }
    }
}
