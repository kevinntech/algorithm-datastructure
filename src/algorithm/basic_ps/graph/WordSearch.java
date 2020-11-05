package algorithm.basic_ps.graph;

public class WordSearch {
    public static void main(String[] args) {
        char[][] grid ={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word ="ABCCEED";

        WordSearch a = new WordSearch();
        System.out.println(a.exist(grid, word));
    }

    int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};
    int n, m;

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return false;

        n = board.length;
        m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dfs(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, int x, int y ,int index, String word) {
        // 정답인 경우
        if(index == word.length())
            return true;

        // 정답이 불가능한 경우
        if(x < 0 || x >= n || y < 0 || y >= m) // 격자의 범위를 넘어 섰다면 불가능
            return false;

        if(visited[x][y])
            return false;

        if(board[x][y] != word.charAt(index)) // 격자의 현재 좌표의 문자와 내가 찾고자 하는 단어의 문자가 같지 않다면
            return false;

        // 다음 경우를 구하는 경우
        visited[x][y] = true;

        for(int[] dir : dirs) {
            int dx = x + dir[0];
            int dy = y + dir[1];

            if(dfs(board, visited, dx, dy,index + 1, word)) {
                return true;
            }
        }

        visited[x][y] = false;

        return false;
    }

}
