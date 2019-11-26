package DataPackage;

import java.awt.*;

public abstract class drawableWrapper {
    //this is the wrapper for creating a drawable unit for the GUI
    //basically you extend this for whatever number or value needs to be represented on the GUI
    //create a graphic/visual representation that scales with the size given to it, though set a default size that will
    //most likely be respected by the GUI and not need resizing

    //basically the user/ code elsewhere will determine where to place the blocks of data
    //these blocks need to be able to take the entire structure of inputs, figure out which corresponds with themselves,
    //and update their values and graphics accordingly at each step.

    //blocks of data can be larger than single instances as long as they accordingly collect their values. this is good
    //for blocks of data that logically go together in one graphic such as the health check table or the BMS heartbeat

    protected int xWidth = 50; //default X and Y numbers if none are specified either by the main or a subclass
    protected int yHeight = 15;

    protected int xPosition = 0; //these definitely need to be set by the constructor or somewhere else otherwise overlapping will occur
    protected int yPosition = 0;

    public abstract void updatevalues(allData entireDataSet);

    public abstract void drawOnBuffer(Graphics2D buffer);

    public void moveposition(int newX, int newY){
        xPosition = newX;
        yPosition = newY;
    }

    public boolean checkContains(int X, int Y){
        if(xPosition <= X && xPosition + xWidth >= X ){
            if(yPosition <= Y && yPosition + yHeight >= Y){
                return true;
            }
        }
        return false;
    }


}
