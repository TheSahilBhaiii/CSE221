import java.io.*;
import java.util.*;
public class t7{
    static ArrayList<Integer> adj[];
    static int state[];
    public static void main(String[] args) throws Exception{
        
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        PrintWriter pw=new PrintWriter(System.out);

        String firstLine =bf.readLine();
        if(firstLine==null)return;

        StringTokenizer st=new StringTokenizer(firstLine);

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        ArrayList<Integer> tempadj[]=new ArrayList[n+1];
        adj=tempadj;

        for(int i=0;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            while(!st.hasMoreTokens()){
            st=new StringTokenizer(bf.readLine());
            }
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
