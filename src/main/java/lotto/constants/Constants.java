package lotto.constants;

public final class Constants {
    public static final String SCAN_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    public static final String SCAN_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String SCAN_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String PRIZE_AWARDS = "담청 통계 \n---";

    public static final int LOTTO_NUM_START = 1;
    public static final int LOTTO_NUM_END = 45;
    public static final int LOTTO_NUM_SIZE = 6;

    public static final String PRINT_BOUGHT_LOTTO_PIECES = "%d개를 구매했습니다.\n";
    public static final String PRINT_NUMS_MATCHING = "%d개 일치";
    public static final String PRINT_BONUS_MATCHING = ", 보너스 볼 일치";
    public static final String PRINT_MATCHING_COUNT = " (%,d원) - %d개\n";
    public static final String PRINT_TOTAL_PROFIT = "총 수익률은 %,.1f%%입니다.\n";


    public static final String MONEY_INPUT_ERROR = "[ERROR] 로또 구입가격은 1000원으로 나누어지는 양수여야 합니다.";
    public static final String LOTTO_NUM_SIZE_ERROR = "[ERROR] 로또의 숫자는 6개여야 합니다.";
    public static final String LOTTO_NUM_DUPLICATE_ERROR = "[ERROR] 로또의 숫자가 중복됩니다.";
    public static final String INPUT_ERROR = "[ERROR] 로또 번호는 1~45 사이의 6자리 숫자여야 합니다.";
    public static final String RANGE_NUM_ERROR = "[ERROR] 로또의 숫자는 1~45사이여야 합니다.";
}
