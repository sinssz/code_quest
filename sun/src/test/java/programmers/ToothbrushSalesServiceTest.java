package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ToothbrushSalesServiceTest {

    @Test
    void testCase1() {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        int[] expected = {360, 958, 108, 0, 450, 18, 180, 1080};

        ToothbrushSalesService service = new ToothbrushSalesService();
        int[] actual = service.solution(enroll, referral, seller, amount);

        assertThat(actual).containsExactly(expected);
    }

    @Test
    void testCase2() {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"sam", "emily", "jaimie", "edward"};
        int[] amount = {2, 3, 5, 4};

        int[] expected = {0, 110, 378, 180, 270, 450, 0, 0};

        ToothbrushSalesService service = new ToothbrushSalesService();
        int[] actual = service.solution(enroll, referral, seller, amount);

        assertThat(actual).containsExactly(expected);
    }
}