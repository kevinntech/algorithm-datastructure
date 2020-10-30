package algorithm.basic_ps.string_array;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] list =  {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(list));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if (strs == null || strs.length == 0)
            return result;

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();

            Arrays.sort(charArray);
            String key = String.valueOf(charArray);

            if (map.containsKey(key)){
                map.get(key).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }

        result.addAll(map.values());

        return result;
    }
}