import java.util.*;
class islandPerimeter {
     public static class Pair{
         int x,y;
         Pair(int x, int y){
             this.x=x;
             this.y=y;
         }
     }
     public static int islandPerimeter(int[][] grid) {
         int m=grid.length, n=grid[0].length;
         boolean[][] isVisited=new boolean[m][n];
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 if(grid[i][j]==1 && isVisited[i][j]==false){
                     return bfs(grid, isVisited, i, j);
                 }
             }
         }
         return -1;
     }
     public static int bfs(int[][] grid, boolean[][] isVisited, int i, int j){
         int m=grid.length, n=grid[0].length;
         Queue<Pair> q=new LinkedList<>();
         q.add(new Pair(i,j));
         isVisited[i][j]=true;
         int perimeter=0;
         while(q.size()!=0){
             Pair val=q.remove();
             int row=val.x;
             int col=val.y;
             if(row==0 || grid[row-1][col]==0) perimeter++;
             if(col==0 || grid[row][col-1]==0) perimeter++;
             if(row==m-1 || grid[row+1][col]==0) perimeter++;
             if(col==n-1 || grid[row][col+1]==0) perimeter++;
             // move right
             if(col<n-1){
                 if(isVisited[row][col+1]==false && grid[row][col+1]==1){
                     q.add(new Pair(row,col+1));
                     isVisited[row][col+1]=true;
                 }
             }
             // move bottom
             if(row<m-1){
                 if(isVisited[row+1][col]==false && grid[row+1][col]==1){
                     q.add(new Pair(row+1,col));
                     isVisited[row+1][col]=true;
                 }
             }
             // move left
             if(col>0){
                 if(isVisited[row][col-1]==false && grid[row][col-1]==1){
                     q.add(new Pair(row,col-1));
                     isVisited[row][col-1]=true;
                 }
             }
             // move top
             if(row>0){
                 if(isVisited[row-1][col]==false && grid[row-1][col]==1){
                     q.add(new Pair(row-1,col));
                     isVisited[row-1][col]=true;
                 }
             }
         }
         return perimeter;
     }

     // Method 2 without individual condition with direction arrays.
    public static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static int islandPerimeter(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        boolean[][] isVisited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && isVisited[i][j]==false){
                    return bfs(grid, isVisited, i, j);
                }
            }
        }
        return -1;
    }
    public static int bfs(int[][] grid, boolean[][] isVisited, int i, int j){
        int m=grid.length, n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        isVisited[i][j]=true;
        int perimeter=0;
        int[] dx={0, 1, 0, -1};
        int[] dy={1, 0, -1, 0};
        while(q.size()!=0){
            Pair val=q.remove();
            int row=val.x;
            int col=val.y;
            if(row==0 || grid[row-1][col]==0) perimeter++;
            if(col==0 || grid[row][col-1]==0) perimeter++;
            if(row==m-1 || grid[row+1][col]==0) perimeter++;
            if(col==n-1 || grid[row][col+1]==0) perimeter++;
            for(int k=0;k<4;k++){
                int nr=row+dx[k];
                int nc=col+dy[k];
                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    if(isVisited[nr][nc]==false && grid[nr][nc]==1){
                        q.add(new Pair(nr,nc));
                        isVisited[nr][nc]=true;
                    }
                }
            }
        }
        return perimeter;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
}