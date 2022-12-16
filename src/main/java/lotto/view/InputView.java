package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.Constants.*;

public class InputView {
    public static final int MIN_PURCHASE_MONEY = 0;
    public static final int LOTTO_PRICE = 1000;

    public int readLottoPieces() {
        System.out.println(SCAN_PURCHASE_MONEY);
        String purchaseMoney = Console.readLine();
        return validateMoney(purchaseMoney);
    }

    public List<Integer> readLotto() {
        System.out.println();
        System.out.println(SCAN_LOTTO_NUMBER);
        String LottoNums = Console.readLine();
        validateLottoSize(LottoNums);
        return StringToInteger(LottoNums.split(","));
    }

    private List<Integer> StringToInteger(String[] lottoNums) {
        List<Integer> nums = new ArrayList<>();
        try {
            for (String eachNum : lottoNums) {
                nums.add(Integer.valueOf(eachNum));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
        return nums;
    }

    private void validateLottoSize(String lottoNums) {
        if (lottoNums.split(",").length != LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
    }

    public int readBonusLotto() {
        System.out.println();
        System.out.println(SCAN_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        return validateBonusNum(bonusNumber);
    }

    private int validateBonusNum(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MONEY_INPUT_ERROR);
        }
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
