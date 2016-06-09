package constant_enum;

public enum AccountEnum {
	ACCOUNT_1(1),
    ACCOUNT_2(2);

    private int id;

    private AccountEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
