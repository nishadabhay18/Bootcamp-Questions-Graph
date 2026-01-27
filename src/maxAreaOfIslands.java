import java.util.*;
class maxAreaOfIsland {
    public static class Pair{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        boolean[][] isVisited=new boolean[m][n];
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && isVisited[i][j]==false){
                    int val=bfs(isVisited, grid,i,j);
                    maxArea=Math.max(maxArea,val);
                }
            }
        }
        return (maxArea==Integer.MIN_VALUE) ? 0:maxArea;
    }
    public static int bfs(boolean[][] isVisited, int[][] grid, int i, int j){
        int m=grid.length, n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        isVisited[i][j]=true;
        int count=1;
        while(q.size()!=0){
            Pair val=q.remove();
            int row=val.x;
            int col=val.y;
            // move right
            if(col<n-1){
                if(isVisited[row][col+1]==false && grid[row][col+1]==1){
                    q.add(new Pair(row,col+1));
                    isVisited[row][col+1]=true;
                    count++;
                }
            }
            // move bottom
            if(row<m-1){
                if(isVisited[row+1][col]==false && grid[row+1][col]==1){
                    q.add(new Pair(row+1,col));
                    isVisited[row+1][col]=true;
                    count++;
                }
            }
            // move left
            if(col>0){
                if(isVisited[row][col-1]==false && grid[row][col-1]==1){
                    q.add(new Pair(row,col-1));
                    isVisited[row][col-1]=true;
                    count++;
                }
            }
            // move top
            if(row>0){
                if(isVisited[row-1][col]==false && grid[row-1][col]==1){
                    q.add(new Pair(row-1,col));
                    isVisited[row-1][col]=true;
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}