import java.util.*;
class allPathsFromSourceToTarget {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        ans.add(0);
        dfs(0,graph, ans, res);
        return res;
    }
    public static void dfs(int val, int[][] graph, List<Integer> ans, List<List<Integer>> res){
        if(val==graph.length-1){
            res.add(new ArrayList<>(ans));
        }
        for(int ele:graph[val]){
            ans.add(ele);
            dfs(ele,graph,ans,res);
            ans.remove(ans.size()-1);
        }
    }
    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        List<List<Integer>> ans=allPathsSourceTarget(graph);
        for (List<Integer> path : ans) {
            System.out.println(path);
        }
    }
}