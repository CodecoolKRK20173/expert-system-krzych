public class Main {
    
    public static void main(String[] args) {
        
        UI view = new UI();
        view.printMenu();
        boolean flag = true;

        while(flag) {
            int chooice = view.getIntegerInputFromUser("Please enter 1 or 2: ");
            if (chooice == 1) {
                ESProvider exspertSystem = new ESProvider(new FactParser(), new RuleParser());
            }
            else if  (chooice == 2) {
                flag = false;
            }
            else {
                view.printMessage("No such option!");
            }
        }
    }
}