package programmers;

import java.util.*;

// 메뉴 리뉴얼
public class MenuRenewal {

    public String[] solution(String[] orders, int[] course) {
        List<String> combinations = new ArrayList<>();

        for (int c : course) {
            for (String order : orders) {
                List<String> generated = generateCombination(order, c);
                combinations.addAll(generated);
            }
        }

        // 생성 코스 별 카운트
        Map<String, Integer> countMap = new HashMap<>();
        for (String combination : combinations) {
            countMap.put(combination, countMap.getOrDefault(combination, 0) + 1);
        }


        List<String> answer = new ArrayList<>();
        for (int courseLength : course) {
            int maxCount = 0;
            List<String> selected = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                String combination = entry.getKey();
                int count = entry.getValue();

                if (combination.length() == courseLength && count >= 2) {
                    if (count > maxCount) {
                        maxCount = count;
                        selected.clear();
                        selected.add(combination);
                    } else if (count == maxCount) {
                        selected.add(combination);
                    }
                }
            }

            answer.addAll(selected);
        }

        String[] array = answer.toArray(new String[0]);
        Arrays.sort(array);

        return array;
    }


    private List<String> generateCombination(String order, int length) {
        List<String> result = new ArrayList<>();
        char[] items = order.toCharArray();
        Arrays.sort(items);
        backtrack(items, 0, length, new StringBuilder(), result);
        return result;
    }

    private void backtrack(char[] arr, int start, int r, StringBuilder sb, List<String> result) {
        if (sb.length() == r) {
            result.add(sb.toString());
            return;
        }

        for (int i = start; i < arr.length; i++) {
            sb.append(arr[i]);
            backtrack(arr, i + 1, r, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
