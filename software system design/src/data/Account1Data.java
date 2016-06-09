package data;

public class Account1Data extends AccountData {

    /* pin for the account*/
    private String pin;

    /*user's ID */
    private String userId;

    /*balance in the account float type for account 1 */
    private float balance;

    /*Input deposit amount float type for account 1*/
    private float deposit;

    /*Input withdraw amount float type for account 1*/
    private float withdraw;

    /* Input pin for the account string type for account 1*/
    private String pinInput;

    /*Input User Id string type for account 1 */
    private String userIdInput;

    /*Input balance in the account float type for account 1 */
    private float balanceInput;
    
    /* Set the maxInvalidAttempts and penalty*/
    public Account1Data() {
        super();
        maxInvalidAttempts = 3;
        penalty = 20;
    }

    public String getPinInput() {
        return pinInput;
    }

    public void setPinInput(String pinInput) {
        this.pinInput = pinInput;
    }

    public String getUserIdInput() {
        return userIdInput;
    }

    public void setUserIdInput(String userIdInput) {
        this.userIdInput = userIdInput;
    }

    public float getBalanceInput() {
        return balanceInput;
    }

    public void setBalanceInput(float balanceInput) {
        this.balanceInput = balanceInput;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public float getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(float withdraw) {
        this.withdraw = withdraw;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
