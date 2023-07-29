package lotto.domain;

import java.util.Arrays;

public enum Prize {
    first(6, false, 2_000_000_000),
    second(5, true, 30_000_000),
    third(5, false, 1_500_000),
    fourth(4, false, 50_000),
    fifth(3, false, 5_000),
    etc(0, false, 0);


    private final int matchPoint;
    private final boolean bonusMatchPoint;
    private final int money;

    Prize(int matchPoint, boolean bonusMatchPoint, int money) {
        this.matchPoint = matchPoint;
        this.bonusMatchPoint = bonusMatchPoint;
        this.money = money;
    }

    public static Prize findPrize(int matchPoint, boolean bonusMatchPoint) {
        return Arrays.stream(values())
                .filter(Prize -> Prize.matchPoint == matchPoint)
                .filter(Prize -> Prize.bonusMatchPoint == bonusMatchPoint)
                .findAny()
                .orElse(etc);
    }

    public int getMatchPoint() {
        return matchPoint;
    }

    public boolean isBonusMatchPoint() {
        return bonusMatchPoint;
    }

    public int getMoney() {
        return money;
    }
}
