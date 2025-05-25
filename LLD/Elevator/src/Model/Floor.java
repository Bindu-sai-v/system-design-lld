package Model;

public class Floor {
    private int id;
    private Display display;
    private Button button;
    public Floor(int id)
    {
        this.id=id;
        button=new ExternalButton();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(int floor,Direction dir) {
       display.setFloor(floor);
       display.setDir(dir);
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
    public void pressButton(Direction dir)
    {
        button.pressButton(id,dir);
    }
}
