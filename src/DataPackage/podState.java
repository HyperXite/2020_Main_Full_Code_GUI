package DataPackage;

import java.awt.*;

public class podState extends drawableWrapper {
    private String state;

    public podState(int setXposition, int setYposition){
        state = "unknown";
        xPosition = setXposition;
        yPosition = setYposition;
        yHeight = 100;
        xWidth = 75;
    }



    @Override
    public void updatevalues(allData entireDataSet) {
        state = entireDataSet.getPodState();
    }

    @Override
    public void drawOnBuffer(Graphics2D buffer) {
        buffer.setColor(Color.red);
        buffer.drawRect(xPosition,yPosition, xWidth, yHeight);

        buffer.setColor(Color.white); //simple drawing of the strings at their positions
        buffer.drawString("current state", xPosition, yPosition + 15);
        buffer.drawString(state, xPosition, yPosition + 30);

        if(state != "fault"){
            buffer.setColor(Color.GREEN);
        } else{
            buffer.setColor(Color.RED);
        }

        buffer.fillOval(xPosition, yPosition + 30, xWidth, yHeight - 30);

    }
}
