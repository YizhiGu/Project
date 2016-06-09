package data;

public abstract class AccountData {

	    /*maximum invalid pin attempts*/
	    protected int maxInvalidAttempts;

	    /*Penalty if account is overdrawn*/
	    protected int penalty;

	    /*Locked Status*/
	    protected boolean locked;

	    public AccountData() {
	    }

	    public int getMaxInvalidAttempts() {
	        return maxInvalidAttempts;
	    }

	    public int getPenalty() {
	        return penalty;
	    }
}
