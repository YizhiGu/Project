package constant_enum;

public enum OpEnum {
	OPEN(0),
    LOGIN(1),
    PIN(2),
    DEPOSIT(3),
    WITHDRAW(4),
    BALANCE(5),
    LOGOUT(6),
    LOCK(7),
    UNLOCK(8),
    QUIT(9),
    SUSPEND(10),
    ACTIVATE(11),
    CLOSE(12);


    private int id;

    private OpEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static OpEnum value(int code) {
        final OpEnum[] enums = OpEnum.class.getEnumConstants();
        for (OpEnum operationEnum : enums) {
            if (operationEnum.id == code) {
                return operationEnum;
            }
        }
        return null;
    }
}
