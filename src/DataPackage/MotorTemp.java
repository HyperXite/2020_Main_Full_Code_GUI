package DataPackage;

import java.awt.*;

public class MotorTemp extends drawableWrapper{

    private double motor_temp;

    public MotorTemp(int setXposition, int setYposition){
        super(setXposition, setYposition);
        motor_temp = 0;
        xPosition = setXposition;
        yPosition = setYposition;
        yHeight = 45;
        xWidth = 100;
    }



    @Override
    public void updatevalues(allData entireDataSet) {
    	motor_temp = entireDataSet.getMotorTemp();
    }

    @Override
    public void drawOnBuffer(Graphics2D buffer) {
        buffer.setColor(Color.red);
        buffer.drawRect(xPosition,yPosition, xWidth, yHeight);

        buffer.setColor(Color.white); //simple drawing of the strings at their positions
        buffer.drawString("Motor Temp: "+ motor_temp, xPosition, yPosition + yHeight/3);
    }
}
