import java.io.*;
import java.util.*;
public class t5{
    public static void main(String[] args) throws Exception{
        
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        PrintWriter pw=new PrintWriter(System.out);

        String firstLine=bf.readLine();

        if(firstLine==null){
            return;
        }
        StringTokenizer st=new StringTokenizer(firstLine);

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());

        ArrayList<Integer> adj[]=new ArrayList[n+1];

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
            adj[v].add(u);
        }
        int compID[]=new int[n+1];
        int currentBadge=1;

        for(int i=1;i<=n;i++){
            if(compID[i]==0){

                Queue<Integer> queue=new LinkedList<>();

                queue.add(i);
                compID[i]=currentBadge;

                while(!queue.isEmpty()){
                    int current=queue.poll();

                    for(int j=0;j<adj[current].size();j++){
                        int neighbor=adj[current].get(j);

                        if(compID[neighbor]==0){
                            compID[neighbor]=currentBadge;
                            queue.add(neighbor);
                        }
                    }
                }
                currentBadge++;
            }
        }
        for(int i=0;i<q;i++){
            while(!st.hasMoreTokens()){
                st=new StringTokenizer(bf.readLine());
            }
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            if(compID[x]==compID[y]){
                pw.println("YES");
            }
            else{
                pw.println("NO");
            }
        }
        pw.flush();
    } 
}

