package interfaces;

import estorePojo.exceptions.InsufficientBalanceException;
import estorePojo.exceptions.UnknownAccountException;

public interface IBank {

    /**
     * Transfer money from one account to another.
     *
     * @param from   the account to withdraw from
     * @param to     the account to credit
     * @param amount the amount to transfer
     * @throws InsufficientBalanceException if the source account has insufficient balance
     * @throws UnknownAccountException if one of the accounts is unknown
     */
    void transfert(String from, String to, double amount)
            throws InsufficientBalanceException, UnknownAccountException;

}
