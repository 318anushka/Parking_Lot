package main.io.java.gojek.parkinglot1;

import main.io.java.gojek.parkinglot1.exception.ParkingException;
import main.io.java.gojek.parkinglot1.model.Vehicle;
import main.io.java.gojek.parkinglot1.processor.Execution;
import main.io.java.gojek.parkinglot1.processor.Validation;
import main.io.java.gojek.parkinglot1.service.ParkingService;
import main.io.java.gojek.parkinglot1.service.implement.ServiceImplt;
import main.io.java.gojek.parkinglot1.exception.Error;

import java.io.*;
import java.util.Optional;

public class main {

    public static void main(String[] args) throws ParkingException, IOException {

        Execution execute = new Execution();
        Validation validate = new Validation();
        execute.setParkingService(new ServiceImplt());

        BufferedReader br = null;
        String input = null;

        switch (args.length) {

            case 0:

            {
            while (true) {

                try {
                    br = new BufferedReader(new InputStreamReader(System.in));
                    input = br.readLine().trim();

                    if (input.equalsIgnoreCase("exit")) {
                        break;
                    } else {

                        if (validate.validate(input)) {
                            try {
                                execute.execute(input);
                            } catch (Exception e) {

                                System.out.println(e.getMessage());
                            }
                        } else {
                            inputFormat();
                        }
                    }
                } catch (Exception e) {
                    //System.out.println("Invalid Request");
                    throw new ParkingException(Error.INVALID_REQUEST.getMessage(), e);

                }

            }
            }

            case 1: {

                try {

                    File inputFile = new File(args[0]);
                    br = new BufferedReader(new FileReader(inputFile));
                    while (br.readLine() != null) {

                        input = input.trim();

                        if (validate.validate(input)) {
                            try {

                                execute.execute(input);
                            }
                            catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                        } else {
                            inputFormat();
                        }
                    }

                }
                catch(Exception e){

                    throw new ParkingException(Error.INVALID_REQUEST.getMessage() , e);
                }
            }

        }
    }

    private static void inputFormat() {

        StringBuilder sb = new StringBuilder();

        sb = sb.append(
                "--------------Please Enter one of the below commands. -----------------------")
                .append("\n");
        sb = sb.append(" For creating parking lot of size n               ---> create_parking_lot {capacity}")
                .append("\n");
        sb = sb
                .append(" To park a car                                    ---> park <<car_number>> {car_clour}")
                .append("\n");
        sb = sb.append(" Unpark car from parking                  ---> leave {slot_number}")
                .append("\n");
        sb = sb.append(" Print status of parking slot                     ---> status").append("\n");
        sb = sb.append(
                " Get cars registration no for the given car color ---> registration_numbers_for_cars_with_color {car_color}")
                .append("\n");
        sb = sb.append(
                " Get slot numbers for the given car color         ---> slot_numbers_for_cars_with_color {car_color}")
                .append("\n");
        sb = sb.append(
                " Get slot number for the given car number         ---> slot_number_for_registration_number {car_number}")
                .append("\n");
        System.out.println(sb.toString());

    }


}
