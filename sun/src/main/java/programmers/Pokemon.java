package programmers;

import java.util.HashSet;
import java.util.Set;

public class Pokemon {

    public int solution(int[] nums) {
        Set<Integer> pokemons = new HashSet<>();
        for (int num : nums) {
            pokemons.add(num);
        }

        int maxSelect = nums.length / 2;
        return Math.min(pokemons.size(), maxSelect);
    }
}
