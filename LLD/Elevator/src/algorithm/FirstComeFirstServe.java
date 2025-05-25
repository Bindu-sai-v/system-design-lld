package algorithm;

import Model.Direction;
import Model.ElevatorCar;
import Model.ElevatorController;
import algorithm.PendingRequests;

import java.util.Queue;

public class FirstComeFirstServe extends ElevatorControlStrategy {

    @Override
    public void moveElevator(ElevatorController elevatorController) {
        ElevatorCar car = elevatorController.getCar();
        Queue<PendingRequests> queue = elevatorController.getPendingRequests();

        if (queue.isEmpty()) {
            // No requests to process
            System.out.println("Elevator " + elevatorController.getId() + " is idle at floor " + car.getCurrentFloor());
            car.setDir(Direction.NONE);
            return;
        }

        PendingRequests currentRequest = queue.peek();
        int currentFloor = car.getCurrentFloor();
        int targetFloor = currentRequest.getFloor();

        if (currentFloor == targetFloor) {
            // Arrived at requested floor
            System.out.println("Elevator " + elevatorController.getId() + " stops at floor " + targetFloor);
            System.out.println("Door opened at floor " + targetFloor);
            System.out.println("Door closed at floor " + targetFloor);

            // Remove request from queue
            queue.poll();

            // Set direction NONE if queue empty, else determine next direction
            if (queue.isEmpty()) {
                car.setDir(Direction.NONE);
            } else {
                int nextFloor = queue.peek().getFloor();
                car.setDir(nextFloor > currentFloor ? Direction.UP : Direction.DOWN);
            }
        } else if (currentFloor < targetFloor) {
            // Move up one floor
            System.out.println("Elevator " + elevatorController.getId() + " moving UP");
            car.setCurrentFloor(currentFloor + 1);
            car.setDir(Direction.UP);
        } else {
            // Move down one floor
            System.out.println("Elevator " + elevatorController.getId() + " moving DOWN");
            car.setCurrentFloor(currentFloor - 1);
            car.setDir(Direction.DOWN);
        }
    }
}
