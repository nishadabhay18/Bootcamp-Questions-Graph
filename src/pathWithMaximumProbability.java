import java.util.*;
class pathWithMaximumProbability {
    // Same Diskstra's Application.
    public static class Pair implements Comparable<Pair>{
        int node;
        double prob;
        Pair(int node, double prob){
            this.node=node;
            this.prob=prob;
        }
        public int compareTo(Pair p){
            return Double.compare(p.prob,this.prob); // max-heap
        }
    }
    public static double maxProbability(int n, int[][] edges, double[] succProb, int src, int des) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
        double[] max=new double[n];
        Arrays.fill(max,0.0);
        max[src]=1.0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src,1.0));
        while(pq.size()!=0){
            Pair val=pq.remove();
            int node=val.node;
            double prob=val.prob;
            if(prob<max[node]) continue;
            if (node == des) return prob;
            for(Pair ele:adj.get(node)){
                int nextNode=ele.node;
                double nextProb=ele.prob;
                double data=prob*nextProb;
                if(data>max[nextNode]){
                    pq.add(new Pair(nextNode,data));
                    max[nextNode]=data;
                }
            }
        }
        return max[des];
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0;
        int end = 2;
        double ans=maxProbability(n,edges,succProb,start,end);
        System.out.println(ans);
    }
}
