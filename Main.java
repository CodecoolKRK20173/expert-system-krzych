public class Main {
    
    public static void main(String[] args) {
        
        UI view = new UI();
        
        boolean flag = true;

        while(flag) {
            view.printMenu();
            int chooice = view.getIntegerInputFromUser("Please enter 1,2 or 3: ");
            if (chooice == 1) {
                ESProvider exspertSystem = new ESProvider(new FactParser(), new RuleParser());
            }
            else if  (chooice == 2) {
                view.cleanScreen();
                view.printMessage("Your friend ask You for substitute him in his job. He's a mudlogger.\n You agreed because it was supposed to be light shift, break in project. \n However, after two hour to Your lab has entered Well Site Geologist and said that drilling will start for ten minutes.\n Rate of penetration will  be 10 meter per hour, so You have to describe 4 samples per hour, one sample per 15 minutes.\n\nYou are afraid because You haven't knowledge about geology!\n \n Don't worry, to succor comes GeoExpert Analyzer Program!");
                
            }
            else if  (chooice == 3) {
                flag = false;
            }
            else {
                view.cleanScreen();
                view.printMessage("No such option!");
            }
        }
    }
}