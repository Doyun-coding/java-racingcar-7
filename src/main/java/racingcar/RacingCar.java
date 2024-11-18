package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Cars;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCar {

    public void run() {

        String carNames = InputView.getCarNames();
        Cars cars = new Cars(carNames);

        int numberOfAttempts = InputView.getNumberOfAttempts();
/*
        for(int i = 0; i < numberOfAttempts; i++) {
            playRound(cars);

            showRaceProgress(cars);
        }

        List<String> winners = findWinner(cars);

        showResult(winners);

 */
    }

    private void showResult(List<String> winners) {
        System.out.println();
        System.out.println("최종 우승자 : " + winners);
    }

    public List<String> findWinner(Map<String, Integer> cars) {
        List<Map.Entry<String, Integer>> carList = new ArrayList<>(cars.entrySet());
        carList.sort(((o1, o2) -> cars.get(o2.getKey()) - cars.get(o1.getKey())));

        List<String> winners = new ArrayList<>();
        Integer maxValue = carList.get(0).getValue();

        for (Map.Entry<String, Integer> car : carList) {
            if (car.getValue() != maxValue) {
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

}
