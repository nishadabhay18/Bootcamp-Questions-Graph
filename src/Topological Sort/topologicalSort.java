class Solution {
    // DFS TC-> O(V+E) SC-> O(V)
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge: edges) adj.get(edge[0]).add(edge[1]);
        boolean[] visited=new boolean[V];
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                dfs(adj, i, visited, ans);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
    public void dfs(List<List<Integer>> adj, int i, boolean[] visited, ArrayList<Integer> ans){
        visited[i]=true;
        for(int j: adj.get(i)){
            if(visited[j]==false){
                dfs(adj, j, visited, ans);
            }
        }
        ans.add(i);
    }
    
    // BFS TC-> O(V+E) SC-> O(V) Topological Sort
    public ArrayList<Integer> topoSort(int V, int[][] edges){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        int[] indegree=new int[V];
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(q.size()!=0){
            int val=q.remove();
            ans.add(val);
            for(int j: adj.get(val)){
                indegree[j]--;
                if(indegree[j]==0) q.add(j);
            }
        }
        return ans;
    }
}
