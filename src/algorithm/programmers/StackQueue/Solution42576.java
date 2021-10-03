package algorithm.programmers.StackQueue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 완주하지 못한 선수
 */
public class Solution42576 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        Map<String, Integer> participantMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (participantMap.containsKey(participant[i])) {
                participantMap.put(participant[i], participantMap.get(participant[i]) + 1);
            } else {
                participantMap.put(participant[i], 1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            if (participantMap.containsKey(completion[i])) {
                participantMap.put(completion[i], participantMap.get(completion[i]) - 1);
            }
        }

        Optional<String> disCompletion = participantMap.entrySet().stream().filter(e -> e.getValue() >= 1).map(Map.Entry::getKey).findFirst();
        System.out.println(disCompletion.get());

        /*String str = String.join(",", completion);

        List<String> result = Arrays.stream(participant).filter(s -> ! str.contains(s)).collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }*/
    }
}
