import java.util.*;
class findEventualSafeStates {
    // Reverse Graph Edges
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int edge:graph[i]){
                adj.get(edge).add(i);
                indegree[i]++;
            }
        }
        // Kahn's Algorithm
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(q.size()!=0){
            int size=q.size();
            int val=q.remove();
            ans.add(val);
            for(int ele:adj.get(val)){
                indegree[ele]--;
                if(indegree[ele]==0){
                    q.add(ele);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
        int[][] graph={{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> ans=eventualSafeNodes(graph);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i)+" ");
        }
    }
}
