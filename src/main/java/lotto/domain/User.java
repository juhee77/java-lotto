package lotto.domain;

import lotto.domain.Lotto;

import java.util.List;

public class User {
    private int lottoCount;
    private List<Lotto> boughtLotto;

    public User(int lottoCount, List<Lotto> boughtLotto) {
        this.lottoCount = lottoCount;
        this.boughtLotto = boughtLotto;
    }
}
