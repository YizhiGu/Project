package constant_enum;

public enum StateEnum {
    IDLE(0),
    CHECK_PIN(1),
    READY(2),
    S1(3),
    OVERDRAWN(4),
    LOCKED(5),
    START(6),
    CLOSED(7),
    SUSPENDED(8);


    private int id;

    private StateEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static int getTotalStates() {
        return StateEnum.class.getEnumConstants().length;
    }
}
