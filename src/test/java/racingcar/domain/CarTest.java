package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("자동차 이름으로 Car 객체를 생성한다.")
    void 자동차_생성() {
        // Given
        String name = "pobi";

        // When
        Car car = new Car(name);

        // Then
        assertThat(car.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {" "})
    @DisplayName("자동차 이름이 null, 빈 칸, 공백일 경우 예외를 발생시킨다.")
    void 자동차_이름_유효성_검사_예외(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 비어 있지 않아야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"very long name", "아주 긴 이름", "1234567"})
    @DisplayName("자동차 이름이 5자를 초과할 경우 예외를 발생시킨다.")
    void 자동차_이름_길이_예외(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자 초과할 수 없습니다.");
    }

}