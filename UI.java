import java.util.*;

public class UI {

    public void printMenu() {
        printSeparateLine();
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
        System.out.println("=================================================================================================================================");
    }

    public void printThickSeparateline() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
    }

    public String getStringInputFromUser() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public void printResultsOfProgram(String summary) {
        if (summary.equals("Cannot solve problem")) {
            printSeparateLine();
            System.out.println("Program can't give You solution beacuse Your answer aren't matching to schedule. Think about Your answers and try again.");
            printThickSeparateline();
        }
        else {
            printSeparateLine();
            System.out.println("Expert System recommend You to buy " + summary + "!");
            printThickSeparateline();
        }
    }

    public void cleanScreen() {
        System.out.print("\033\143");
    }
}