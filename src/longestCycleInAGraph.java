import java.util.*;
class longestCycleInAGraph {
    // BFS- TLE
    public static int longestCycle(int[] edges) {
        int n=edges.length;
        int longestCycle=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            Queue<Integer> q=new LinkedList<>();
            int[] dist=new int[n];
            Arrays.fill(dist,-1);
            q.add(i);
            dist[i]=0;
            while(q.size()!=0){
                int val=q.remove();
                int ele=edges[val];
                if(ele==-1) continue;
                if(dist[ele]==-1){
                    q.add(ele);
                    dist[ele]=dist[val]+1;
                }else{
                    longestCycle=Math.max(longestCycle,dist[val]-dist[ele]+1);
                }
            }
        }
        return (longestCycle==Integer.MIN_VALUE)? -1:longestCycle;
    }

    // BFS - TOPOLOGICAL SORT
    public static int longestCycle(int[] edges){
        int n=edges.length;
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            if(edges[i]!=-1) indegree[edges[i]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(q.size()!=0){
            int val=q.remove();
            int v=edges[val];
            if(v!=-1){
                indegree[v]--;
                if(indegree[v]==0) q.add(v);
            }
        }
        boolean[] mark=new boolean[n];
        int longestCycle=-1;
        for(int i=0;i<n;i++){
            if(indegree[i]>0 && mark[i]==false){
                int curr=i, len=0;
                while(mark[curr]==false){
                    mark[curr]=true;
                    len++;
                    curr=edges[curr];
                }
                longestCycle=Math.max(longestCycle,len);
            }
        }
        return longestCycle;
    }
    public static void main(String[] args) {
        int[]edges = {3,3,4,2,3};
        System.out.println(longestCycle(edges));
    }
}