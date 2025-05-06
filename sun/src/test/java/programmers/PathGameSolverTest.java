package programmers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PathGameSolverTest {

    private PathGameSolver solver;

    @BeforeEach
    void setUp() {
        solver = new PathGameSolver();
    }

    @Test
    void testExampleCase1() {
        int[][] nodeinfo = {
                {5, 3}, {11, 5}, {13, 3}, {3, 5},
                {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}
        };

        int[][] expected = {
                {7, 4, 6, 9, 1, 8, 5, 2, 3},
                {9, 6, 5, 8, 1, 4, 3, 2, 7}
        };

        int[][] actual = solver.solution(nodeinfo);
        assertThat(actual[0]).containsExactly(expected[0]);
        assertThat(actual[1]).containsExactly(expected[1]);
    }

    @Test
    void testSingleNode() {
        int[][] nodeinfo = {
                {0, 0}
        };

        int[][] expected = {
                {1}, {1}
        };

        int[][] actual = solver.solution(nodeinfo);
        assertThat(actual[0]).containsExactly(expected[0]);
        assertThat(actual[1]).containsExactly(expected[1]);
    }

    @Test
    void testLeftSkewedTree() {
        int[][] nodeinfo = {
                {5, 3}, {4, 2}, {3, 1}
        };

        int[][] expected = {
                {1, 2, 3},
                {3, 2, 1}
        };

        int[][] actual = solver.solution(nodeinfo);
        assertThat(actual[0]).containsExactly(expected[0]);
        assertThat(actual[1]).containsExactly(expected[1]);
    }

    @Test
    void testRightSkewedTree() {
        int[][] nodeinfo = {
                {1, 3}, {2, 2}, {3, 1}
        };

        int[][] expected = {
                {1, 2, 3},
                {3, 2, 1}
        };

        int[][] actual = solver.solution(nodeinfo);
        assertThat(actual[0]).containsExactly(expected[0]);
        assertThat(actual[1]).containsExactly(expected[1]);
    }
}