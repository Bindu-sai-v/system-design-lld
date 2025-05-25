package algorithm;

import Model.Direction;
import Model.ElevatorController;

public class OddEvenStrategy extends ElevatorSelectionStrategy {

    @Override
    public int selectElevator(int floor, Direction dir) {
        int floorParity = floor % 2;

        for (ElevatorController ec : elevatorControllerList) {
            int elevatorId = ec.getId();
            if (elevatorId % 2 == floorParity) {
                System.out.println("Selected elevator (OddEvenStrategy): " + elevatorId);
                return elevatorId;
            }
        }

        // Fallback: if no parity match, just return first available elevator
        if (!elevatorControllerList.isEmpty()) {
            int fallbackId = elevatorControllerList.get(0).getId();
            System.out.println("Fallback selected elevator: " + fallbackId);
            return fallbackId;
        }

        System.out.println("No elevators available");
        return -1; // No elevators
    }
}

