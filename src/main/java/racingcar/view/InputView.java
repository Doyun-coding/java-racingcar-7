package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static String getCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);

        return Console.readLine();
    }

    public static int getNumberOfNames() {
        System.out.println(INPUT_ATTEMPT_MESSAGE);
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

}
