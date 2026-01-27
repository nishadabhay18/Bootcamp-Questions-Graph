import java.util.*;
public class undirectedGraphCycle {
    public static class Pair{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] isVisited=new boolean[V];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(!isVisited[i]){
                q.add(new Pair(i,-1));
                isVisited[i]=true;
                while(!q.isEmpty()){
                    Pair val=q.remove();
                    int v1=val.x, parent=val.y;
                    for(int j:adj.get(v1)){
                        if(!isVisited[j]){
                            q.add(new Pair(j,v1));
                            isVisited[j]=true;
                        }
                        else if(j != parent){
                            // visited & not parent => cycle
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {2, 3}
        };
        int V = 4;
        undirectedGraphCycle obj = new undirectedGraphCycle();  // create object
        boolean hasCycle = obj.isCycle(V, edges);
        System.out.println(hasCycle);  // true
    }
}
