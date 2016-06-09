package inputproc.impl;
import constant_enum.OpEnum;
import data.Account1Data;
import inputproc.InputProcessor;
import mdaefsm.MdaEfsm;

import java.util.Scanner;


public class Account1InputProcessor extends InputProcessor {
	 /*Data specific to Account-1*/
    private Account1Data acctData;

    /*MDA-EFSM Class*/
    private MdaEfsm model;
    
    public Account1InputProcessor(Account1Data acctData, MdaEfsm model) {
        this.model = model;
        this.acctData = acctData;
    }

    @Override
    public void handleInput() {
        process();
    }

    /**
     * open an account where p is a pin, y is an user's id #,
     * and a is a balance
     *
     * @param p
     * @param y
     * @param a
     */
    public void open(String p, String y, float a) {
        if (isNonEmpty(p) && isNonEmpty(y) && a >= 0) {
            acctData.setPinInput(p);
            acctData.setUserIdInput(y);
            acctData.setBalanceInput(a);

            model.open();
        } else {
            println("Invalid Input");
        }
    }

    /**
     * provides pin #
     *
     * @param x
     */
    public void pin(String x) {
        String pin = acctData.getPin();
        int max = acctData.getMaxInvalidAttempts();

        if (x.equals(pin)) {
            //correct pin

          //  int minBalance = acctData.getMinBalance();
            float balance = acctData.getBalance();

            if (balance > 500) {
                model.correctPinAboveMin();
            } else {
                model.correctPinBelowMin();
            }
        } else {
            model.incorrectPin(max);
        }
    }

    /**
     * deposit amount d in the account
     *
     * @param d
     */
    public void deposit(float d) {
        if (d > 0) {
            acctData.setDeposit(d);

            //deposit the amount
            model.deposit();
            float balance = acctData.getBalance();
            if (balance>500)
                model.aboveMinBalance();
            else model.belowMinBalance();

        } else {
            println("Deposit Amount should be greater than 0");
        }
    }

    /**
     * Withdraw amount w from the account
     *
     * @param w
     */
    public void withdraw(float w) {
        if (w > 0) {
            acctData.setWithdraw(w);
            model.withdraw();

            //check for overdrawn condition
            float balance = acctData.getBalance();
            if (balance > 500) {
                model.aboveMinBalance();
            } else {
                model.belowMinBalanceWithPenalty();
            }
        } else {
            println("Withdraw Amount should be greater than 0");
        }
    }

    public void balance() {
        model.balance();
    }

    public void login(String y) {
        String userId = acctData.getUserId();
        if (y.equals(userId)) {
            //correct login
            model.login();
        } else {
            //incorrect login
            model.invalidLogin();
        }
    }

    public void logout() {
        model.logout();
    }

    public void lock(String x) {
        String pin = acctData.getPin();

        //correct pin
        if (x.equals(pin)) {
            model.lock();
        } else {
            model.incorrectLock();
        }
    }

    public void unlock(String x) {
        String pin = acctData.getPin();

        //correct pin
        if (x.equals(pin) ) {
            model.unlock();
            checkMinBalance();

        } else {
            model.incorrectUnlock();
        }
    }

    private void checkMinBalance() {
        //Check balance status wrt Min balance
        float balance = acctData.getBalance();
        float minBalance = 500;
        if (balance > minBalance) {
            model.aboveMinBalance();
        } else {
            model.belowMinBalance();
        }
    }

    public void process() {

        boolean flag = true;
        OpEnum opcode = null;

        //Create the user interface
        displayOperations();

        while (flag) {
            Scanner in = new Scanner(System.in);
            println();
            println("Select Operation:");
            println("0 - open ,1- login ,2 - pin ,3 - deposit ,4 - withdraw," +
                    "5 - balance, 6 - logout,7 - lock, 8 - unlock, 9 - quit");

            try {
                int option = getIntInput(in, null);
                opcode = OpEnum.value(option);

                switch (opcode) {
                    case OPEN:
                        String p = printOperationGetStringInput(in, "open(p,y,a)", "p(pin)):");
                        String y = getStringOperationInput(in, "y(user id):");
                        float a = getFloatOperationInput(in, "a(balance):");

                        open(p, y, a);
                        break;

                    case LOGIN:
                        String userId = printOperationGetStringInput(in, "login(String y)", "y(userid):");
                        login(userId);
                        break;

                    case PIN:
                        String pin = printOperationGetStringInput(in, "pin(String x)", "x(pin):");
                        pin(pin);
                        break;

                    case LOCK:
                        String pin1 = printOperationGetStringInput(in, "lock(String x)", "x(pin):");
                        lock(pin1);
                        break;

                    case UNLOCK:
                        String pin2 = printOperationGetStringInput(in, "unlock(String x)", "x(pin):");
                        unlock(pin2);
                        break;

                    case BALANCE:
                        printOperation("balance()");
                        balance();
                        break;

                    case DEPOSIT:
                        float d = printOperationGetFloatInput(in, "deposit(Float d)", "d(Deposit amount):");
                        deposit(d);
                        break;

                    case WITHDRAW:
                        float withdraw = printOperationGetFloatInput(in, "withdraw(Float w)", "w(Withdraw amount):");
                        withdraw(withdraw);
                        break;

                    case LOGOUT:
                        logout();
                        break;

                    case QUIT:
                        flag = false;
                        break;

                    default:
                        println("Invalid option");
                        break;
                }
                println();
            } catch (Exception e) {
                            }
        }
        println("Exiting Account - 1. Thank You");
    }

    public void displayOperations() {
        println();
        println(" ACCOUNT-1");
        println(" MENU of Operations");
        println("0. open(String,String,Float)");
        println("1. login(String)");
        println("2. pin(String)");
        println("3. deposit(Float)");
        println("4. withdraw(Float)");
        println("5. balance()");
        println("6. logout()");
        println("7. lock(int)");
        println("8. unlock(String)");
        println("9. Exit Account -1");
    }
}
