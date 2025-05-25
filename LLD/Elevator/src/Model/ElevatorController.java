package Model;

import algorithm.PendingRequests;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorController {
    private int id;
    private ElevatorCar car;
    private Queue<PendingRequests> pendingRequests;

    public ElevatorController(int id) {
        this.id = id;
        this.car = new ElevatorCar(id);
        this.pendingRequests = new PriorityQueue<>(Comparator.comparingInt(PendingRequests::getFloor));
    }

    public int getId() {
        return id;
    }

    public ElevatorCar getCar() {
        return car;
    }

    public Queue<PendingRequests> getPendingRequests() {
        return pendingRequests;
    }

    public void acceptRequest(int floor, Direction dir) {
        pendingRequests.add(new PendingRequests(floor, dir));
    }
}
