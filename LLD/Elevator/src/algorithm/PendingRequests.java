package algorithm;

import Model.Direction;

public class PendingRequests {
    private int floor;
    private Direction dir;

    public  PendingRequests(int floor, Direction dir)
    {
        this.floor= floor;
        this.dir= dir;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }
}
