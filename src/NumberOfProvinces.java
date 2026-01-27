import java.util.*;
class Solution {
    // BFS
    public static int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int count=0;
        boolean isVisited[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(isVisited[i]==false){
                bfs(isConnected,i,isVisited);
                count++;
            }
        }
        return count;
    }
    public static void bfs(int[][] isConnected, int i, boolean isVisited[]){
        int n=isConnected.length;
        isVisited[i]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int front=q.remove();
            for(int j=0;j<n;j++){
                if(isConnected[front][j]==1 && isVisited[j]==false){
                    q.add(j);
                    isVisited[j]=true;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
}