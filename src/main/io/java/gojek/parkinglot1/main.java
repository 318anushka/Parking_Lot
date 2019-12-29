package main.io.java.gojek.parkinglot1;

import main.io.java.gojek.parkinglot1.model.Vehicle;
import main.io.java.gojek.parkinglot1.processor.Execution;
import main.io.java.gojek.parkinglot1.service.ParkingService;
import main.io.java.gojek.parkinglot1.service.implement.ServiceImplt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class main {

    public static void main(String[] args) throws IOException {

        Execution execute = new Execution();
        execute.setParkingService(new ServiceImplt());

        BufferedReader br = null;
        String input = null;

        while(true){

            br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine().trim();

            if(input.equalsIgnoreCase("exit")){
                break;
            }

            else{

                execute.execute(input);
            }

        }


        }
}
