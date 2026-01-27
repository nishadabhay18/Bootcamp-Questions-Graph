import java.util.*;
class NumberOfIslands {
    public static class Pair{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    bfs(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void bfs(char[][] grid, boolean[][] visited, int i, int j){
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        visited[i][j]=true;
        while(q.size()!=0){
            Pair val=q.remove();
            int row=val.x;
            int col=val.y;
            // move right
            if(col<n-1){
                if(visited[row][col+1]==false && grid[row][col+1]=='1'){
                    q.add(new Pair(row,col+1));
                    visited[row][col+1]=true;
                }
            }
            // move bottom
            if(row<m-1){
                if(visited[row+1][col]==false && grid[row+1][col]=='1'){
                    q.add(new Pair(row+1,col));
                    visited[row+1][col]=true;
                }
            }
            // move left
            if(col>0){
                if(visited[row][col-1]==false && grid[row][col-1]=='1'){
                    q.add(new Pair(row,col-1));
                    visited[row][col-1]=true;
                }
            }
            // move top
            if(row>0){
                if(visited[row-1][col]==false && grid[row-1][col]=='1'){
                    q.add(new Pair(row-1,col));
                    visited[row-1][col]=true;
                }
            }
        }
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }
}