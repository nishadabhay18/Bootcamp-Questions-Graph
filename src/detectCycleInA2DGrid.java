import java.util.*;
class detectCycleInA2DGrid {
    public static class Quad{
        int w,x,y,z;
        Quad(int w, int x, int y, int z){
            this.w=w;
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }
    // BFS
    public static boolean containsCycle(char[][] grid) {
        int m=grid.length, n=grid[0].length;
        boolean[][] isVisited=new boolean[m][n];
        int[] dx={0, 1, 0, -1};
        int[] dy={1, 0, -1, 0};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isVisited[i][j]==false){
                    Queue<Quad> q=new LinkedList<>();
                    q.add(new Quad(i,j,-1,-1));
                    isVisited[i][j]=true;
                    while(q.size()!=0){
                        Quad val=q.remove();
                        int row=val.w, col=val.x, pr=val.y, pc=val.z;
                        for(int k=0;k<4;k++){
                            int nr=row+dx[k], nc=col+dy[k];
                            if(nr>=0 && nc>=0 && nr<m && nc<n){
                                if(grid[nr][nc] != grid[row][col]) continue;
                                if(isVisited[nr][nc]==false){
                                    q.add(new Quad(nr,nc,row,col));
                                    isVisited[nr][nc]=true;
                                }else if(isVisited[i][j]==true && !(pr==nr && pc==nc)) return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    // DFS
    public static boolean containsCycle(char[][] grid){
        int m=grid.length, n=grid[0].length;
        boolean[][] isVisited=new boolean[m][n];
        int[] dx={0, 1, 0, -1};
        int[] dy={1, 0, -1, 0};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isVisited[i][j]==false){
                    if(dfs(isVisited,i,j,-1,-1,grid)==true) return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(boolean[][] isVisited, int i,int j,int pr,int pc, char[][] grid){
        int m=grid.length, n=grid[0].length;
        isVisited[i][j]=true;
        int[] dx={0, 1, 0, -1};
        int[] dy={1, 0, -1, 0};
        for(int k=0;k<4;k++){
            int nr=dx[k]+i, nc=dy[k]+j;
            if(nr>=0 && nc>=0 && nr<m && nc<n){
                if(grid[nr][nc]!=grid[i][j]) continue;
                if(isVisited[nr][nc]==false){
                    isVisited[nr][nc]=true;
                    if(dfs(isVisited, nr,nc, i,j, grid)==true) return true;
                }
                else if(isVisited[nr][nc]==true && !(nr==pr && nc==pc)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] grid = {{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
        System.out.println(containsCycle(grid));
    }
}