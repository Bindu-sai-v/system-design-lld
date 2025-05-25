package algorithm;
import Model.Direction;
import Model.ElevatorController;
import Model.ElevatorSystem;
import algorithm.ElevatorSelectionStrategy;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ZoneStrategy extends ElevatorSelectionStrategy {

    @Override
    public int selectElevator(int floor, Direction dir) {
        List<ElevatorController> elevators = elevatorControllerList;
        int totalFloors = ElevatorSystem.INSTANCE.getFloors().size();
        int totalElevators = elevators.size();

        if (totalElevators == 0 || totalFloors == 0) {
            // fallback in case no elevators or floors are defined
            return ThreadLocalRandom.current().nextInt(1, 2);
        }

        int zoneSize = totalFloors / totalElevators;
        if (zoneSize == 0) zoneSize = 1; // avoid division by zero

        int zone = floor / zoneSize;

        ElevatorController bestElevator = null;
        int bestDistance = Integer.MAX_VALUE;

        for (ElevatorController eController : elevators) {
            int elevatorId = eController.getId();
            int elevatorZone = (elevatorId - 1); // assuming IDs start at 1 and zones index from 0

            if (elevatorZone == zone) {
                int elevatorFloor = eController.getCar().getCurrentFloor();
                Direction elevatorDir = eController.getCar().getDir();

                boolean isIdle = (elevatorDir == Direction.NONE);
                boolean sameDirection = (elevatorDir == dir);

                if (isIdle || sameDirection) {
                    int distance = Math.abs(floor - elevatorFloor);
                    if (distance < bestDistance) {
                        bestDistance = distance;
                        bestElevator = eController;
                    }
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
