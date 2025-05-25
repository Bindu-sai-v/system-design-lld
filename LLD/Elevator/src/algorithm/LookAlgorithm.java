package algorithm;

import Model.Direction;
import Model.ElevatorCar;
import Model.ElevatorController;

import java.util.*;

public class LookAlgorithm extends ElevatorControlStrategy {
    private final Map<Integer, Boolean> directionMap = new HashMap<>(); // Tracks direction per elevator

    @Override
    public void moveElevator(ElevatorController elevator) {
        if (elevator.getPendingRequests().isEmpty()) {
            System.out.println("No pending requests for elevator " + elevator.getId());
            return;
        }
        serve(elevator);
    }

    private void serve(ElevatorController elevator) {
        ElevatorCar car = elevator.getCar();
        Queue<PendingRequests> queue = elevator.getPendingRequests();

        List<Integer> upList = new ArrayList<>();
        List<Integer> downList = new ArrayList<>();
        int current = car.getCurrentFloor();

        while (!queue.isEmpty()) {
            PendingRequests req = queue.poll();
            if (req.getFloor() >= current) {
                upList.add(req.getFloor());
            } else {
                downList.add(req.getFloor());
            }
        }

        Collections.sort(upList);
        Collections.sort(downList, Collections.reverseOrder());

        car.setDir(Direction.UP);
        for (int floor : upList) {
            car.move(Direction.UP, floor);
        }

        car.setDir(Direction.DOWN);
        for (int floor : downList) {
            car.move(Direction.DOWN, floor);
        }

        car.setDir(Direction.NONE);
    }
}
