package DataPackage;

import java.awt.*;

public class Position extends drawableWrapper{
 //   private double acceleration;
    private double position;
   // private double velocity;

    public Position(int setXposition, int setYposition){
        super(setXposition,setYposition);
        position = 0;
        yHeight = 45;
        xWidth = 100;
    }



    @Override
    public void updatevalues(allData entireDataSet) {
 //       acceleration = entireDataSet.getAcceleration();
        position = entireDataSet.getPosition();
  //      velocity = entireDataSet.getVelocity();
    }

    @Override
    public void drawOnBuffer(Graphics2D buffer) {
        buffer.setColor(Color.red);
        buffer.drawRect(xPosition,yPosition, xWidth, yHeight);

        buffer.setColor(Color.white); //simple drawing of the strings at their positions
        buffer.drawString("Position: "+ position, xPosition, yPosition + yHeight/3);
  //      buffer.drawString("Velocity: "+ velocity, xPosition, yPosition + 2*yHeight/3);
  //      buffer.drawString("Acceleration: "+ acceleration, xPosition, yPosition + yHeight);
    }
}