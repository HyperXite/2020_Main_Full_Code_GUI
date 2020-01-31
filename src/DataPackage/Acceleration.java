package DataPackage;

import java.awt.*;

public class Acceleration extends drawableWrapper{
    private double acceleration;

    public Acceleration(int setXposition, int setYposition){
        super(setXposition,setYposition);
        acceleration = 0;
        yHeight = 45;
        xWidth = 100;
    }



    @Override
    public void updatevalues(allData entireDataSet) {
        acceleration = entireDataSet.getAcceleration();
    }

    @Override
    public void drawOnBuffer(Graphics2D buffer) {
        buffer.setColor(Color.red);
        buffer.drawRect(xPosition,yPosition, xWidth, yHeight);

        buffer.setColor(Color.white); //simple drawing of the strings at their positions
        buffer.drawString("Acceleration: "+ acceleration, xPosition, yPosition + yHeight/3);
    }
}
