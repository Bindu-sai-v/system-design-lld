package Model;

import algorithm.ElevatorControlStrategy;
import algorithm.ElevatorSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private List<ElevatorController> elevatorControllerList = new ArrayList<ElevatorController>();
    public static ElevatorControlStrategy elevatorControlStrategy;
    public static ElevatorSelectionStrategy elevatorSelectionStrategy;
    public List<Floor> floors = new ArrayList<Floor>();

    public static ElevatorSystem INSTANCE = new ElevatorSystem();

    // Private constructor to enforce singleton
    private ElevatorSystem() {
    }

    // Explicit getter for elevatorControllerList
    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    // Explicit getter for floors
    public List<Floor> getFloors() {
        return floors;
    }

    // Explicit getter for elevatorControlStrategy
    public static ElevatorControlStrategy getElevatorControlStrategy() {
        return elevatorControlStrategy;
    }

    // Explicit getter for elevatorSelectionStrategy
    public static ElevatorSelectionStrategy getElevatorSelectionStrategy() {
        return elevatorSelectionStrategy;
    }

    // Add an elevator
    public void addElevator(ElevatorController e) {
        elevatorControllerList.add(e);
    }

    // Remove an elevator
    public void removeElevator(ElevatorController e) {
        elevatorControllerList.remove(e);
    }

    // Set the elevator control strategy
    public void setElevatorControlStrategy(ElevatorControlStrategy strategy) {
        elevatorControlStrategy = strategy;
    }

    // Set the elevator selection strategy
    public void setElevatorSelectionStrategy(ElevatorSelectionStrategy strategy) {
        elevatorSelectionStrategy = strategy;
    }

    // Add a floor
    public void addFloor(Floor floor) {
        floors.add(floor);
    }
}
