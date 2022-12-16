package lotto.domain;

import java.util.EnumMap;
import java.util.List;

import static lotto.view.InputView.LOTTO_PRICE;

public class ScoreBoard {
    private User user;
    private WinningLotto winningLotto;
    private EnumMap<Prize, Integer> prizeMap = new EnumMap<>(Prize.class);
    private double sum = 0;

    public ScoreBoard(User user, WinningLotto winningLotto) {
        this.user = user;
        this.winningLotto = winningLotto;
    }

    public void calculateScore() {
        for (Lotto lotto : user.getBoughtLotto()) {
            int matchPoint = countMatchPoint(lotto.getNumbers(), winningLotto.getNumbers());
            boolean bonusMatchPoint = countBonusMatchPoint(lotto.getNumbers(), winningLotto.getBonusNumber());
            Prize prize = Prize.findPrize(matchPoint, bonusMatchPoint);
            sum += prize.getMoney();
            prizeMap.put(prize, prizeMap.getOrDefault(prize, 0) + 1);
        }
        sum /= user.getLottoCount() * LOTTO_PRICE;
        sum *= 100;
    }

    private boolean countBonusMatchPoint(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private int countMatchPoint(List<Integer> numbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int num : winningNumbers) {
            if (numbers.contains(num)) {
                count++;
            }
        }
        return count;
    }

    public EnumMap<Prize, Integer> getPrizeMap() {
        return prizeMap;
    }

    public double getSum() {
        return sum;
    }
}
