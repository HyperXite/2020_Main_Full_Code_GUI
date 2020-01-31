package DataPackage;

import java.awt.*;

public class Pressure extends drawableWrapper{

    private double pressure;

    public Pressure(int setXposition, int setYposition){
        super(setXposition,setYposition);
        pressure = 0;
        yHeight = 45;
        xWidth = 100;
    }



    @Override
    public void updatevalues(allData entireDataSet) {
        pressure = entireDataSet.getPressure();
    }

    @Override
    public void drawOnBuffer(Graphics2D buffer) {
        buffer.setColor(Color.red);
        buffer.drawRect(xPosition,yPosition, xWidth, yHeight);

        buffer.setColor(Color.white); //simple drawing of the strings at their positions
        buffer.drawString("Pressure: "+ pressure, xPosition, yPosition + yHeight/3);
    }
}
