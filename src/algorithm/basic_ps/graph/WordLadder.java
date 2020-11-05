package algorithm.basic_ps.graph;

import java.util.Arrays;
import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(words);

        WordLadder a = new WordLadder();
        System.out.println(a.ladderLength("hit","cog", wordList));
    }

    // BFS로 문제를 해결한다.
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) // 마지막 단어가 포함 되어 있지 않다면 정답이 될 수 없다.
            return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> dictionary = new HashSet<>(wordList); // wordList를 가지고 중복 없는 Set을 만든다.

        queue.offer(beginWord); // 큐에 시작 단어를 넣는다.

        int level = 1; // 일종의 방문처리 , 몇 번 방문 했는지 여부를 기록

        while (!queue.isEmpty()) { // 큐가 비어 있지 않은 동안, 큐에 있는 것을 size 만큼 꺼낸다.
            int size = queue.size();

            // 레벨별 탐색
            for (int i = 0; i < size; i++) {
                String str = queue.poll();

                if (str.equals(endWord)) // str이 내가 찾는 종료 단어이면 level을 출력하고 종료
                    return level;

                for (String newWord : createNewWord(str, dictionary)) { // 새로운 단어를 만들어내서 큐에 넣는다. (여기서 새로운 단어는 현재 노드의 인접 노드와 같다고 생각)
                    //System.out.println("newWord "+ newWord);
                    queue.offer(newWord);
                }
            }

            level++;

        }

        return 0;
    }

    public List<String> createNewWord(String str, Set<String> dictionary) {
        List<String> result = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char[] chars = str.toCharArray(); // 문자열을 char 배열로 변경 (하나의 문자만 바뀌어야 하므로 이 위치에 있어야 함)

            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;  // 문자열의 i번째 요소를 한 글자만 변경한다. aot~zot

                String newWord = new String(chars);

                if(dictionary.contains(newWord)){
                    //System.out.println(dictionary);
                    dictionary.remove(newWord);
                    result.add(newWord);
                }
            }
        }
        return result;
    }

}
