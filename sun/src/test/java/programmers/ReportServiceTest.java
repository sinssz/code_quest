package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReportServiceTest {

    @Test
    void testCase1() {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {
                "muzi frodo", "apeach frodo",
                "frodo neo", "muzi neo", "apeach muzi"
        };
        int k = 2;

        int[] expected = {2, 1, 1, 0};
        int[] actual = new ReportService().solution(id_list, report, k);

        assertThat(actual).containsExactly(expected);
    }

    @Test
    void testCase2() {
        String[] id_list = {"con", "ryan"};
        String[] report = {
                "ryan con", "ryan con", "ryan con", "ryan con"
        };
        int k = 3;

        int[] expected = {0, 0};
        int[] actual = new ReportService().solution(id_list, report, k);

        assertThat(actual).containsExactly(expected);
    }

}