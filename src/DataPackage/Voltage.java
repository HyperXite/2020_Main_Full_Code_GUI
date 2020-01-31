package DataPackage;

import java.awt.*;

public class Voltage extends drawableWrapper{

    private double voltage;

    public Voltage(int setXposition, int setYposition){
        super(setXposition,setYposition);
        voltage = 0;
        yHeight = 45;
        xWidth = 100;
    }



    @Override
    public void updatevalues(allData entireDataSet) {
        voltage = entireDataSet.getVoltage();
    }

    @Override
    public void drawOnBuffer(Graphics2D buffer) {
        buffer.setColor(Color.red);
        buffer.drawRect(xPosition,yPosition, xWidth, yHeight);

        buffer.setColor(Color.white); //simple drawing of the strings at their positions
        buffer.drawString("Voltage: "+ voltage, xPosition, yPosition + yHeight/3);
    }
}
