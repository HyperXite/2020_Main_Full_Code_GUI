package DataPackage;

import java.awt.*;

public class Current extends drawableWrapper{

    private double current;

    public Current(int setXposition, int setYposition){
        super(setXposition,setYposition);
        current = 0;
        yHeight = 45;
        xWidth = 100;
    }



    @Override
    public void updatevalues(allData entireDataSet) {
        current = entireDataSet.getCurrent();
    }

    @Override
    public void drawOnBuffer(Graphics2D buffer) {
        buffer.setColor(Color.red);
        buffer.drawRect(xPosition,yPosition, xWidth, yHeight);

        buffer.setColor(Color.white); //simple drawing of the strings at their positions
        buffer.drawString("Current: "+ current, xPosition, yPosition + yHeight/3);
    }
}
