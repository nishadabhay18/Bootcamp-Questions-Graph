class keysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean []isVisited = new boolean[n];
        isVisited[0] = true;
        bfs(rooms, isVisited);
        for(boolean val : isVisited){
            if(val == false) return false;
        }
        return true;
    }
    public void bfs(List<List<Integer>> rooms, boolean []isVisited){
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        isVisited[0] = true;
        while(q.size() != 0){
            int front = q.remove();
            for(int ele : rooms.get(front)){
                if(isVisited[ele] == false){
                    q.add(ele);
                    isVisited[ele] = true;
                }
            }
        }
    }
}
