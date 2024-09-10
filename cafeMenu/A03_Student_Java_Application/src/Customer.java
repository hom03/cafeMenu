//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------
import java.util.ArrayList;
//--------------------------------------------------
//
// CLASS Customer
//
//--------------------------------------------------
/**
 * This class models a customer of the coffee truck.<br>
 */
public class Customer extends Business{
    //---------------------------------------
    //	Fields
    //---------------------------------------
    private final String name;
    private final int maxOrders;
    private final ArrayList<Order> orders;
    //---------------------------------------
    //	Constructors
    //---------------------------------------
    /**
     * The default constructor creates 1 instance of the class Customer<br>
     */
    public Customer(){
        super(0);
        this.name = "";
        this.maxOrders = 0;
        this.orders = new ArrayList<>();
    }
    /**
     * The copy constructor creates 1 instance (1 object) of the class Customer<br>
     * @param id - The ID of the customer.
     * @param name - The name of the customer.
     * @param maxOrders- The maximum orders a customer can make.
     */
    public Customer(int id,String name, int maxOrders){
        super(id);
        this.name = name;
        this.maxOrders = maxOrders;
        this.orders = new ArrayList<Order>();
    }
    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public String getName() {
        return this.name;
    }

    public int getMaxOrders() {
        return this.maxOrders;
    }
    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------

    //---------------------------------------
    //	toString
    //---------------------------------------
    /**
     * toString to write data to file
     */
    public String toString(){
        return id + "," + name +'\n';
    }
    //---------------------------------------
    //	Add Order
    //---------------------------------------
    public void addOrder(Order order){
        this.orders.add(order);
    }
    //---------------------------------------
    //	isCustinCustList
    //---------------------------------------
    /**
     * This method checks to see if the customer is in the
     * customer array list.<br>
     * @param id - id of the customer
     * @param custList - list of customers that is being searched
     */
    public static int isCustinCustList(int id,ArrayList<Customer> custList) {
        int res = -1;
        Business baseLine = new Business(id);
        int size = custList.size();
        int index = 0;
        while((res ==-1) && (index < size)){
            if (baseLine.equals(custList.get(index))){
                res = index;
            }else{
                index++;
            }
        }return res;
    }
}
