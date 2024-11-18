package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    @DisplayName("자동차 이름 목록으로 Car 객체 리스트를 생성한다.")
    void 자동차_리스트_생성() {
        // Given
        String carNames = "pobi,woni,jun";

        // When
        Cars cars = new Cars(carNames);
        List<Car> carList = cars.get();

        // Then
        assertThat(carList)
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"   "})
    @DisplayName("자동차 이름 목록이 null, 빈 값, 공백일 경우 예외를 발생시킨다.")
    void 자동차_이름_목록_유효성_검사_예외(String carNamesInput) {
        assertThatThrownBy(() -> new Cars(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 목록이 비어 있지 않아야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,pobi", "pobi,woni,woni"})
    @DisplayName("중복된 자동차 이름이 있는 경우 예외를 발생시킨다.")
    void 중복된_자동차_이름_예외(String carNamesInput) {
        assertThatThrownBy(() -> new Cars(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름이 있습니다.");
    }


}