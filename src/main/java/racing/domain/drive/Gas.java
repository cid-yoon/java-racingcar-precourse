package racing.domain.drive;

public class Gas {

    public static final int MIN_GAUGE = 0;
    public static final int MAX_GAUGE = 100;
    public static final int CONSUME_AMOUNT = 1;

    private int amount;


    public Gas(int amount) {

        if (amount < MIN_GAUGE || amount >= MAX_GAUGE)
            throw new IllegalArgumentException();

        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        Gas gas = (Gas) o;
        return amount == gas.amount;
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }

    public Gas consume() {

        int remainAmount = this.amount - CONSUME_AMOUNT;
        if (remainAmount < MIN_GAUGE)
            throw new IllegalStateException();

        this.amount = remainAmount;
        return new Gas(this.amount);
    }

}
