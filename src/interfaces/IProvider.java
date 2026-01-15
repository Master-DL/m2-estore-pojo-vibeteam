package interfaces;

import estorePojo.exceptions.UnknownItemException;

public interface IProvider {

    /**
     * Get the price of an item provided by this provider.
     *
     * @param item the item
     * @return the price of the item
     * @throws UnknownItemException if the item is unknown
     */
    double getPrice(Object item) throws UnknownItemException;

    /**
     * Emit an order for items. The provider returns the delay for delivering the items.
     *
     * @param store the store that emits the order
     * @param item  the item ordered
     * @param qty   the quantity ordered
     * @return the delay (in hours)
     * @throws UnknownItemException if the item is unknown
     */
    int order(IStore store, Object item, int qty) throws UnknownItemException;

}
