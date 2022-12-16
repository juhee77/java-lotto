package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private static InputView inputView = new InputView();

    @DisplayName("입력된 금액이 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "12d", "asd"})
    void validateMoney(String money) {
        assertThatThrownBy(() -> {
            inputView.validateMoney(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("금액으 0원 이하이거나 1000원으로 나누어 지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1234, 12345})
    void validateMoneyRange(int money) {
        assertThatThrownBy(() -> {
            inputView.validateMoneyRange(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("티켓의 장수는 금액/1000 이여야 한다.")
    @Test
    void checkTicketPieces() {
        assertThat(inputView.validateMoneyRange(10000)).isEqualTo(10);
    }
}