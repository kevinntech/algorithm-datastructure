package algorithm.basic_ps.graph;

/* 해당 문제의 Topic은 Backtracking으로 파악 됨 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] grid ={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word ="ABCCED";

        WordSearch a = new WordSearch();
        System.out.println(a.exist(grid, word));
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m, n;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return false;

        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(recursive(board, word, i, j,0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean recursive(char[][] board, String word, int x, int y, int index) {
        // 정답인 경우
        if(index == word.length())
            return true;

        // 정답이 불가능한 경우
        if(x < 0 || x >= m || y < 0 || y >= n) // 격자의 범위를 넘어 섰다면 불가능
            return false;

        if(visited[x][y])
            return false;

        if(board[x][y] != word.charAt(index)) // 격자의 현재 좌표의 문자와 내가 찾고자 하는 단어의 문자가 같지 않다면
            return false;

        // 다음 경우를 구하는 경우
        visited[x][y] = true;

        for(int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if(recursive(board, word, nx, ny,index + 1)) {
                return true;
            }
        }

        visited[x][y] = false;

        return false;
    }

}
