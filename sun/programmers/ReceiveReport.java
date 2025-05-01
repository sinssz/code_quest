package programmers;

import java.util.*;

// 신고 결과 받기
public class ReceiveReport {

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> target = new HashMap<>();
        Map<String, Set<String>> me = new HashMap<>();

        for (String line : report) {
            String[] strings = line.split(" ");
            String reporter = strings[0];
            String targetId = strings[1];

            target.computeIfAbsent(reporter, x -> new HashSet<>()).add(targetId);
            me.computeIfAbsent(targetId, x -> new HashSet<>()).add(reporter);
        }

        Set<String> blocked = new HashSet<>();
        for (Map.Entry<String, Set<String>> entry : me.entrySet()) {
            if (entry.getValue().size() >= k) {
                blocked.add(entry.getKey());
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            int getMailCount = 0;
            for (String s : target.getOrDefault(id_list[i], new HashSet<>())) {
                if (blocked.contains(s)) {
                    getMailCount++;
                }
            }
            answer[i] = getMailCount;
        }

        return answer;
    }

    public static void main(String[] args) {
        ReceiveReport rr = new ReceiveReport();

        // 테스트 케이스 1
        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {
                "muzi frodo", "apeach frodo",
                "frodo neo", "muzi neo", "apeach muzi"
        };
        int k1 = 2;

        int[] result1 = rr.solution(id_list1, report1, k1);
        System.out.println("테스트케이스 1 결과: " + Arrays.toString(result1)); // [2,1,1,0]

        // 테스트 케이스 2
        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;

        int[] result2 = rr.solution(id_list2, report2, k2);
        System.out.println("테스트케이스 2 결과: " + Arrays.toString(result2)); // [0,0]
    }
}
