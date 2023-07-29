package lotto;

import lotto.controller.LottoRunner;

public class Application {
    public static void main(String[] args) {
        try{
            LottoRunner lottoRunner = new LottoRunner();
            lottoRunner.run();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
