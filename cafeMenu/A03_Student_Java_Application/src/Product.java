//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------
import java.util.ArrayList;

//--------------------------------------------------
//
// ABSTRACT CLASS Product
//
//--------------------------------------------------

/**
 *This class models a product of the coffee truck.<br>
 */
public abstract class Product extends Business{
    //---------------------------------------
    //	Fields
    //---------------------------------------
    private final String type;
    private final int numSugars;
    private final float price;
    private final boolean milk;
    private final int size;
    //---------------------------------------
    //	Constructors
    //---------------------------------------
    /**
     * The constructor creates 1 instance (1 object) of the class Product<br>
     * @param id - The ID of the product.
     * @param type - The type of product.
     * @param numSugars - how many sugars in the product.
     * @param price - price of product.
     * @param milk - milk in product or not.
     * @param size - size of product.
     */
    public Product(int id,String type,int numSugars,float price,boolean milk,int size){
        super(id);
        this.type = type;
        this.numSugars = numSugars;
        this.price = price;
        this.milk = milk;
        this.size = size;
    }
    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public String getType() {
        return type;
    }

    public int getNumSugars() {
        return numSugars;
    }

    public float getPrice() {
        return price;
    }
    public boolean getMilk(){
        return milk;
    }
    public int getSize(){
        return size;
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
    public String toString() {
        return id + "," + type + "," + numSugars + "," + price + "," + milk + "," + size +'\n';
    }
    //---------------------------------------
    //	customiseProduct
    //---------------------------------------
    /**
     * This method is abstract and will be overridden in the child classes.<br>
     */
    public abstract void customiseProduct();

    //---------------------------------------
    //	isProductinProductList
    //---------------------------------------
    /**
     * This method checks to see if the product is in the
     * product array list.<br>
     * @param id - id of the customer
     * @param productList - list of customers that is being searched
     */
    public static int isProductinProductList(int id,ArrayList<Product> productList) {
        int res = -1;
        Business baseLine = new Business(id);
        int size = productList.size();
        int index = 0;
        while((res ==-1) && (index < size)){
            if (baseLine.equals(productList.get(index))){
                res = index;
            }else{
                index++;
            }
        }return res;
    }
}
