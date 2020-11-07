package algorithm.basic_ps.graph;

import java.util.*;

public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        String s = "(a)())()";
        RemoveInvalidParentheses a = new RemoveInvalidParentheses();
        System.out.println(a.removeInvalidParentheses(s));
    }

    public List<String> removeInvalidParentheses(String s){
        List<String> result = new ArrayList<>();

        if(s == null)
            return result;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();      // 방문 여부

        queue.offer(s); // 큐에 현재 문자열을 넣는다.
        visited.add(s); // 방문한 문자열을 넣는다.
        boolean found = false; // 더 이상 BFS 탐색 하지 않도록 함

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String str = queue.poll();  // 큐에서 하나를 꺼낸다.

                if(isValid(str)) {      // 해당 괄호가 유효한지 체크한다. 유효하다면
                    result.add(str);    // 결과에 추가한다.
                    found = true;       // 더 이상 BFS 탐색 하지 않도록 함
                }

                System.out.println("found " + found);

                if(found)
                    continue;

                // 새로운 문자열을 만드는 것은 하나의 괄호만 제거하는 경우까지만 반복한다.
                for(int j = 0; j < str.length(); j++) {
                    if(str.charAt(j) != '(' && str.charAt(j) != ')') // 괄호가 아닌 경우는 건들지 않는다.
                        continue;
                    System.out.println(" [newStr] " + str.substring(0, j) + str.substring(j + 1));
                    String newStr = str.substring(0, j) + str.substring(j + 1); // 한 문자(괄호)씩 제외하면서 합친 새로운 문자열을 만든다.

                    if(!visited.contains(newStr)) { // visited에 존재하지 않는 문자열이면
                        queue.offer(newStr);        // 큐에 넣고
                        visited.add(newStr);        // 방문 처리한다.
                    }
                }
            }
        }

        return result;
    }

    private boolean isValid(String str) {
        int count = 0;

        for(char ch : str.toCharArray()) {
            if(ch == '(') {
                count++;
            }else if(ch == ')') {
                count--;

                /* ()())( 와 같이 닫는 괄호가 연속으로 나오면 음수가 되는데
                   그때, 유효하지 않다고 반환하도록 한다.
                   아래 코드가 없다면 유효한 괄호라고 반환하게 됨 */
                if(count < 0)
                    return false;
            }
        }

        return count == 0; // count가 0이면 유효한 괄호
    }

}
