import java.io.*;
import java.util.*;
public class t2{
    
static class Edge{
    int v;
    int w;

    public Edge(int v,int w){
        this.v=v;
        this.w=w;
    }
}


    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(bf.readLine());

        int u[]=new int[m];
        int v[]=new int[m];
        int w[]=new int[m];

        if(m>0){
            for(int i=0;i<m;i++){
            u[i]=Integer.parseInt(st.nextToken());
            }
            st=new StringTokenizer(bf.readLine());
            for(int i=0;i<m;i++){
            v[i]=Integer.parseInt(st.nextToken());
            }
            st=new StringTokenizer(bf.readLine());
            for(int i=0;i<m;i++){
            w[i]=Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Edge> adj[]=new ArrayList[n+1];

        for(int i=1;i<=n;i++){
        adj[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            adj[u[i]].add(new Edge(v[i],w[i]));
        }

        for(int i=1;i<=n;i++){
            pw.print(i+":");

            for(int j=0;j<adj[i].size();j++){
                Edge currentEdge=adj[i].get(j);

                pw.print(" ("+currentEdge.v+","+currentEdge.w+")");
            }
            pw.println();
        }
        pw.flush();

    }
}