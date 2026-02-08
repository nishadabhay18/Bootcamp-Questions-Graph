import java.util.*;
class DijkstarAlgorithm {
    public static class Pair implements Comparable<Pair>{
        int node,dist;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
        public int compareTo(Pair p){
            return this.dist-p.dist;
        }
    }
    public static int[] dijkstra(int V, int[][] edges, int src) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0],edge[2]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int[] cost=new int[V];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        pq.add(new Pair(src,0));
        while(pq.size()!=0){
            Pair val=pq.remove();
            int node=val.node;
            int weig=val.dist;
            if(weig>cost[node]) continue;
            for(Pair ele:adj.get(node)){
                int nextNode=ele.node;
                int nextWeig=ele.dist;
                int sum=weig+nextWeig;
                if(sum<cost[nextNode]){
                    cost[nextNode]=sum;
                    pq.add(new Pair(nextNode,sum));
                }
            }
        }
        return cost;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int[][] edges=new int[V][V];
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[0].length;j++){
                edges[i][j]=sc.nextInt();
            }
        }
        int src=sc.nextInt();
        int[] ans=dijkstra(V,edges,src);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]+" ");
        }
    }
}