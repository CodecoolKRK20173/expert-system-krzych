public class Main {
    
    public static void main(String[] args) {
        
        UI view = new UI();
        
        boolean flag = true;

        while(flag) {
            view.printMenu();
            int chooice = view.getIntegerInputFromUser("Please enter 1 or 2: ");
            if (chooice == 1) {
                ESProvider exspertSystem = new ESProvider(new FactParser(), new RuleParser());
            }
            else if  (chooice == 2) {
                flag = false;
            }
            else {
                view.cleanScreen();
                view.printMessage("No such option!");
            }
        }
    }
}