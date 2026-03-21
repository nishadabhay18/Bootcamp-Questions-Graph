class shortestCycleInAGraph {
    // BFS
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int minCycle=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int[] dist=new int[n];
            Arrays.fill(dist,-1);
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            dist[i]=0;
            while(q.size()!=0){
                int val=q.remove();
                for(int ele:adj.get(val)){
                    if(dist[ele]==-1){
                        dist[ele]=dist[val]+1;
                        q.add(ele);
                    }
                    else if(dist[ele]>=dist[val]) minCycle=Math.min(minCycle,dist[ele]+dist[val]+1);
                }
            }
        }
        return (minCycle==Integer.MAX_VALUE)? -1:minCycle;
    }
}