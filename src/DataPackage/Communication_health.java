package DataPackage;

import java.awt.*;

public class Communication_health extends drawableWrapper {
    private long time_from_last_communication;

    public Communication_health(int x, int y){
        super(x,y);
        time_from_last_communication = 9999999;
        xWidth = 200;
        yHeight = 25;
    }

    @Override
    public void updatevalues(allData entireDataSet) {
        time_from_last_communication = entireDataSet.getTime_from_last_communication();
    }

    @Override
    public void drawOnBuffer(Graphics2D buffer) {
        buffer.setColor(Color.red);
        buffer.drawRect(xPosition,yPosition, xWidth, yHeight);

        buffer.setColor(Color.white); //simple drawing of the strings at their positions
        buffer.drawString("Last communication: " + time_from_last_communication, xPosition, yPosition + yHeight/2);
    }
    //stores time from last successful communication
}
