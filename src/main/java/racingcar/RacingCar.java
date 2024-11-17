package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCar {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public void run() {
        String[] carNames = inputCarName();
        int numberOfAttempts = inputNumberOfAttempts();

        Map<String, Integer> cars = createCar(carNames);

        for(int i = 0; i < numberOfAttempts; i++) {
            playRound(cars);

            showRaceProgress(cars);
        }

        List<String> winners = findWinner(cars);
    }

    public List<String> findWinner(Map<String, Integer> cars) {
        List<Map.Entry<String, Integer>> carList = new ArrayList<>(cars.entrySet());
        carList.sort(((o1, o2) -> cars.get(o2.getValue()) - cars.get(o1.getValue())));

        List<String> winners = new ArrayList<>();
        Integer maxValue = carList.get(0).getValue();

        for(Map.Entry<String, Integer> car : carList) {
            if(car.getValue() != maxValue) {
                break;
            }
            winners.add(car.getKey());
        }

        return winners;
    }

    private void showRaceProgress(Map<String, Integer> cars) {
        System.out.println();
        System.out.println("실행 결과");

        for(Map.Entry<String, Integer> car : cars.entrySet()) {
            System.out.print(car.getKey() + " : " );

            for(int j = 0; j < car.getValue(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }

    }

    private boolean canMove() {
        int number = Randoms.pickNumberInRange(0, 9);

        return number >= 4;
    }

    private void playRound(Map<String, Integer> cars) {
        for(Map.Entry<String, Integer> car : cars.entrySet()) {
            if(canMove()) {
                cars.put(car.getKey(), car.getValue() + 1);
            }
        }
    }

    public Map<String, Integer> createCar(String[] carNames) { // 자동차의 이동 횟수를 저장할 MAP 구현
        Map<String, Integer> cars = new HashMap<>();

        for(String name : carNames) {
            cars.put(name, 0);
        }

        return cars;
    }

    private String[] inputCarName() { // 경주할 자동차 이름 입력 받는 함수
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String input = Console.readLine();

        return input.split(",");
    }

    private int inputNumberOfAttempts() { // 시도 횟수 입력 받는 함수
        System.out.println(INPUT_ATTEMPT_MESSAGE);
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

}
