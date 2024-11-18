package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String carNamesInput) {
        validateNotBlank(carNamesInput);

        List<String> carNames = parseCarNames(carNamesInput);
        validateNoDuplicates(carNames);

        this.cars = createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private List<String> parseCarNames(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void validateNotBlank(String carNames) {
        if(carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름 목록이 비어 있지 않아야 합니다.");
        }
    }

    private static void validateNoDuplicates(List<String> carNames) {
        if(carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

}
