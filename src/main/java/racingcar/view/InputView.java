package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static String getCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String input = Console.readLine();
        validateNotBlank(input);

        return input.trim();
    }

    public static int getNumberOfAttempts() {
        System.out.println(INPUT_ATTEMPT_MESSAGE);
        String input = Console.readLine();
        validateNotBlank(input);
        validateInteger(input);

        return Integer.parseInt(input);
    }

    private static void validateNotBlank(String input) {
        if(input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 비어 있지 않아야 합니다.");
        }
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 정수여야 합니다.");
        }
    }

}
