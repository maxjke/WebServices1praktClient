package lt.eif.viko.mjakovcenko.client.menu;


import lt.eif.viko.mjakovcenko.client.JavaClient;
import lt.eif.viko.mjakovcenko.client.converter.Converter;

import java.io.IOException;
import java.util.Scanner;




public class Menu {


    public static int displayMenu(Scanner input){
        System.out.println("Make a selection");
        System.out.println("------------------");
        System.out.printf("| 1) %20s \n", "Receive file from server");
        System.out.printf("| 2) %20s \n", "Convert xsd to classes using xjc");
        System.out.printf("| 3) %20s \n", "Quit");
        return input.nextInt();
    }


    public static void showMenu(){
        Scanner input = new Scanner(System.in);
        int userChoice;
        do{
            userChoice = displayMenu(input);
            switch(userChoice){
                case 1:
                    JavaClient client = new JavaClient();
                    try {
                        client.startConnection("localhost", 7777);
                    } catch (IOException e) {
                        System.out.println("Exception occurred: " + e.getMessage());
                    }
                    break;
                case 2 :
                    Converter.convertoToPojoFromXsd();
                    break;
                case 3:
                    System.out.println("Quitting");
                    System.exit(0);
                    break;
                default:

                    break;

            }
        }while(userChoice!=6);
    }
}