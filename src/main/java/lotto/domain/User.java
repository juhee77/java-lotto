package lotto.domain;

import java.util.List;

public class User {
    private int lottoCount;
    private List<Lotto> boughtLotto;

    public User(int lottoCount, List<Lotto> boughtLotto) {
        this.lottoCount = lottoCount;
        this.boughtLotto = boughtLotto;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getBoughtLotto() {
        return boughtLotto;
    }
}
