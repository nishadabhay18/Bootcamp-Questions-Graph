class isGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++) {
            if(color[i]==-1) {
                if(!bfs(graph, color, i)) return false;
            }
        }
        return true;
    }
    public boolean bfs(int[][] graph, int[] color, int start) {
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        color[start]=0;
        while(!q.isEmpty()) {
            int front=q.poll();
            for(int ele: graph[front]) {
                if(color[ele]==-1) {
                    color[ele]=1-color[front];
                    q.add(ele);
                }else if(color[ele]==color[front]) return false;
            }
        }
        return true;
    }
}