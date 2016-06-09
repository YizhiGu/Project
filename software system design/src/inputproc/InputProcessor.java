package inputproc;
//import data.AccountData;
import exception.AccountException;

import java.util.InputMismatchException;
import java.util.Scanner;
public abstract class InputProcessor {
	public abstract void handleInput();

    protected int getIntOperationInput(Scanner in, String msg) {
        return getIntInput(in, "Enter an integer " + msg);
    }

    protected int getIntInput(Scanner in, String msg) {
        int p = -1;
        if (msg != null) {
            println(msg);
        }
        try {
            p = in.nextInt();
        } catch (InputMismatchException e) {
            final String err = "Invalid data entered, Please reenter";
            println(err);
            throw new AccountException(err);
        }
        return p;
    }

    protected String getStringOperationInput(Scanner in, String msg) {
        return getStringInput(in, "Enter a string " + msg);
    }

    protected String getStringInput(Scanner in, String msg) {
        String p = null;
        println(msg);
        try {
            p = in.next();
        } catch (InputMismatchException e) {
            final String err = "Invalid data entered, Please reenter";
            println(err);
            throw new AccountException(err);
        }
        return p;
    }

    protected float getFloatOperationInput(Scanner in, String msg) {
        return getFloatInput(in, "Enter a float number " + msg);
    }

    protected float getFloatInput(Scanner in, String msg) {
        float p;
        println(msg);
        try {
            p = in.nextFloat();
        } catch (InputMismatchException e) {
            final String err = "Invalid data entered, Please reenter";
            println(err);
            throw new AccountException(err);
        }
        return p;
    }

    protected void println() {
        System.out.println();
    }

    protected void printOperation(String msg) {
        System.out.println("Operation : " + msg);
    }

    protected void println(String msg) {
        System.out.println(msg);
    }

    protected int printOperationGetIntInput(Scanner in, String operationMsg, String inputMsg) {
        printOperation(operationMsg);
        return getIntOperationInput(in, inputMsg);
    }

    protected float printOperationGetFloatInput(Scanner in, String operationMsg, String inputMsg) {
        printOperation(operationMsg);
        return getFloatOperationInput(in, inputMsg);
    }

    protected String printOperationGetStringInput(Scanner in, String operationMsg, String inputMsg) {
        printOperation(operationMsg);
        return getStringOperationInput(in, inputMsg);
    }

    protected boolean isNonEmpty(String p) {
        return p != null && !p.isEmpty();
    }

    protected boolean isValid(int p) {
        return p > 0;
    }
}
