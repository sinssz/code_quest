package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 신고 결과 받기
public class ReportService {

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
}
