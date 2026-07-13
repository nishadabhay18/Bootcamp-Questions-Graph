class Solution {
    public static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // BFS TC-> O(m*n) SC-> O(m*n)
    public int countDistinctIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        HashSet<ArrayList<ArrayList<Integer>>> set = new HashSet<>();
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'L' && !isVisited[i][j]) {
                    set.add(bfs(grid, i, j, isVisited));
                }
            }
        }
        return set.size();
    }
    public ArrayList<ArrayList<Integer>> bfs(char[][] grid, int i, int j, boolean[][] isVisited) {
        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        isVisited[i][j] = true;
        int baseRow = i, baseCol = j;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Pair val = q.remove();
            int x = val.x, y = val.y;
            list.add(Arrays.asList(x - baseRow, y - baseCol));
            for (int k = 0; k < 4; k++) {
                int nr = x + dr[k], nc = y + dc[k];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n &&
                        grid[nr][nc] == 'L' && !isVisited[nr][nc]) {
                    q.add(new Pair(nr, nc));
                    isVisited[nr][nc] = true;
                }
            }
        }
        return list;
    }


    // DFS TC-> O(m*n) SC-> O(m*n)
    public int countDistinctIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        HashSet<ArrayList<ArrayList<Integer>>> set = new HashSet<>();
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'L' && !isVisited[i][j]) {
                    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
                    dfs(grid, i, j, i, j, isVisited, list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    public void bfs(char[][] grid, int i, int j, int baseRow, int baseCol, boolean[][] isVisited, ArrayList<ArrayList<Integer>> list) {
        int m = grid.length, n = grid[0].length;
        isVisited[i][j] = true;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        list.add(Arrays.asList(i - baseRow, j - baseCol));
        for(int k = 0; k < 4; k++) {
            int nr = i + dr[k], nc = j + dc[k];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 'L' && !isVisited[nr][nc]) {
                dfs(grid, nr, nc, baseRow, baseCol, isVisited, list);
            }
        }
    }
}