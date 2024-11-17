package racingcar;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void 우승자_찾기_단일_우승자() {
        Map<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 3);
        cars.put("woni", 2);
        cars.put("jun", 1);

        List<String> winners = racingCar.findWinner(cars);

        assertEquals(1, winners.size());
        assertTrue(winners.contains("pobi"));
    }

    @Test
    public void 우승자_찾기_다중_우승자() {
        Map<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 3);
        cars.put("woni", 3);
        cars.put("jun", 2);

        List<String> winners = racingCar.findWinner(cars);

        assertEquals(2, winners.size());
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("woni"));
    }

    @Test
    public void 우승자_찾기_모두_우승자() {
        Map<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 3);
        cars.put("woni", 3);
        cars.put("jun", 3);

        List<String> winners = racingCar.findWinner(cars);

        assertEquals(3, cars.size());
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("woni"));
        assertTrue(winners.contains("jun"));
    }

}
