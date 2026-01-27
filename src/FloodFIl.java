import java.util.*;
class FloodFill {
    public static class Pair{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length, n=image[0].length;
        boolean[][] isVisited=new boolean[m][n];
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(sr,sc));
        isVisited[sr][sc]=true;
        int oldColor=image[sr][sc];
        while(q.size()!=0){
            Pair val=q.remove();
            int row=val.x;
            int col=val.y;
            image[row][col]=color;
            // move right
            if(col<n-1){
                if(isVisited[row][col+1]==false && image[row][col+1]==oldColor){
                    q.add(new Pair(row,col+1));
                    isVisited[row][col+1]=true;
                }
            }
            // move bottom
            if(row<m-1){
                if(isVisited[row+1][col]==false && image[row+1][col]==oldColor){
                    q.add(new Pair(row+1,col));
                    isVisited[row+1][col]=true;
                }
            }
            // move left
            if(col>0){
                if(isVisited[row][col-1]==false && image[row][col-1]==oldColor){
                    q.add(new Pair(row,col-1));
                    isVisited[row][col-1]=true;
                }
            }
            // move top
            if(row>0){
                if(isVisited[row-1][col]==false && image[row-1][col]==oldColor){
                    q.add(new Pair(row-1,col));
                    isVisited[row-1][col]=true;
                }
            }
        }
        return image;
    }

    // Method 2 without individual direction conditions.
    public static class Pair{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length, n=image[0].length;
        boolean[][] isVisited=new boolean[m][n];
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(sr,sc));
        isVisited[sr][sc]=true;
        int oldColor=image[sr][sc];
        int[] dx={0, 1, 0, -1};
        int[] dy={1, 0, -1, 0};
        while(q.size()!=0){
            Pair val=q.remove();
            int row=val.x;
            int col=val.y;
            image[row][col]=color;
            for(int i=0;i<4;i++){
                int nr=row+dx[i];
                int nc=col+dy[i];
                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    if(isVisited[nr][nc]==false && image[nr][nc]==oldColor){
                        q.add(new Pair(nr,nc));
                        isVisited[nr][nc]=true;
                    }
                }
            }
        }
        return image;
    }
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        int[][] arr=floodFill(image,sr,sc,color);
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.println(arr[i][j]+" ");
            }
        }
    }
}