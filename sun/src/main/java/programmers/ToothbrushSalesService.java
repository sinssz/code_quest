package programmers;

import java.util.HashMap;
import java.util.Map;

// 다단계 칫솔 판매
public class ToothbrushSalesService {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Seller> sellers = new HashMap<>();

        for (String s : enroll) {
            sellers.put(s, new Seller(s));
        }

        for (int i = 0, n = enroll.length; i < n; i++) {
            Seller s = sellers.get(enroll[i]);
            String parentName = referral[i];

            if (!parentName.equals("-")) {
                s.setParent(sellers.get(parentName));
            }
        }

        for (int i = 0, n = seller.length; i < n; i++) {
            sellers.get(seller[i]).addProfit(amount[i] * 100);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0, n = enroll.length; i < n; i++) {
            answer[i] = sellers.get(enroll[i]).getProfit();
        }

        return answer;
    }

    static class Seller {
        private final String name;
        private Seller parent;
        private int profit;

        public Seller(String name) {
            this.name = name;
            this.profit = 0;
        }

        public void setParent(Seller parent) {
            this.parent = parent;
        }

        public void addProfit(int amount) {
            // 10% 위로 전달, 90% 본인 보유
            // 10% 계산한 금액이 1원 미만인 경우 이득 분배 X
            int commission = amount / 10;
            int myShare = amount - commission;

            this.profit += myShare;

            if (commission >= 1 && parent != null) {
                parent.addProfit(commission); // 민호 포함
            }
        }

        public int getProfit() {
            return profit;
        }
    }

}
