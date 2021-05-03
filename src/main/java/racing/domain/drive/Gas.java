package racing.domain.drive;

/**
 * 자동차의 연료
 * 이동 횟수(turn)을 연료로 추상화
 */
public class Gas {

    public static final int MIN_GAUGE = 0;  // 최소 수치
    public static final int MAX_GAUGE = 100; // 임의의 최대 수치
    public static final int CONSUME_AMOUNT = 1; // 소비량

    // 수량
    private final int amount;

    public Gas(final int amount) {

        if (amount < MIN_GAUGE || amount >= MAX_GAUGE)
            throw new IllegalArgumentException();

        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        Gas gas = (Gas) o;
        return amount == gas.amount;
    }


    /**
     * 연료 소비 메시지를 처리
     *
     * @return 잔여 가스량 반환
     */
    public Gas consume() {

        int remainAmount = this.amount - CONSUME_AMOUNT;
        if (remainAmount < MIN_GAUGE)
            throw new IllegalStateException();


        return new Gas(remainAmount);
    }

    /**
     * 잔여량이 존재하는지 판단
     */
    public boolean has() {
        return this.amount > MIN_GAUGE;
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }
}
