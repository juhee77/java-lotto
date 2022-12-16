package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constants.Constants.MONEY_INPUT_ERROR;
import static lotto.constants.Constants.SCAN_PURCHASE_MONEY;

public class InputView {
    public static final int MIN_PURCHASE_MONEY = 0;
    public static final int LOTTO_PRICE = 1000;

    public int readLottoPieces() {
        System.out.println(SCAN_PURCHASE_MONEY);
        String purchaseMoney = Console.readLine();
        return validateMoney(purchaseMoney);
    }

    public int validateMoney(String purchaseMoney) {
        try {
            int purchasedMoney = Integer.parseInt(purchaseMoney);
            return validateMoneyRange(purchasedMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MONEY_INPUT_ERROR);
        }
    }

    public int validateMoneyRange(int purchasedMoney) {
        if (purchasedMoney <= MIN_PURCHASE_MONEY || (purchasedMoney % LOTTO_PRICE != 0)) {
            throw new IllegalArgumentException(MONEY_INPUT_ERROR);
        }
        return purchasedMoney / LOTTO_PRICE;
    }
}
