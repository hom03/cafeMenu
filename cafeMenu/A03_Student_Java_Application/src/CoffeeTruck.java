// ---------------------------
// INTERFACE CoffeeTruck
// ---------------------------
/** This is the main interface for the application,
 * representing the management of a coffee truck<br>.
 */
public interface CoffeeTruck {
    // ---------------------------
    // Add Customer
    // ---------------------------
    /**
     * This is a variable to add a customer
     * @param name - name of the customer
     */
    int addCustomer(String name);

    // ---------------------------
    // Remove Customer
    // ---------------------------
    /**
     * This is a method to remove a customer<br>
     * @param customerID - id belonging to the Customer
     */
    int removeCustomer(int customerID);

    // ---------------------------
    // Print Customer Info
    // ---------------------------
    /**
     * This is a method to print
     * and display customer information<br>
     * @param customerID - id belonging to the Customer
     */
    void printCustInfo(int customerID);

    // ---------------------------
    // Display all Product IDs
    // ---------------------------
    /**
     * This is a method to print
     * and display all the product IDs<br>
     */
    void displayAllProductIDs();

    // ---------------------------
    // Add a Coffee Related Product
    // ---------------------------
    /**
     * This is a method to create
     * a coffee related product<br>
     * @param type- the type of coffee
     * @param numSugars - the desired amount of sugar spoons in the coffee
     * @param price - the price of the coffee
     * @param milk - boolean to indicate does the user want milk in their coffee or not
     * @param size - integer to indicate small, medium or large sized cup
     * @param heat - boolean to see if coffee will be hot or iced
     * @return The id of the coffee created.
     */
    int Coffee(String type, int numSugars, float price,boolean milk,int size,boolean heat);

    // ---------------------------
    // Add a Tea Related Product
    // ---------------------------
    /**
     * This is a method to create
     * a tea related product<br>
     * @param type- the type of tea
     * @param numSugars - the desired amount of sugar spoons in the tea
     * @param price - the price of the tea
     * @param milk - boolean to indicate does the user want milk in their tea or not
     * @param size - integer to indicate small, medium or large sized cup(1,2,3)
     * @param flavour - string if a specific flavour is wanted
     * @return The id of the tea created.
     */
    int Tea(String type, int numSugars, float price,boolean milk,int size,String flavour);

    // ---------------------------
    // Remove a product
    // ---------------------------
    /**
     * This is a method to remove a product
     * @param customerID - id belonging to the Customer
     */
    int removeProduct(int customerID);

    // ---------------------------
    // Make an Order
    // ---------------------------
    /**
     * @param customerID - id belonging to the Customer
     * @param productID - id belonging to the product
     */
    Order makeOrder(int customerID, int productID);

    // ---------------------------
    // Load the Database
    // ---------------------------
    /**
     * @param customerFileName - customers database text file
     * @param productFileName - products database text file
     */
    boolean loadDatabase(String customerFileName,String productFileName);

    // ---------------------------
    // Save the Database
    // ---------------------------
    /**
     * @param customerFileName - customers database text file
     * @param productFileName - products database text file
     */
    boolean saveDatabase(String customerFileName,String productFileName);
}
