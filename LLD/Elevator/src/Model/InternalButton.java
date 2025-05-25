package Model;

import Dispatcher.InternalDispatcher;

import java.util.ArrayList;
import java.util.List;

public class InternalButton extends Button{
    private InternalDispatcher internalDispatcher;
    private List<Integer> floors= new ArrayList<>();

    public List<Integer> getFloors() {
        return floors;
    }
    public InternalButton()
    {
        this.internalDispatcher=new InternalDispatcher();
    }
    public void pressButton(int floor, Direction dir, int elevatorId)
    {
        floors.add(floor);
        System.out.println("Pressed floor "+ floor + " from elevator "+ elevatorId);
        internalDispatcher.submitRequest(floor, dir, elevatorId);
    }
}
