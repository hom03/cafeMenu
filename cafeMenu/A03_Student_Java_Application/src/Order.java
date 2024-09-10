//--------------------------------------------------
//
// CLASS Order
//
//--------------------------------------------------
/**
 * This class models an order from the coffee truck.<br>
 */
public class Order{
    //---------------------------------------
    //	Fields
    //---------------------------------------
    private final int customerID;
    private final int productID;
    //---------------------------------------
    //	Constructors
    //---------------------------------------
    /**
     * The constructor creates 1 instance (1 object) of the class Order<br>
     * @param customerID - The ID of the customer.
     * @param productID - The ID of the product.
     */
    public Order(int customerID,int productID){
        this.customerID = customerID;
        this.productID = productID;
    }
    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public int getCustomerID() {
        return customerID;
    }

    public int getProductID() {
        return productID;
    }
}
