// ---------------------------
// Imports
// ---------------------------
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

// ---------------------------
// CLASS CoffeeTruckImp
// ---------------------------
/**
 * This class implements the interface CoffeeTruck of the application,
 * representing the management of a coffee truck<br>.
 * We make the class final, to avoid any further class specialising it more.
 */
public final class CoffeeTruckImp implements CoffeeTruck {

    // ---------------------------
    // Fields
    // ---------------------------
    private final ArrayList<Customer> customerList;
    private final ArrayList<Product> productList;
    private final int maxOrderProducts;
    private static int nextID = 1;

    // ---------------------------
    // Constructor
    // ---------------------------
    /**
     * The constructor creates 1 instance (1 object) of the class CoffeeTruckImp<br>
     * @param maxOrderProducts - The maximum amount of orders a customer can make a day
     */
    CoffeeTruckImp(int maxOrderProducts){
        this.maxOrderProducts = maxOrderProducts;

        this.customerList = new ArrayList<Customer>();
        this.productList = new ArrayList<Product>();
    }

    //---------------------------------------
    //	addCustomer
    //---------------------------------------
    /**
     * This method adds a user to the coffee truck<br>
     * @param name - The name of the user.
     */
    public int addCustomer(String name){
        int res = CoffeeTruckImp.nextID;
        Customer newCust = new Customer(res,name,this.maxOrderProducts);
        this.customerList.add(newCust);
        CoffeeTruckImp.nextID++;
        return res;
    }
    //---------------------------------------
    //	removeCustomer
    //---------------------------------------
    /**
     * This method attempts to remove a customer from the coffee truck<br>
     * @param customerID - The id of the customer.
     */
    public int removeCustomer(int customerID){
        int res = -1;
        int index = Customer.isCustinCustList(customerID,this.customerList);
        if (index != -1){
            res = 0;
            this.customerList.remove(index);
        }return res;
    }

    // ---------------------------
    // Print Customer Info
    // ---------------------------
    /**
     * This is a method to print
     * and display customer information<br>
     * @param customerID - id belonging to the Customer
     */
    public void printCustInfo(int customerID){
        int index = Customer.isCustinCustList(customerID,this.customerList);
        if (index != -1){
            Customer myCustomer = this.customerList.get(index);
            String data = myCustomer.toString();
            System.out.println(data);
        }else{
            System.out.println("Sorry there is no customer with the ID"+ customerID+ ",so it cannot be displayed.");
        }
    }

    // ---------------------------
    // Display all Product IDs
    // ---------------------------
    /**
     * This is a method to print
     * and display all the product IDs<br>
     */
    public void displayAllProductIDs(){
        System.out.println("------------\nProduct IDs\n------------");
        for(Product drink : this.productList){
            System.out.println(drink.getID());
        }
    }

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
     * @param heat - boolean to indicate hot or iced coffee(1.hot/2.iced).
     * @return The id of the coffee created.
     */
    public int Coffee(String type, int numSugars, float price,boolean milk,int size,boolean heat){
        int res = CoffeeTruckImp.nextID;
        Coffee newCoffee = new Coffee(res,type,numSugars,price,milk,size,heat);
        this.productList.add(newCoffee);
        CoffeeTruckImp.nextID++;
        return res;
    }

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
     * @param flavour - the flavour that the tea has
     * @return The id of the tea created.
     */
    public int Tea(String type,int numSugars, float price,boolean milk,int size,String flavour){
        int res = CoffeeTruckImp.nextID;
        Tea newTea = new Tea(res,type,numSugars,price,milk,size,flavour);
        this.productList.add(newTea);
        CoffeeTruckImp.nextID++;
        return res;
    }

    // ---------------------------
    // Remove a product
    // ---------------------------
    /**
     * This is a method to remove a product
     * @param productID - id belonging to the Customer
     */
    public int removeProduct(int productID){
        int res = -1;
        int index = Product.isProductinProductList(productID,this.productList);
        if (index != -1){
            res = 0;
            this.productList.remove(index);
        }return res;
    }

    // ---------------------------
    // Make an Order
    // ---------------------------
    /**
     * @param customerID - id belonging to the Customer
     * @param productID - id belonging to the product
     * @return Order if order is successful
     */
    public Order makeOrder(int customerID, int productID){
        Order order = null;
        int index = Customer.isCustinCustList(customerID,this.customerList);
        if (index != -1){
            int index2 = Product.isProductinProductList(productID,this.productList);
            if (index2 != -1){
                order = new Order(customerID,productID);
                System.out.println("Order ready for collection: "+ productID + " for " + customerID);
            }else{
                System.out.println("Product not found.");
            }
        }else{
            System.out.println("Customer not found.");
        }
        return order;
    }

    // ---------------------------
    // Load the Database
    // ---------------------------
    /**
     * @param customerFileName - customers database text file
     * @param productFileName - products database text file
     */
    public boolean loadDatabase(String customerFileName,String productFileName){
        return((this.loadCustDatabase(customerFileName))&&(this.loadProductDatabase(productFileName)));
    }

    // ---------------------------
    // Load Customers from Database
    // ---------------------------
    /**
     * @param customerFileName - customers database text file
     */
    private boolean loadCustDatabase(String customerFileName){
        boolean res = false;
        try{
            File my_file = new File(customerFileName);
            Scanner scan = new Scanner(my_file);
            if (scan.hasNext()){
                int custSize = scan.nextInt();
            for (int custIndex = 0;custIndex < custSize;custIndex++){
                int customerID = scan.nextInt();
                String name = scan.next();
                int maxOrderProducts = scan.nextInt();
                Customer myCust = new Customer(customerID,name,maxOrderProducts);
                this.customerList.add(myCust);
                scan.close();
                res = true;
            }
            }
        }catch (Exception e ){
            System.out.println("Sorry but there is no such file.");
        }return res;
    }
    // ---------------------------
    // Load Products from Database
    // ---------------------------
    /**
     * @param productFileName - products database text file
     */
    private boolean loadProductDatabase(String productFileName) {
        boolean res = false;
        try {
            File my_file = new File(productFileName);
            Scanner scan = new Scanner(my_file);
            if (scan.hasNext()) {
                int productSize = scan.nextInt();
                for (int productIndex = 0; productIndex < productSize; productIndex++) {
                    int productID = scan.nextInt();
                    String type = scan.next();
                    int numSugars = scan.nextInt();
                    float price = scan.nextFloat();
                    boolean milk = scan.hasNextBoolean();
                    int size = scan.nextInt();
                    boolean heat;
                    String flavour;
                    Product myProduct;
                    if (scan.hasNextBoolean()){
                        heat = scan.hasNextBoolean();
                        myProduct = new Coffee(productID,type,numSugars,price,milk,size,heat);
                    }else{
                        flavour = scan.next();
                        myProduct = new Tea(productID,type,numSugars,price,milk,size,flavour);
                    }
                    this.productList.add(myProduct);
                    scan.close();
                    res = true;
                }
            }
        }
            catch(Exception e){
                System.out.println("Sorry but there is no such file.");
            }return res;
    }

    // ---------------------------
    // Save the Database
    // ---------------------------
    /**
     * @param customerFileName - customers database text file
     * @param productFileName - products database text file
     */
    public boolean saveDatabase(String customerFileName,String productFileName){
        boolean res = false;
        PrintWriter custWrite;
        PrintWriter productWrite;

        try{
            custWrite = new PrintWriter(customerFileName,StandardCharsets.UTF_8);
            productWrite = new PrintWriter(productFileName,StandardCharsets.UTF_8);
            int size = this.customerList.size();
            for (int index = 0;index < size;index++){
                Customer myCustomer = this.customerList.get(index);
                String custData = myCustomer.toString();
                custWrite.print(custData);
            }
            size = this.productList.size();
            for (int index = 0;index < size;index++){
                Product myProduct = this.productList.get(index);
                String productData = myProduct.toString();
                productWrite.print(productData);
            }
            custWrite.close();
            productWrite.close();
            res = true;
        }catch (Exception e){
            System.out.println("Cannot write to file.");
        }
        return res;
    }
}
