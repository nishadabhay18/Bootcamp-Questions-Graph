import java.util.*;
class networkDelayTime {
    // Diskstra's Application
    public static class Pair implements Comparable<Pair>{
        int node,signal;
        Pair(int node,int signal){
            this.node=node;
            this.signal=signal;
        }
        public int compareTo(Pair p){
            return this.signal-p.signal;
        }
    }
    public static int networkDelayTime(int[][] times, int V, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0], v=times[i][1], w=times[i][2];
            adj.get(u).add(new Pair(v,w));
            // adj.get(v).add(new Pair(u,w)); only for undirected
        }
        int[] time=new int[V+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(k,0));
        while(pq.size()!=0){
            Pair val=pq.remove();
            int node=val.node, signal=val.signal;
            if(signal>time[node]) continue;
            for(Pair ele:adj.get(node)){
                int newNode=ele.node, newSignal=ele.signal;
                int sum=signal+newSignal;
                if(sum<time[newNode]){
                    pq.add(new Pair(newNode,sum));
                    time[newNode]=sum;
                }
            }
        }
        int maxTime=Integer.MIN_VALUE;
        for(int i=1;i<=V;i++){
            if(time[i]>maxTime) maxTime=time[i];
        }
        return (maxTime==Integer.MAX_VALUE)? -1:maxTime;
    }
    public static void main(String[] args) {
        int[][]times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        System.out.println(networkDelayTime(times,n,k));
    }
}