package DataPackage;

public class allData {
    //basically just contains all the values collected from the beaglebone

    //basically a big list of variables with their typing
    //can put classes as part of this later for condensed variables ie BMS heartbeat
    double position = 0;
    double velocity = 0;
    double acceleration = 0;

    String podState = "unknown";

    public void allData(){
        //dummy constructor
    }

    //basically a big list of set functions
    public void setPosition(double newPosition){
        position = newPosition;
    }
    public void setVelocity(double newVelocity){
        velocity = newVelocity;
    }
    public void setAcceleration(double newAcceleration){
        acceleration = newAcceleration;
    }
    public void setPodState(String newPodState){
        podState = newPodState;
    }


    //basically a big list of get functions
    public double getPosition(){
        return position;
    }
    public double getVelocity(){
        return velocity;
    }
    public double getAcceleration(){
        return acceleration;
    }
    public String getPodState(){
        return podState;
    }

}
