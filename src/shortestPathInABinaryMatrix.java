import java.util.*;
class shortestPathInABinaryMatrix {
    public static class Pair{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1;
        boolean[][] isVisited=new boolean[n][n];
        return bfs(grid,isVisited);
    }
    public static int bfs(int[][] grid, boolean[][] isVisited){
        int n=grid.length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0));
        isVisited[0][0]=true;
        int count=1;
        while(q.size()!=0){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair val=q.remove();
                int row=val.x;
                int col=val.y;
                if(row==n-1 && col==n-1) return count;
                // move right
                if(col<n-1){
                    if(isVisited[row][col+1]==false && grid[row][col+1]==0){
                        q.add(new Pair(row,col+1));
                        isVisited[row][col+1]=true;
                    }
                }
                // move bottom
                if(row<n-1){
                    if(isVisited[row+1][col]==false && grid[row+1][col]==0){
                        q.add(new Pair(row+1,col));
                        isVisited[row+1][col]=true;
                    }
                }
                // move left
                if(col>0){
                    if(isVisited[row][col-1]==false && grid[row][col-1]==0){
                        q.add(new Pair(row,col-1));
                        isVisited[row][col-1]=true;
                    }
                }
                // move top
                if(row>0){
                    if(isVisited[row-1][col]==false && grid[row-1][col]==0){
                        q.add(new Pair(row-1,col));
                        isVisited[row-1][col]=true;
                    }
                }
                // move top-left
                if(row>0 && col>0){
                    if(isVisited[row-1][col-1]==false && grid[row-1][col-1]==0){
                        q.add(new Pair(row-1,col-1));
                        isVisited[row-1][col-1]=true;
                    }
                }
                // move top-right
                if(row>0 && col<n-1){
                    if(isVisited[row-1][col+1]==false && grid[row-1][col+1]==0){
                        q.add(new Pair(row-1,col+1));
                        isVisited[row-1][col+1]=true;
                    }
                }
                // move bottom-left
                if(row<n-1 && col>0){
                    if(isVisited[row+1][col-1]==false && grid[row+1][col-1]==0){
                        q.add(new Pair(row+1,col-1));
                        isVisited[row+1][col-1]=true;
                    }
                }
                // move bottom-right
                if(row<n-1 && col<n-1){
                    if(isVisited[row+1][col+1]==false && grid[row+1][col+1]==0){
                        q.add(new Pair(row+1,col+1));
                        isVisited[row+1][col+1]=true;
                    }
                }
            }
            count++;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
