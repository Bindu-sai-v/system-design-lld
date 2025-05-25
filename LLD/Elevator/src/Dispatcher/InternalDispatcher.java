package Dispatcher;

import Model.Direction;
import Model.ElevatorSystem;
import Model.ElevatorController;

public class InternalDispatcher {
    private final ElevatorSystem elevatorSystem;

    public InternalDispatcher(ElevatorSystem system) {
        this.elevatorSystem = system;
    }

    public InternalDispatcher() {

        elevatorSystem = null;
    }

    // A person inside elevator presses a floor number
    public void submitRequest(int floor, Direction dir, int elevatorId) {
        for (ElevatorController ec : elevatorSystem.getElevatorControllerList()) {
            if (ec.getId() == elevatorId) {
                ec.acceptRequest(floor, dir);
                System.out.println("Person inside elevator " + elevatorId + " presses " + floor);
                break;
            }
        }
    }
}

