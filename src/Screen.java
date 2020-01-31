import DataPackage.*;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Screen extends JPanel implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
    //This class handles all objects being drawn to screen -- renderer + gameloop?

    private volatile boolean isrunning = true;

    private CountDownLatch latch;

    public static final Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

    inputStates inputs = new inputStates();
    ArrayList<drawableWrapper> allobjects = new ArrayList<drawableWrapper>(30);
    volatile allData entireDataSet = new allData();
    drawableWrapper selectedObject = null;

    boolean had_first_communication = false;

    HXServerJava server;
 
    // for later adding to the list
    //ArrayList<drawableWrapper> savedobjects = new ArrayList<drawableWrapper>(30);
    

    private BufferedImage offscreen;
    private Graphics2D buffer;

    int testnumber = 0;


    public Screen() {
        addKeyListener(this);
        setFocusable(true);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addMouseWheelListener(this);

        allobjects.add(new Acceleration(10,100));
        allobjects.add(new Position(30,120));
        allobjects.add(new Velocity(50,140));
        allobjects.add(new Pressure(70,160));
        allobjects.add(new Voltage(90,180));
        allobjects.add(new Current(110,200));
        allobjects.add(new MotorTemp(130,220));
        allobjects.add(new podState(10,50));
        allobjects.add(new Communication_health(200,300));


        offscreen = new BufferedImage(screensize.width, screensize.height, BufferedImage.TYPE_INT_ARGB);
        buffer = offscreen.createGraphics();

        buffer.setBackground(Color.black);

        new Thread(r).start();
        new Thread(r_server).start();
    }

    Runnable r = new Runnable() {
        @Override
        public void run() {


            boolean objectSelectBool = false;
            long lasttime = System.currentTimeMillis();
            do {

                while (isrunning) {

                    //timekeeping handled here for the connection health
                    if (had_first_communication) {
                        entireDataSet.setTime_from_last_communication(entireDataSet.getTime_from_last_communication()
                                + (System.currentTimeMillis() - lasttime));
                    }
                    lasttime = System.currentTimeMillis();


                    for(drawableWrapper object : allobjects){
                        object.updatevalues(entireDataSet);
                    }
                    if(inputs.getClick() && !objectSelectBool){
                        for(drawableWrapper object : allobjects){
                            if(object.checkContains((int)inputs.getMouseX(), (int)inputs.getMouseY())){
                                objectSelectBool = true;
                                selectedObject = object;
                                break;
                            }
                        }
                    }

                    if(objectSelectBool && inputs.getClick()){
                        selectedObject.moveposition((int)inputs.getMouseX(), (int)inputs.getMouseY());
                    } else{
                        objectSelectBool = false;
                    }



                    latch = new CountDownLatch(1);
                    //latch to synchronize threads in extreme lag, overriding paint if 1 second elapses resulting in visual bugs
                    try {
                        latch.await(1, TimeUnit.SECONDS);
                        repaint();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (inputs.getEscape()){
                        inputs.resetEscape();
                        isrunning = false;
                    }

                }

                isrunning = true; //sets isrunning to true after exiting the loop incase the exit command was a mistake determined by the following JOPtionPANE
            //probably needs to be reworked later since this is a modal dialog box which blocks execution and would cause the pod to enter a fault state from no communication
            } while (!(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?")));
            System.exit(1);
        }
    };

    Runnable r_server = new Runnable() {
        @Override
        public void run() {


            server = new HXServerJava(5000);
            entireDataSet.setTime_from_last_communication(0);
            had_first_communication = true; //cause the connection was at least created
            while (isrunning) {
                if (server.waitForConnection(10, entireDataSet)){
                    entireDataSet.setTime_from_last_communication(0);
                }

            }
            server.closeConnection();
        }
    };



    @Override
    public void paintComponent(Graphics g) {
        buffer.clearRect(0, 0, screensize.width, screensize.height);

        for(drawableWrapper object : allobjects){
            object.drawOnBuffer(buffer);
        }
        g.drawImage(offscreen, 0, 0, this);
        latch.countDown();
    }



    //********************************************************************************** mouse + Key listeners
    @Override
    public void keyTyped(KeyEvent ke) {
        //do nothing
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //do nothing
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
            inputs.setEscape();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //do nothing
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //do nothing
    }

    @Override
    public void mousePressed(MouseEvent me) {

        //presses left/right mouse button
        if (me.getButton() == MouseEvent.BUTTON1) {
            inputs.setClick();
        }
        inputs.setMouseCoorinates(me.getX(), me.getY());

    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //releases left/right mouse button
        if (me.getButton() == MouseEvent.BUTTON1) {
            inputs.resetClick();
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        inputs.setMouseCoorinates(me.getX(),me.getY());
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        inputs.setMouseCoorinates(me.getX(),me.getY());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        //do nothing
    }

}