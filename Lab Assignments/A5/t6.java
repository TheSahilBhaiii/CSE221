import java.io.*;
import java.util.*;
public class t6{
    static ArrayList<Integer> adj[];
    static int subtreeSize[];
    public static void main(String[] args) throws Exception{
        
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken());

        ArrayList<Integer> tempadj[]=new ArrayList[n+1];
        adj=tempadj;

        for(int i=0;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            while(!st.hasMoreTokens()){
            st=new StringTokenizer(bf.readLine());
            }
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }
        subtreeSize=new int[n+1];

        dfs(r,-1);
        
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        int q = Integer.parseInt(st.nextToken());

        for(int i=0;i<q;i++){
            while(!st.hasMoreTokens()){
                st=new StringTokenizer(bf.readLine());
            }
            int x=Integer.parseInt(st.nextToken());

            pw.println(subtreeSize[x]);
        }
        pw.flush();
    } 

    static int dfs(int current,int parent){
        int currentSize=1;

        for(int i=0;i<adj[current].size();i++){
        int neighbor=adj[current].get(i);

        if(neighbor!=parent){
            currentSize+=dfs(neighbor,current);
        }
        }
        subtreeSize[current]=currentSize;
        return currentSize;
    }
}

