import java.io.*;
import java.util.*;
public class t1 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int t=Integer.parseInt(st.nextToken());

        while(t-- >0){
            while(!st.hasMoreTokens()){
            st=new StringTokenizer(bf.readLine());
            }
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());

            ArrayList<Integer> adj[]=new ArrayList[n+1];
            int inDegree[]=new int[n+1];

            for(int i=1;i<=n;i++){
                adj[i]=new ArrayList<>();
            }

            for(int i=0;i<m;i++){
                while(!st.hasMoreTokens()){
                st=new StringTokenizer(bf.readLine());
                }

                int u=Integer.parseInt(st.nextToken());
                int v=Integer.parseInt(st.nextToken());

                adj[u].add(v);
                inDegree[v]++;    
            }

            Queue<Integer> q=new LinkedList<>();

            for(int i=1;i<=n;i++){
                if(inDegree[i]==0){
                    q.add(i);                
                }
            }
            ArrayList<Integer> Order=new ArrayList<>();

            while(!q.isEmpty()){
                int current=q.poll();
                Order.add(current);

                for(int i=0;i<adj[current].size();i++){
                    int neighbor=adj[current].get(i);
                    inDegree[neighbor]--;

                    if(inDegree[neighbor]==0){
                        q.add(neighbor);
                    }
                }
            }

            if(Order.size()==n){
                for(int i=0;i<n;i++){
                    pw.print(Order.get(i)+" ");
                }
                pw.println();
            }
            else{
                pw.println("-1");
            }
        }
        pw.flush();
    }
}
