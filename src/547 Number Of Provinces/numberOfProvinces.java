class numberOfProvinces {
    // By BFS
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean isVisited[] = new boolean[n];
        for(int i = 0; i<n; i++){
            if(isVisited[i] == false){
                bfs(isConnected, i, isVisited);
                count++;
            }
        }
        return count;
    }
    public void bfs(int[][] isConnected, int i, boolean isVisited[]){
        int n = isConnected.length;
        isVisited[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size() > 0){
            int front = q.remove();
            for(int j = 0; j<n; j++){
                if(isConnected[front][j] == 1 && isVisited[j] == false){
                    q.add(j);
                    isVisited[j] = true;
                }
            }
        }
    }

    // By DSU
    public static int[] parent;
    public static int[] size;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i = 1; i<=n; i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i != j && isConnected[i][j] == 1) union(i+1, j+1);
            }
        }
        int count = 0;
        for(int i = 1; i<=n; i++){
            if(parent[i] == i) count++;
        }
        return count;
    }
    public void union(int x,int y){
        int px = findParent(x);
        int py = findParent(y);
        if(px != py){
            if(size[px] > size[py]){
                parent[py] = px;
                size[px] += size[py];
            }else{
                parent[px] = py;
                size[py] += size[px];
            }
        }
    }
    public int findParent(int curr){
        int pc = parent[curr];
        if(pc == curr) return curr;
        return parent[curr] = findParent(pc);// make sure parent is pointing
    }
}
