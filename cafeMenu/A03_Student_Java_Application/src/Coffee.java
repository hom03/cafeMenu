//--------------------------------------------------
//
// CLASS Coffee
//
//--------------------------------------------------
/**
 * This class models a coffee product of the coffee truck.<br>
 */
public class Coffee extends Product{
    //---------------------------------------
    //	Fields
    //---------------------------------------
    private final boolean heat;
    //---------------------------------------
    //	Constructors
    //---------------------------------------
    /**
     * The constructor creates 1 instance (1 object) of the class Coffee<br>
     * @param id - The ID of the product.
     * @param type - The type of product.
     * @param numSugars - how many sugars in the product.
     * @param price - price of product.
     * @param milk - milk in product or not.
     * @param size - size of product.
     * @param heat - boolean to indicate hot or iced coffee(1.hot/2.iced).
     */
    public Coffee(int id,String type,int numSugars,float price,boolean milk,int size,boolean heat){
        super(id,type,numSugars,price,milk,size);
        this.heat = heat;
    }

    //---------------------------------------
    //	Get Method
    //---------------------------------------

    public boolean getHeat() {
        return heat;
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
        System.out.println("customising coffee "+ getType() + "heat "+ getHeat());
    }
}
