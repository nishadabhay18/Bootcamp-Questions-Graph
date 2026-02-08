import java.util.*;
class pathWithMinimumEffort {
    public static class Triplet implements Comparable<Triplet>{
        int row,col,dist;
        Triplet(int row, int col, int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
        public int compareTo(Triplet t){
            return this.dist-t.dist;
        }
    }
    // here we are going to traverse using diretion condition not any list or edges.
    public static int minimumEffortPath(int[][] heights) {
        int m=heights.length, n=heights[0].length;
        int[][] visited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visited[i][j]=Integer.MAX_VALUE;
            }
        }
        visited[0][0]=0;
        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        pq.add(new Triplet(0,0,0));
        while(pq.size()!=0){
            Triplet val=pq.remove();
            int row=val.row, col=val.col, dist=val.dist;
            // move right
            if(col<n-1){
                int dis=Math.abs(heights[row][col]-heights[row][col+1]);
                dis=Math.max(dis,dist);
                if(dis<visited[row][col+1]){
                    visited[row][col+1]=dis;
                    pq.add(new Triplet(row,col+1,dis));
                }
            }
            // move left
            if(col>0){
                int dis=Math.abs(heights[row][col]-heights[row][col-1]);
                dis=Math.max(dis,dist);
                if(dis<visited[row][col-1]){
                    visited[row][col-1]=dis;
                    pq.add(new Triplet(row,col-1,dis));
                }
            }
            // move up
            if(row>0){
                int dis=Math.abs(heights[row-1][col]-heights[row][col]);
                dis=Math.max(dis,dist);
                if(dis<visited[row-1][col]){
                    visited[row-1][col]=dis;
                    pq.add(new Triplet(row-1,col,dis));
                }
            }
            // move bottom
            if(row<m-1){
                int dis=Math.abs(heights[row][col]-heights[row+1][col]);
                dis=Math.max(dis,dist);
                if(dis<visited[row+1][col]){
                    visited[row+1][col]=dis;
                    pq.add(new Triplet(row+1,col,dis));
                }
            }
        }
        return visited[m-1][n-1];
    }

    public static int minimumEffortPath(int[][] heights) {
        int m=heights.length, n=heights[0].length;
        int[][] visited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visited[i][j]=Integer.MAX_VALUE;
            }
        }
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        visited[0][0]=0;
        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        pq.add(new Triplet(0,0,0));
        while(pq.size()!=0){
            Triplet val=pq.remove();
            int row=val.row, col=val.col, dist=val.dist;
            for(int k=0;k<4;k++){
                int nr=row+dx[k];
                int nc=col+dy[k];
                if(nr<0 || nc<0 || nr>m-1 || nc>n-1) continue;
                int dis=Math.abs(heights[row][col]-heights[nr][nc]);
                dis=Math.max(dis,dist);
                if(dis<visited[nr][nc]){
                    visited[nr][nc]=dis;
                    pq.add(new Triplet(nr,nc,dis));
                }
            }
        }
        return visited[m-1][n-1];
    }
    public static void main(String[] args) {
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(heights));
    }
}