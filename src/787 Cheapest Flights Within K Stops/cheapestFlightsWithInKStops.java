class cheapestFlightsWithinKStops {
    public static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static class Triplet implements Comparable<Triplet>{
        int node, dist, stops;
        Triplet(int node, int dist, int stops){
            this.node = node;
            this.dist = dist;
            this.stops = stops;
        }
        public int compareTo(Triplet t){
            // return this.dist-t.dist;
            if(this.stops == t.stops) return this.dist - t.dist;
            return this.stops - t.stops;  //sort on the basis of stops
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i<flights.length; i++){
            int u = flights[i][0], v = flights[i][1], wt = flights[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        int cost[] = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(src, 0, 0));
        while(pq.size() != 0){
            Triplet val = pq.remove();
            int node = val.node, dist = val.dist, stops = val.stops;
            // if(stops==k+1 && node==dst) return dist;
            if(stops == k+1) continue;
            for(Pair ele : adj.get(node)){
                int newNode = ele.x, newDist = ele.y;
                if(newDist > cost[newNode]) continue;
                int sum = dist + newDist;
                if(sum < cost[newNode]){
                    pq.add(new Triplet(newNode, sum, stops+1));
                    cost[newNode] = sum;
                }
            }
        }
        return (cost[dst] == Integer.MAX_VALUE) ? -1 : cost[dst];
    }
}
