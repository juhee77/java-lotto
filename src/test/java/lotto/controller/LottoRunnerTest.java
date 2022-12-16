package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRunnerTest {
    private static final LottoRunner lottoRunner = new LottoRunner();

    @Test
    @DisplayName("로또의 개수가 맞게 발행되는지 확인한다.")
    void issuedLotto() {
        assertThat(lottoRunner.issuedLotto(10).size()).isEqualTo(10);
    }
}