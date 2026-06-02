class islandPerimeter {
    public static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] isVisited=new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1 && isVisited[i][j] == false){
                    return bfs(grid, isVisited, i, j);
                }
            }
        }
        return -1;
    }
    public int bfs(int[][] grid, boolean[][] isVisited, int i, int j){
        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        isVisited[i][j] = true;
        int perimeter = 0;
        while(q.size() != 0){
            Pair val = q.remove();
            int row = val.x;
            int col = val.y;
            if(row==0 || grid[row-1][col]==0) perimeter++;
            if(col==0 || grid[row][col-1]==0) perimeter++;
            if(row==m-1 || grid[row+1][col]==0) perimeter++;
            if(col==n-1 || grid[row][col+1]==0) perimeter++;
            if(col < n-1){ // move right
                if(isVisited[row][col+1] == false && grid[row][col+1] == 1){
                    q.add(new Pair(row, col+1));
                    isVisited[row][col+1] = true;
                }
            }
            if(row < m-1){ // move bottom
                if(isVisited[row+1][col] == false && grid[row+1][col] == 1){
                    q.add(new Pair(row+1, col));
                    isVisited[row+1][col] = true;
                }
            }
            if(col > 0){ // move left
                if(isVisited[row][col-1] == false && grid[row][col-1] == 1){
                    q.add(new Pair(row, col-1));
                    isVisited[row][col-1] = true;
                }
            }
            if(row > 0){ // move top
                if(isVisited[row-1][col] == false && grid[row-1][col] == 1){
                    q.add(new Pair(row-1, col));
                    isVisited[row-1][col] = true;
                }
            }
        }
        return perimeter;
    }
}
