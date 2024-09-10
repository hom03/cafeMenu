//--------------------------------------------------
//
// CLASS Tea
//
//--------------------------------------------------
/**
 * This class models a tea product of the coffee truck.<br>
 */
public class Tea extends Product{
    //---------------------------------------
    //	Fields
    //---------------------------------------
    private final String flavour;
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
     * @param flavour - the flavour that the tea has
     */
    public Tea(int id,String type,int numSugars,float price,boolean milk,int size,String flavour){
        super(id,type,numSugars,price,milk,size);
        this.flavour = flavour;
    }
    //---------------------------------------
    //	Get Methods
    //---------------------------------------
    public String getFlavour(){
        return this.flavour;
    }
    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------

    //---------------------------------------
    //	customiseProduct
    //---------------------------------------
    /**
     * This method is abstract and is being overridden in this child class.<br>
     */
    public void customiseProduct(){
        System.out.println("customising tea "+ getType() + "heat "+ getFlavour());
    }
}
