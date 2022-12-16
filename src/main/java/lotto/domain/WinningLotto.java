package lotto.domain;

import java.util.List;

import static lotto.constants.Constants.*;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateNumberDuplicates(bonusNumber);
        validateNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateNumberDuplicates(int bonusNumber) {
        if (this.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUM_DUPLICATE_ERROR);
        }
    }

    private void validateNumberRange(int bonusNumber) {
        if (bonusNumber < LOTTO_NUM_START || LOTTO_NUM_END < bonusNumber) {
            throw new IllegalArgumentException(RANGE_NUM_ERROR);

        }
    }

}
