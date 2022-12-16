package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.ScoreBoard;
import lotto.domain.User;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static lotto.constants.Constants.*;

public class OutputView {
    public void printBoughtLotto(User user) {
        System.out.println();
        System.out.printf(PRINT_BOUGHT_LOTTO_PIECES, user.getLottoCount());
        for (Lotto lotto : user.getBoughtLotto()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printScore(ScoreBoard scoreBoard) {
        EnumMap<Prize, Integer> prizeMap = scoreBoard.getPrizeMap();
        List<String> prizeNames = new ArrayList<>(List.of("fifth", "fourth", "third", "second", "first"));

        System.out.println();
        System.out.println(PRIZE_AWARDS);

        for (String prizeName : prizeNames) {
            Prize now = Prize.valueOf(prizeName);
            System.out.printf(PRINT_NUMS_MATCHING, now.getMatchPoint());
            if (now.isBonusMatchPoint()) {
                System.out.print(PRINT_BONUS_MATCHING);
            }
            System.out.printf(PRINT_MATCHING_COUNT, now.getMoney(), prizeMap.getOrDefault(now, 0));
        }
        System.out.printf(PRINT_TOTAL_PROFIT, scoreBoard.getSum());
    }
}
