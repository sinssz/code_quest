package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IslandConnectorTest {

    @Test
    void testExampleCase1() {
        IslandConnector connector = new IslandConnector();

        int n = 4;
        int[][] costs = {
                {0, 1, 1},
                {0, 2, 2},
                {1, 2, 5},
                {1, 3, 1},
                {2, 3, 8}
        };

        int result = connector.solution(n, costs);

        assertThat(result).isEqualTo(4);  // MST: 0-1 (1), 1-3 (1), 0-2 (2)
    }

    @Test
    void testAllEqualCosts() {
        IslandConnector connector = new IslandConnector();

        int n = 3;
        int[][] costs = {
                {0, 1, 1},
                {1, 2, 1},
                {0, 2, 1}
        };

        int result = connector.solution(n, costs);

        assertThat(result).isEqualTo(2);  // 아무 두 간선만 선택해도 MST 완성됨
    }

    @Test
    void testDisconnectedIslands() {
        IslandConnector connector = new IslandConnector();

        int n = 2;
        int[][] costs = {
                {0, 1, 3}
        };

        int result = connector.solution(n, costs);

        assertThat(result).isEqualTo(3);  // 하나의 간선으로 연결됨
    }

}