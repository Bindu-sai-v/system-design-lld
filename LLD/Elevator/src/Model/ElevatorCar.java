package Model;

public class ElevatorCar {
    private int id;               // Elevator identifier
    private int currentFloor;
    private Direction dir;
    private final Door door;

    public ElevatorCar(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.dir = Direction.NONE;
        this.door = new Door(); // Initialize door here
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int floor) {
        this.currentFloor = floor;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public void move(Direction dir, int destinationFloor) {
        System.out.println("Elevator " + id + " moving " + dir);
        currentFloor = destinationFloor;
        System.out.println("Elevator " + id + " stops at floor " + currentFloor);
        door.open(currentFloor);
        door.close(currentFloor);
    }

}
