package racingcar;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    private final RacingCar racingCar = new RacingCar();

    @Test
    public void 자동차_생성() {
        Map<String, Integer> cars = racingCar.createCar(new String[]{"pobi","woni","jun"});
        assertThat(cars).isEqualTo(new HashMap<String, Integer>() {{
            put("pobi", 0);
            put("woni", 0);
            put("jun", 0);
        }});
    }

}
