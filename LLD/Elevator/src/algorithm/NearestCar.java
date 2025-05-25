package algorithm;

import Model.Direction;
import Model.ElevatorController;
import Model.ElevatorSystem;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NearestCar extends ElevatorSelectionStrategy {

    @Override
    public int selectElevator(int floor, Direction dir) {
        List<ElevatorController> elevators = elevatorControllerList;

        ElevatorController bestElevator = null;
        int bestDistance = Integer.MAX_VALUE;

        for (ElevatorController eController : elevators) {
            int elevatorFloor = eController.getCar().getCurrentFloor();
            Direction elevatorDir = eController.getCar().getDir();

            boolean isIdle = (elevatorDir == Direction.NONE);
            boolean sameDirection = (elevatorDir == dir);

            // Elevator qualifies if idle or moving in the same direction
            if (isIdle || sameDirection) {
                int distance = Math.abs(floor - elevatorFloor);
                if (distance < bestDistance) {
                    bestDistance = distance;
                    bestElevator = eController;
                }
            }
        }

        if (bestElevator != null) {
            return bestElevator.getId();
        }

        // fallback: pick random elevator
        return ThreadLocalRandom.current().nextInt(1, elevators.size() + 1);
    }
}

