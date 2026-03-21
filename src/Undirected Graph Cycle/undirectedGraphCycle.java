class undirectedGraphCycle {
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
             List<Integer> list=new ArrayList<>();
             adj.add(list);
         }
         for(int[] edge:edges){
             adj.get(edge[0]).add(edge[1]);
             adj.get(edge[1]).add(edge[0]);
         }
         boolean[] isVisited=new boolean[V];
         Queue<Pair> q=new LinkedList<>();
         for(int i=0;i<V;i++){
             if(isVisited[i]==false){
                 int st=i;
                 q.add(new Pair(st,-1));
                 isVisited[st]=true;
                 while(q.size()!=0){
                     Pair val=q.remove();
                     int v1=val.x;
                     int v2=val.y;
                     for(int j:adj.get(v1)){
                         if(isVisited[j]==false){
                             q.add(new Pair(j,v1));
                             isVisited[j]=true;
                         }
                         else if(isVisited[j]==true && j!=v2){ //marked but not parent
                             return true;
                         }
                     }
                 }
             }
         }
         return false;
     }

    public boolean isCycle(int V, int[][]edges){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            List<Integer> list=new ArrayList<>();
            adj.add(list);
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] isVisited=new boolean[V];
        for(int i=0;i<V;i++){
            if(isVisited[i]==true) continue;
            if(dfs(i, -1,isVisited, adj)) return true;
        }
        return false;
    }
    public boolean dfs(int i, int j, boolean[] isVisited, List<List<Integer>> adj){
        isVisited[i]=true;
        for(int ele:adj.get(i)){
            if(isVisited[ele]==false){
                if(dfs(ele, i, isVisited,adj)) return true;
            }else if(ele!=j) return true;
        }
        return false;
    }
}