package interfaces;

import data.Cart;
import data.Order;
import services.Client;
import estorePojo.exceptions.InsufficientBalanceException;
import estorePojo.exceptions.InvalidCartException;
import estorePojo.exceptions.UnknownAccountException;
import estorePojo.exceptions.UnknownItemException;

public interface IStore {

    /**
     * Get the price of an item.
     *
     * @param item the item
     * @return the price of the item
     * @throws UnknownItemException if the item is unknown
     */
    double getPrice(Object item) throws UnknownItemException;

    /**
     * Check if an item is available in the given quantity.
     *
     * @param item the item
     * @param qty  the quantity
     * @return true if the item is available in the given quantity
     * @throws UnknownItemException if the item is unknown
     */
    boolean isAvailable(Object item, int qty) throws UnknownItemException;

    /**
     * Add an item to a cart. If the cart does not exist yet, create a new one.
     *
     * @param cart   a previously created cart or null
     * @param client the client
     * @param item   the item to add
     * @param qty    the quantity to add
     * @return the cart (new or updated)
     * @throws UnknownItemException if the item is unknown
     * @throws InvalidCartException if the cart does not belong to the client
     */
    Cart addItemToCart(Cart cart, Client client, Object item, int qty)
            throws UnknownItemException, InvalidCartException;

    /**
     * Pay for the items in the cart and create an order.
     *
     * @param cart           the cart containing the items
     * @param address        the delivery address
     * @param bankAccountRef the bank account reference for payment
     * @return the order
     * @throws InvalidCartException       if the cart is invalid
     * @throws UnknownItemException       if an item is unknown
     * @throws InsufficientBalanceException if the account has insufficient balance
     * @throws UnknownAccountException    if the account is unknown
     */
    Order pay(Cart cart, String address, String bankAccountRef)
            throws InvalidCartException, UnknownItemException,
            InsufficientBalanceException, UnknownAccountException;

    /**
     * Order an item directly (one-shot order).
     *
     * @param client         the client
     * @param item           the item to order
     * @param qty            the quantity
     * @param address        the delivery address
     * @param bankAccountRef the bank account reference for payment
     * @return the order
     * @throws UnknownItemException       if the item is unknown
     * @throws InsufficientBalanceException if the account has insufficient balance
     * @throws UnknownAccountException    if the account is unknown
     */
    Order oneShotOrder(Client client, Object item, int qty, String address, String bankAccountRef)
            throws UnknownItemException, InsufficientBalanceException, UnknownAccountException;

}
