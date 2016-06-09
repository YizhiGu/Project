package inputproc.impl;
import constant_enum.OpEnum;
import data.Account2Data;
import inputproc.InputProcessor;
import mdaefsm.MdaEfsm;

import java.util.Scanner;


public class Account2InputProcessor extends InputProcessor {
    /*Data specific to Account-2*/
    private Account2Data acctData;

    /*MDA-EFSM Class*/
    private MdaEfsm model;

    public Account2InputProcessor(Account2Data acctData, MdaEfsm model) {
        this.model = model;
        this.acctData = acctData;
    }

    @Override
    public void handleInput() {
        process();
    }

    /**
     * open an account where p is a pin, y is an user's identification #,
     * and a is a balance
     *
     * @param p
     * @param y
     * @param a
     */
    public void OPEN(int p, int y, int a) {
        if (isValid(p) && isValid(y) && isValid(a)) {
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
    public void PIN(int x) {
        int pin = acctData.getPin();
        int max = acctData.getMaxInvalidAttempts();

        if (isValid(x) && x == pin) {
            model.correctPinAboveMin();
        } else {
            model.incorrectPin(max);
        }
    }

    /**
     * deposit amount d in the account
     *
     * @param d
     */
    public void DEPOSIT(int d) {
        if (d > 0) {
            acctData.setDeposit(d);

            //deposit the amount
            model.deposit();
        } else {
            println("Deposit Amount should be greater than 0");
        }
    }

    /**
     * Withdraw amount w from the account
     *
     * @param w
     */
    public void WITHDRAW(int w) {
        if (w > 0) {
            int balance = acctData.getBalance();
            if (balance > 0) {
                acctData.setWithdraw(w);
                model.withdraw();
                model.aboveMinBalance();
            }
            else {model.nofunds();}
        } 
        else {
            println("Withdraw Amount should be greater than 0");
        }

    }

    public void BALANCE() {
        model.balance();
    }

    public void LOGIN(int y) {
        int userId = acctData.getUserId();
        if (isValid(y) && y == userId) {
            //correct login
            model.login();
        } else {
            //incorrect login
            model.invalidLogin();
        }

    }

    public void LOGOUT() {
        model.logout();
    }


    public void SUSPEND() { model.suspend(); }

    public void ACTIVATE() { model.activate();}

    public void CLOSED() { model.close(); }

    private void checkMinBalance() {
        //Check balance status wrt Min balance
        int balance = acctData.getBalance();
        int minBalance = 0;
        if (balance > minBalance) {
            model.aboveMinBalance();
        } else {
            model.belowMinBalance();
        }
    }
    public void process() {

        boolean flag = true;
        OpEnum opcode;

        //Display Menu
        displayOperations();

        while (flag) {
            Scanner in = new Scanner(System.in);
            println();
            println("Select Operation:");
            println("0 - OPEN, 1- LOGIN, 2 - PIN, 3 - DEPOSIT, 4 - WITHDRAW," +
                    " 5 - BALANCE, 6 - LOGOUT, 9 - QUIT, 10 - SUSPEND, " +
                    "11 - ACTIVATE, 12 - CLOSE, ");

            try {
                int option = getIntInput(in, null);
                opcode = OpEnum.value(option);

                switch (opcode) {
                    case OPEN:
                        int p = printOperationGetIntInput(in, "open(p,y,a)", "p(pin)):");
                        int y = getIntOperationInput(in, "y(userid):");
                        int a = getIntOperationInput(in, "a(balance):");

                        OPEN(p, y, a);
                        break;

                    case LOGIN:
                        int userId = printOperationGetIntInput(in, "login(int y)", "y(userid):");
                        LOGIN(userId);
                        break;

                    case PIN:
                        int pin = printOperationGetIntInput(in, "pin(int x)", "x(pin):");

                        PIN(pin);
                        break;

                    case DEPOSIT:
                        int d = printOperationGetIntInput(in, "deposit(int d)", "d(Deposit amount):");

                        DEPOSIT(d);
                        break;

                    case WITHDRAW:
                        int withdraw = printOperationGetIntInput(in, "withdraw(int w)", "w(Withdraw amount):");

                        WITHDRAW(withdraw);
                        break;

                    case BALANCE:
                        printOperation("balance()");
                        BALANCE();
                        break;

                    case LOGOUT:
                        LOGOUT();
                        break;

                    case SUSPEND:
                        SUSPEND();
                        break;

                    case ACTIVATE:
                        ACTIVATE();
                        break;

                    case CLOSE:
                        CLOSED();
                        flag = false;
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
                //ignore the exception.
            }
        }
        println("Exiting Account - 2. Thank You");
    }

    public void displayOperations() {
        println();
        println(" ACCOUNT-2\n" + " MENU of Operations\n" +
                "0. OPEN(int,int,int)\n" + "1. LOGIN(int)\n" + "2. PIN(int)\n" +
                "3. DEPOSIT(int)\n" + "4. WITHDRAW(int)\n" + "5. BALANCE()\n" +
                "6. LOGOUT()\n" + "7. SUSPEND()\n" + "8. ACTIVATE()\n" +
                "9. CLOSE()\n" + "10. QUIT()");

    }     
}
