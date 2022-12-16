package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumberDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validateNumberDuplicates(List<Integer> numbers) {
        if(!numbers.stream().distinct().collect(Collectors.toList()).equals(numbers)){
            throw new IllegalArgumentException(LOTTO_NUM_DUPLICATE_ERROR);
        }
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUM_SIZE_ERROR);
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
