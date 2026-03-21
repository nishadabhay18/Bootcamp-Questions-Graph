class allAncestorsOfANodeInDAG {
    // DFS
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<n;i++){
            List<Integer> list=new ArrayList<>();
            dfs(adj,i,list,new boolean[n]);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
    public void dfs(List<List<Integer>> adj, int i, List<Integer> list, boolean[] isVisited){
        isVisited[i]=true;
        for(int ele:adj.get(i)){
            if(isVisited[ele]==false){
                list.add(ele);
                dfs(adj,ele,list,isVisited);
            }
        }
    }

    // BFS Kahn's Algorithm
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> res=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++) res.add(new HashSet<>());
        int[] indegree=new int[n];
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(q.size()!=0){
            int val=q.remove();
            for(int ele:adj.get(val)){
                res.get(ele).add(val);
                res.get(ele).addAll(res.get(val));
                indegree[ele]--;
                if(indegree[ele]==0) q.add(ele);
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list=new ArrayList<>(res.get(i));
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
    }
}