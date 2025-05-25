package Model;

import Dispatcher.ExternalDispatcher;
import Dispatcher.InternalDispatcher;

public class ExternalButton extends Button{
    private ExternalDispatcher externalDispatcher;
    private Direction direction;
    public ExternalButton()
    {
        externalDispatcher=new ExternalDispatcher();
    }
    public void pressButton(int floor, Direction dir)
    {
        direction= dir;
        System.out.println("Pressed " + direction + " from floor " + floor);
        externalDispatcher.submitRequest(floor, dir);
    }

}
