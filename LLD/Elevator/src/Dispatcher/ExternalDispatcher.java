package Dispatcher;

import Model.Direction;
import Model.ElevatorController;
import Model.ElevatorSystem;
import algorithm.ElevatorSelectionStrategy;

public class ExternalDispatcher {
    private ElevatorSystem elevatorSystem;
    private ElevatorSelectionStrategy selectionStrategy;

    public ExternalDispatcher(ElevatorSystem system, ElevatorSelectionStrategy strategy) {
        this.elevatorSystem = system;
        this.selectionStrategy = strategy;
    }

    public ExternalDispatcher() {

    }

    // A person on a floor presses UP/DOWN
    public void submitRequest(int floor, Direction dir) {
        System.out.println("Person at floor " + floor + " presses " + dir + " button");
        int selectedElevatorId = selectionStrategy.selectElevator(floor, dir);

        for (ElevatorController ec : elevatorSystem.getElevatorControllerList()) {
            if (ec.getId() == selectedElevatorId) {
                ec.acceptRequest(floor, dir);
                break;
            }
        }
    }
}

