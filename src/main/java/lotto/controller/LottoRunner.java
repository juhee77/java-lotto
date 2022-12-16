package lotto.controller;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.ScoreBoard;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.Constants.*;

public class LottoRunner {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {
        User user = makeUser();
        outputView.printBoughtLotto(user);
        WinningLotto winningLotto = makeWinningLotto();
        ScoreBoard scoreBoard = new ScoreBoard(user, winningLotto);
        scoreBoard.calculateScore();
        outputView.printScore(scoreBoard);
    }

    private WinningLotto makeWinningLotto() {
        List<Integer> lotto = inputView.readLotto();
        int bonusNumber = inputView.readBonusLotto();
        return new WinningLotto(lotto, bonusNumber);
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
            numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_NUM_START, LOTTO_NUM_END, LOTTO_NUM_SIZE));
            Collections.sort(numbers);
            lotto.add(new Lotto(numbers));
        }
        return lotto;
    }
}
