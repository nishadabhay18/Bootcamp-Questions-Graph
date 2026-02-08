import java.util.*;
class bipartitionPossible {
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] edge:dislikes){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] color=new int[n+1];
        Arrays.fill(color,-1);
        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(bfs(adj,color,i)==false) return false;
            }
        }
        return true;
    }
    public static boolean bfs(List<List<Integer>> adj, int[] color, int i){
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        color[i]=0;
        while(q.size()!=0){
            int val=q.remove();
            for(int ele:adj.get(val)){
                if(color[ele]==-1){
                    q.add(ele);
                    color[ele]=1-color[val];
                }
                else if(color[ele]==color[val]) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][]dislikes = {{1,2},{1,3},{2,4}};
        System.out.println(possibleBipartition(n,dislikes));
    }
}