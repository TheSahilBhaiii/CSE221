import java.io.*;
import java.util.*;
public class Main{
    static PrintWriter pw;
    static ArrayList<Integer> adj[];
    static int state[];
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        
        adj=new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
        st=new StringTokenizer(bf.readLine());
        int u=Integer.parseInt(st.nextToken());
        int v=Integer.parseInt(st.nextToken());

        adj[u].add(v);
        
        }
        state=new int[n+1];
        boolean hasCycle=false;

        for(int i=1;i<=n;i++){
            if(state[i]==0){
                if(dfs(i)){
                    hasCycle=true;
                    break;
                }
            }
        }
        if(hasCycle){
            pw.println("YES");
        }
        else{
            pw.println("NO");
        }
        pw.println();
        pw.flush();
    }
     static boolean dfs(int current){
        state[current]=1;

        for(int i=0;i<adj[current].size();i++){
            int neighbor=adj[current].get(i);

            if(state[neighbor]==1){
                return true;
            }
            if(state[neighbor]==0){
                if(dfs(neighbor)){
                    return true;
                }
            }
        }
        state[current]=2;
        return false;
     }
    }