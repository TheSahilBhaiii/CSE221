import java.io.*;
import java.util.*;
public class t4 {
    static ArrayList<Integer> adj[];
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());

        adj=new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(bf.readLine());

            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        int firstPass[]=bfs(1,n);
        int nodeA=firstPass[0];

        int secondPass[]=bfs(nodeA,n);
        int nodeB=secondPass[0];
        int diameterLength=secondPass[1];

        pw.println(diameterLength);
        pw.println(nodeA+" "+nodeB);
        pw.flush();
    }

        static int[] bfs(int startNode,int n){
            int dist[]=new int[n+1];
            Arrays.fill(dist,-1);

            Queue<Integer> q=new LinkedList<>();
            q.add(startNode);
            dist[startNode]=0;

            int farthestNode=startNode;
            int maxDist=0;

            while(!q.isEmpty()){
                int current=q.poll();

                if(dist[current]>maxDist){
                    maxDist=dist[current];
                    farthestNode=current;
                }

                for(int i=0;i<adj[current].size();i++){
                    int neighbor=adj[current].get(i);

                    if(dist[neighbor]==-1){
                        dist[neighbor]=dist[current]+1;
                        q.add(neighbor);
                    }
                }
            }
            return new int[]{farthestNode,maxDist};
        }
    }