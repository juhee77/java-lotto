package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.User;

import static lotto.constants.Constants.PRINT_BOUGHT_LOTTO_PIECES;

public class OutputView {
    public void printBoughtLotto(User user) {
        System.out.println();
        System.out.printf(PRINT_BOUGHT_LOTTO_PIECES, user.getLottoCount());
        for (Lotto lotto : user.getBoughtLotto()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
