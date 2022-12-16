package lotto.controller;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.Constants.*;

public class LottoRunner {
    private static final InputView inputView = new InputView();

    public void run() {
        User user = makeUser();
    }

    private User makeUser() {
        int wantPieces = inputView.readLottoPieces();
        List<Lotto> lottos = issuedLotto(wantPieces);
        return new User(wantPieces, lottos);
    }

    public List<Lotto> issuedLotto(int wantPieces) {
        List<Lotto> lotto = new ArrayList<>();
        List<Integer> numbers;
        while (wantPieces-- > 0) {
            numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_NUM_START, LOTTO_NUM_END,LOTTO_NUM_SIZE));
            Collections.sort(numbers);
            lotto.add(new Lotto(numbers));
        }
        return lotto;
    }
}