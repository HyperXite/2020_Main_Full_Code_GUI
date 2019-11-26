public class inputStates {
    //stores the current user inputs, in its own object incase we need to have a press that lasts longer than a single instant
    //also makes it easier to pass to the update function
    private double MouseX;
    private double MouseY;
    private boolean click;
    private boolean escape;

    inputStates() { //initialize to no inputs
        resetAll();
    }


    //***************************************** resetting
    public void resetAll() {
        click = false;
        escape = false;
    }
    public void resetClick(){
        click = false;
    }
    public void resetEscape() { escape = false;}

    //********************************************* end reseting

    //*********************************************setting

    public void setMouseCoorinates(double newx, double newy){
        MouseX = newx;
        MouseY = newy;
    }

    public void setClick(){
        click = true;
    }
    public void setEscape() { escape = true; }

    //************************************* end setting


    //************************************* getting
    public double getMouseX(){
        return MouseX;
    }

    public double getMouseY(){
        return MouseY;
    }

    public boolean getClick(){
        return click;
    }

    public boolean getEscape() {return escape;}

    //*********************************** end getting
}