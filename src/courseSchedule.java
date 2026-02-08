import java.util.*;
class courseSchedule {
    // Directed cycle dectection
    // subject[3,2].
    // if want to finish subject 3 first complete subject 2 so we gofrom 2 to 3.
    public static boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] indegree=new int[n];
        for(int i=0;i<pre.length;i++){
            int a=pre[i][0], b=pre[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(q.size()!=0){
            int val=q.remove();
            ans.add(val);
            for(int ele:adj.get(val)){
                indegree[ele]--;
                if(indegree[ele]==0){
                    q.add(ele);
                }
            }
        }
        return (ans.size()==n)? true:false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numCourses=sc.nextInt();
        int pre=sc.nextInt();
        int[][] prerequisites=new int[pre][2];
        for(int i=0;i<prerequisites.length;i++){
            for(int j=0;j<prerequisites[0].length;j++){
                prerequisites[i][j]=sc.nextInt();
            }
        }
        System.out.println(canFinish(numCourses,prerequisites));
    }
}