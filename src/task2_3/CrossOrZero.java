package task2_3;

public enum CrossOrZero {
    DASH(0, "-"), O(1, "0"), X(2, "X"), NAN(3, "N");
    private int value;
    private String name;
    CrossOrZero(int value, String name){
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
