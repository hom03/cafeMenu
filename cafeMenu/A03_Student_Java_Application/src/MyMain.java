// ---------------------------
// Imports
// ---------------------------
import java.util.Scanner;

// ---------------------------
// CLASS MyMain
// ---------------------------
/**
 * This is the main class for the A03 Student Application,
 * representing the management of a coffee truck.<br>
 */
public class MyMain {

    // -------------------------
    // print menu
    // -------------------------
    /**
     * This displays a menu of functionalities on the screen to the user.<br>
     */
    public static void printMenu(){
        System.out.println("--------------------------------");
        System.out.println("--------------Menu--------------");
        System.out.println("--------------------------------");
        System.out.println("0. Exit");
        System.out.println("1. Add Customer");
        System.out.println("2. Remove Customer");
        System.out.println("3. Print Customer Info");
        System.out.println("4. Display all Product IDs");
        System.out.println("5. Add a Coffee Related Product");
        System.out.println("6. Add a Tea Related Product");
        System.out.println("7. Remove a product");
        System.out.println("8. Make an Order");
        System.out.println("9. Load Database from disk");
        System.out.println("10. Save Database to disk");
        System.out.println("\n");
    }

    // -------------------------
    // ChooseIntOption
    // -------------------------
    /**
     * This asks the user to input a valid integer from a range of thresholds based off the menu questions.<br>
     * @param scan -The scanner taking the keyboard input
     * @param lt - The lower threshold number that can be inputted.
     * @param ut - The upper threshold number that can be inputted.
     * @return - Returns the value inputted by the keyboard
     */
    public static int ChooseIntOption(Scanner scan,int lt, int ut){
        int res = -1;
        boolean validInt = false;
        while (!validInt){
            System.out.println("Please input a valid option from " + lt + " to " + ut +" in the menu");
            try {
                res = scan.nextInt();
                scan.nextLine();
                if (res >= lt && res <= ut){
                    validInt = true;
                }else{
                    System.out.println("Inputs must be in between "+ lt + " and " + ut + " to be valid.");
                }
            }
            catch (Exception e){
                System.out.println("Sorry you have not inputted an integer");
                scan.next();
            }
        }
        return res;
    }
    // -------------------------
    // ChooseIntOption
    // -------------------------
    /**
     * This asks the user to input a valid integer from a range of thresholds based off the menu questions.<br>
     * @param scan -The scanner taking the keyboard input
     * @return - Returns the value inputted by the keyboard
     */
    public static int ChooseIntOption(Scanner scan){
        int res = -1;
        boolean validInt = false;
        while (!validInt){
            System.out.println("Please input an integer");
            try {
                res = scan.nextInt();
                scan.nextLine();
                    validInt = true;
            }
            catch (Exception e){
                System.out.println("Sorry you have not inputted an integer");
                scan.next();
            }
        }
        return res;
    }

    //--------------------------------------------------
    //	selectStringOption
    //--------------------------------------------------
    /**
     * This function asks the user to enter a valid String value.<br>
     * @param scan - The scanner getting the input value by keyboard
     */
    public static String ChooseStringOption(Scanner scan){
        String res = "";
        boolean validString = false;
        while (!validString){
            System.out.println("Please enter a valid string");
            try{
                res = scan.nextLine();
                if (!res.isEmpty()){
                    validString = true;
                }else{
                    System.out.println("Please enter a non empty string");
                }
            }
            catch (Exception i){
                System.out.println("Sorry you did not enter a string");
                scan.next();
            }
        }return res;
    }
    //--------------------------------------------------
    //	ChooseBoolOption
    //--------------------------------------------------
    /**
     * This function asks the user to enter a valid boolean value.<br>
     * @param scan - The scanner getting the input value by keyboard
     */
    public static boolean ChooseBoolOption(Scanner scan){
        boolean res = false;
        boolean validOption = false;
        while (!validOption){
            System.out.println("Please enter a valid boolean value.");
            try{
                res = scan.nextBoolean();
                validOption = true;
            }catch (Exception e){
                System.out.println("You have not entered a boolean.");
                scan.next();
            }
        }return res;
    }
    //--------------------------------------------------
    //	ChooseFloatOption
    //--------------------------------------------------
    /**
     * This function asks the user to enter a valid float value.<br>
     * @param scan - The scanner getting the input value by keyboard
     */
    public static float ChooseFloatOption(Scanner scan){
        float res = 0.0f;
        boolean validOption = false;
        while (!validOption){
            System.out.println("Please enter a valid float value.");
            try{
                res = scan.nextFloat();
                validOption = true;
            }catch (Exception e){
                System.out.println("You have not entered a float.");
                scan.next();
            }
        }return res;
    }
    // -------------------------
    // Interact with menu
    // -------------------------
    /**
     * This function performs the interactive session to the user.<br>
     * @param customerFileName - The name of the database file for customers.
     * @param productFileName - The name of the database file for products.
     * @param maxOrderProducts - The maximum amount orders a customer can make per day.
     */
    public static void interactiveMenu(String customerFileName,String productFileName,int maxOrderProducts) {
        CoffeeTruck c = new CoffeeTruckImp(maxOrderProducts);
        boolean over = false;
        int option;
        Scanner scan = new Scanner(System.in);

        while (!over) {
            printMenu();
            option = ChooseIntOption(scan, 0, 10);

            String myString;
            String myString2;
            int myInt;
            int myInt2;
            boolean myBool;
            boolean myBool2;
            float myFloat;

            switch (option) {
                case 0 -> over = true;

                case 1 -> {
                    //add customer
                    System.out.println("----------------------Add Customer----------------------\n");
                    System.out.println("Please input the customer's name:");
                    myString = ChooseStringOption(scan);
                    myInt = c.addCustomer(myString);
                    System.out.println("New customer "+myInt+"\n3successfully added.");
                }
                case 2 -> {
                    //remove customer
                    System.out.println("----------------------Remove Customer----------------------\n");
                    System.out.println("Please input the customer id you want removed:");
                    myInt = ChooseIntOption(scan);
                    myInt = c.removeCustomer(myInt);
                    if (myInt == -1){
                        System.out.println("Sorry no customer id is assigned to"+myInt+"so the remove operation cannot be completed.");
                    }else{
                        System.out.println("Customer with id "+myInt+",successfully removed");
                    }
                }
                case 3 -> {
                    //print customer info
                    System.out.println("----------------------Print Customer Info----------------------\n");
                    System.out.println("Please input the customer id you want to view:");
                    myInt = ChooseIntOption(scan);
                    c.printCustInfo(myInt);
                }
                case 4 -> {
                    //display all product IDs
                    System.out.println("----------------------Display all product IDs----------------------\n");
                    c.displayAllProductIDs();
                }
                case 5 -> {
                    //add coffee product
                    System.out.println("----------------------Add Coffee Product----------------------\n");
                    System.out.println("Please enter the type of coffee: ");
                    myString = ChooseStringOption(scan);
                    System.out.println("How many sugars would you like: ");
                    myInt = ChooseIntOption(scan);
                    System.out.println("Enter price of "+myString+ ": ");
                    myFloat = ChooseFloatOption(scan);
                    System.out.println("Would you like to add milk?(True for yes, False for no");
                    myBool = ChooseBoolOption(scan);
                    System.out.println("What size cup would you like? (1 for small,2 for medium, 3 for large): ");
                    myInt2 = ChooseIntOption(scan);
                    System.out.println("Would you like hot or iced coffee? (True for hot, False for iced)");
                    myBool2 = ChooseBoolOption(scan);
                    myInt = c.Coffee(myString,myInt,myFloat,myBool,myInt2,myBool2);
                    System.out.println("New coffee product "+myString+" successfully created with id "+myInt+".");
                }
                case 6 -> {
                    //add tea product
                    System.out.println("----------------------Add Tea Product----------------------\n");
                    System.out.println("Please enter the type of tea: ");
                    myString = ChooseStringOption(scan);
                    System.out.println("How many sugars would you like: ");
                    myInt = ChooseIntOption(scan);
                    System.out.println("Enter price of "+myString+ ": ");
                    myFloat = ChooseFloatOption(scan);
                    System.out.println("Would you like to add milk?");
                    myBool = ChooseBoolOption(scan);
                    System.out.println("What size cup would you like? (1 for small,2 for medium, 3 for large): ");
                    myInt2 = ChooseIntOption(scan);
                    System.out.println("What flavour would you like in your tea?");
                    myString2 = ChooseStringOption(scan);
                    myInt = c.Tea(myString,myInt,myFloat,myBool,myInt2,myString2);
                    System.out.println("New tea product "+myString+" successfully created with id "+myInt+".");
                }
                case 7 -> {
                    //remove product
                    System.out.println("----------------------Remove Product----------------------\n");
                    System.out.println("Please input the product id you want removed:");
                    myInt = ChooseIntOption(scan);
                    myInt = c.removeProduct(myInt);
                    if (myInt == -1){
                        System.out.println("Sorry no product id is assigned to"+myInt+"so the remove operation cannot be completed.");
                    }else{
                        System.out.println("Product with id "+myInt+",successfully removed");
                    }
                }
                case 8 -> {
                    //make order
                    System.out.println("----------------------Make Order----------------------\n");
                    System.out.println("Please choose which customer is ordering: ");
                    myInt = ChooseIntOption(scan);
                    System.out.println("Please choose what product this customer wants to purchase");
                    myInt2 = ChooseIntOption(scan);
                    Order newOrder = c.makeOrder(myInt,myInt2);
                    System.out.println(newOrder);
                }
                case 9 -> {
                    //load DB
                    System.out.println("----------------------Load Database----------------------\n");
                    myBool = c.loadDatabase(customerFileName,productFileName);
                    if (!myBool){
                        System.out.println("Sorry we cannot load the database");
                    }else{
                        System.out.println("Successfully loaded the database");
                    }
                }
                case 10 -> {
                    //save DB
                    System.out.println("----------------------Save Database----------------------\n");
                    myBool = c.saveDatabase(customerFileName,productFileName);
                    if (!myBool){
                        System.out.println("Sorry we cannot load the database");
                    }else{
                        System.out.println("Successfully loaded the database");
                    }
                }
            }
        }
    }

    // -------------------------
    // main
    // -------------------------
    /**
     * this is the main entry point of the application.<br>
     * @param args - any argument passed when calling the java application.
     */
    public static void main(String[] args){
       String customerFileName = "./myDBs/customers.txt";
       String productFileName = "./myDBs/products.txt";
       int maxOrderProducts = 5;

        interactiveMenu(customerFileName,productFileName,maxOrderProducts);
    }
}
