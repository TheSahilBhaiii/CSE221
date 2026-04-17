import java.io.*;
import java.util.*;
public class t1 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        ArrayList<Integer> adj[]=new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());

            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }
        for(int i=1;i<=n;i++){
            Collections.sort(adj[i]);
        }
        int color[]=new int[n+1];
        Queue<Integer> q=new LinkedList<>();

        q.add(1);
        color[1]=1;

        while(!q.isEmpty()){
            int current=q.poll();
            pw.print(current+" ");

            for(int i=0;i<adj[current].size();i++){
                int neighbor=adj[current].get(i);

            if(color[neighbor]==0){
                color[neighbor]=1;
                q.add(neighbor);
            }
        }
        }
        pw.println();
        pw.flush();
    }
}
