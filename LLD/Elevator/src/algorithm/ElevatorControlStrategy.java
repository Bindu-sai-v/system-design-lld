package algorithm;

import Model.ElevatorController;
import Model.ElevatorSystem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorControlStrategy {
    // Queue storing pending requests
    private Queue<PendingRequests> pendingRequestList = new LinkedList<PendingRequests>();
    private List<ElevatorController> elevatorControllerList = ElevatorSystem.INSTANCE.getElevatorControllerList();

    // Getter for pendingRequestList
    public Queue<PendingRequests> getPendingRequestList() {
        return pendingRequestList;
    }

    // Setter for pendingRequestList
    public void setPendingRequestList(Queue<PendingRequests> pendingRequestList) {
        this.pendingRequestList = pendingRequestList;
    }

    // Getter for elevatorControllerList
    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    public void moveElevator(ElevatorController elevatorController) {
        // Implementation logic here
    }
}
