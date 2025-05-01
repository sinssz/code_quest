package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenuRenewalTest {

    @Test
    void testCase1() {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] expected = {"AC", "ACDE", "BCFG", "CDE"};

        String[] actual = new MenuRenewal().solution(orders, course);

        assertThat(actual).containsExactly(expected);
    }

    @Test
    void testCase2() {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};
        String[] expected = {"ACD", "AD", "ADE", "CD", "XYZ"};

        String[] actual = new MenuRenewal().solution(orders, course);

        assertThat(actual).containsExactly(expected);
    }

    @Test
    void testCase3() {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        String[] expected = {"WX", "XY"};

        String[] actual = new MenuRenewal().solution(orders, course);

        assertThat(actual).containsExactly(expected);
    }

}