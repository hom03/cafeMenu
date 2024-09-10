//--------------------------------------------------
//
// CLASS Business
//
//--------------------------------------------------

/**
 * This is the superclass in my project
 * representing all the business (Customers and Products)
 * for managing the coffee truck.<br>
 */
public class Business {
    //---------------------------------------
    //	Fields
    //---------------------------------------
    protected final int id;
    //---------------------------------------
    //	Constructor
    //---------------------------------------
    /**
     * This constructor returns one instance of the class Business.<br>
     */
    public Business(int id){
        this.id = id;
    }

    //---------------------------------------
    //	Getter
    //---------------------------------------

    //---------------------------------------
    //	getID
    //---------------------------------------
    /**
     * Given a concrete business (this), the function returns its id.<br>
     * We make the method final, to avoid the subclasses to override it.
     * @return The id of the agent.
     */
    public final int getID(){
        return this.id;
    }

    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------

    //---------------------------------------
    //	equals
    //---------------------------------------
    /**
     * Given a concrete agent (this), the function overrides the Object method equals.<br>
     * @param b - The other business we want to compare 'this' to.
     * @return - Whether 'this' and 'b' are equal.
     */
    public boolean equals(Business b) {
        return this.id == b.id;
    }
}
