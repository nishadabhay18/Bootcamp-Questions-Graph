import java.util.*;
class DirectedGraphCycle {
    // DFS
    public static boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
        }
        boolean[] visited=new boolean[V];
        boolean[] path=new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(dfs(i,adj,visited,path)==true) return true;
            }
        }
        return false;
    }
    public static boolean dfs(int i, List<List<Integer>> adj, boolean[] visited, boolean[] path){
        visited[i]=true;
        path[i]=true;
        for(int ele:adj.get(i)){
            if(visited[ele]==false){
                if(dfs(ele,adj,visited,path)) return true;
            }else if(visited[ele]==true && path[ele]==true){ // part of that path.
                return true;
            }
        }
        path[i]=false;
        return false;
    }

    // BFS Kahn's Algorithm
    public static boolean isCyclic(int V, int[][] edges){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        int[] indegree=new int[V];
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        List<Integer> list=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(q.size()!=0){
            int val=q.remove();
            list.add(val);
            for(int ele:adj.get(val)){
                indegree[ele]--;
                if(indegree[ele]==0) q.add(ele);
            }
        }
        return (list.size()==V)? false:true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int[][] edges=new int[V][2];
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[0].length;j++){
                edges[i][j]=sc.nextInt();
            }
        }
        boolean ans=isCyclic(V,edges);
        System.out.println(ans);
    }
}