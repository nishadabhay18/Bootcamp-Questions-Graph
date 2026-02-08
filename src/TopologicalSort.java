import java.util.*;
class TopologicalSort {
    // DFS
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> ans=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
        }
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false) dfs(i,adj,visited,ans);
        }
        Collections.reverse(ans);
        return ans;
    }
    public void dfs(int i, List<List<Integer>> adj, boolean[] visited, List<Integer> list){
        visited[i]=true;
        for(int ele:adj.get(i)){
            if(visited[ele]==false) dfs(ele,adj,visited,list);
        }
        list.add(i);
    }

    // BFS -> Kahn's Algorithm
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> ans=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        int[] indegree=new int[V];
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++) if(indegree[i]==0) q.add(i);
        while(q.size()!=0){
            int val=q.remove();
            ans.add(val);
            for(int ele:adj.get(val)){
                indegree[ele]--;
                if(indegree[ele]==0) q.add(ele);
            }
        }
        return ans;
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
        ArrayList<Integer> ans=topoSort(V,edges);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i)+" ");
        }
    }
}