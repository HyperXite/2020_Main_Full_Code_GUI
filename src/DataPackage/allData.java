package DataPackage;

public class allData {
    //basically just contains all the values collected from the beaglebone

    //basically a big list of variables with their typing
    //can put classes as part of this later for condensed variables ie BMS heartbeat
    double position = 0;
    double velocity = 0;
    double acceleration = 0;
    double pressure = 0;
    double motor_temp = 0;
    double voltage = 0;
    double current = 0;
    long time_from_last_communication = 9999999;

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
    public void setPressure(double newPressure){
        pressure = newPressure;
    }
    public void setMotorTemp(double newMotorTemp){
        motor_temp = newMotorTemp;
    }
    public void setVoltage(double newVoltage){
        voltage = newVoltage;
    }
    public void setCurrent(double newCurrent){
        current = newCurrent;
    }
    public void setPodState(String newPodState){
        podState = newPodState;
    }
    public void setTime_from_last_communication(long newtime_from_last_communication) {time_from_last_communication = newtime_from_last_communication;}

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
    public double getPressure(){
    	return pressure;
    }
    public double getMotorTemp(){
    	return motor_temp;
    }
    public double getVoltage(){
    	return voltage;
    }
    public double getCurrent(){
    	return current;
    }
    public String getPodState(){
        return podState;
    }
    public long getTime_from_last_communication() {return time_from_last_communication;}

}
