import java.util.*;

public class UI {

    public void printMenu() {
        System.out.println("Welcome in Expert Analyzer Program!");
        printSeparateLine();
        System.out.println("1. Start program");
        System.out.println("2. Exit program");
        printSeparateLine();
    }

    public int getIntegerInputFromUser(String message) {

        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        
        boolean flag = true;
        int chooice = 0;
        while(flag) {
        try {
            chooice = scan.nextInt();
            flag = false;
        }
        catch (InputMismatchException err) {
            System.out.println("Bad input!");
            scan.nextLine();
        }  
    }
        return chooice;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printSeparateLine() {
        System.out.println("=====================================================================");
    }

    public String getStringInputFromUser() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}