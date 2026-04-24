import java.io.*;
import java.util.*;
public class t2 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());
        while(!st.hasMoreTokens()){
        st=new StringTokenizer(bf.readLine());
}
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        ArrayList<Integer> adj[]=new ArrayList[n+1];

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
        adj[v].add(u);
        }

        int color[]=new int[n+1];
        Arrays.fill(color,-1);
        int maxTotal=0;

        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                int count0=0;
                int count1=0;

                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                color[i]=0;

                while(!q.isEmpty()){
                    int current=q.poll();

                    if(color[current]==0){
                        count0++;
                    }
                    else{
                        count1++;
                    }

                    for(int j=0;j<adj[current].size();j++){
                        int neighbor=adj[current].get(j);

                        if(color[neighbor]==-1){
                        color[neighbor]=1-color[current];
                        q.add(neighbor);
                        }
                    }
                }
                maxTotal+= Math.max(count0, count1);
            }
        }
        pw.println(maxTotal);
        pw.flush();
    }
    }

