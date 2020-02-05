import DataPackage.allData;

public class opcodeHandler {
    //used because the opcodes are 1 char but this helps turn them into readable variables when used in the server class
    //basically treat these as a #define

    public final char SUCCESS = 'a';
    public final char FAILURE = 'b';

    //for computer to BBB communications
    public final char START_RECORDING = 'c';
    public final char END_RECORDING = 'd';
    public final char START_RUN = 'e';
    public final char END_RUN = 'f';
    public final char ADD_CSV_DATA = 'g';
    public final char remove_CSV_DATA = 'h';
    public final char EXIT_FAULT = 'i';


    //for BBB to computer communications also the second part of the add CSV stuff
    public final char TEMPERATURE = 'c';
    public final char VELOCITY = 'd';
    public final char ACCELERATION = 'e';
    public final char PRESSURE_1 = 'f';
    public final char PRESSURE_2 = 'g';
    public final char PRESSURE_3 = 'h';
    public final char PRESSURE_4 = 'i';
    public final char STATE = 'j';
    public final char BMS_VOLTAGE = 'k';
    public final char BMS_CURRENT = 'l';


    public opcodeHandler(){
        //empty constructor
    }

    //TODO maybe change this to have a return on the success of the handle
    public void handleIncoming(String[] command, allData data){
        switch(command[0].toLowerCase().charAt(0)){
            //figure out what command is incoming and then handle it
            case(TEMPERATURE):
                data.setMotorTemp(Double.parseDouble(command[1]));
                break;
            case(VELOCITY):
                data.setVelocity(Double.parseDouble(command[1]));
                break;
            case(ACCELERATION):
                data.setAcceleration(Double.parseDouble(command[1]));
                break;
            case(STATE):
                data.setPodState(command[1]);
                break;
            case(BMS_VOLTAGE):
                data.setVoltage(Double.parseDouble(command[1]));
                break;
            case(BMS_CURRENT):
                data.setCurrent(Double.parseDouble(command[1]));
        }
    }


}
