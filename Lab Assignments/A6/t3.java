import java.io.*;
import java.util.*;
public class t3 {
    static int dx[]={-2,-2,-1,-1,1,1,2,2};
    static int dy[]={-1,1,-2,2,-2,2,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(bf.readLine());
        int startX=Integer.parseInt(st.nextToken());
        int startY=Integer.parseInt(st.nextToken());
        int targetX=Integer.parseInt(st.nextToken());
        int targetY=Integer.parseInt(st.nextToken());

        int dist[][]=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            Arrays.fill(dist[i],-1);
        }

        Queue<int []> q=new LinkedList<>();

        q.add(new int[]{startX,startY});
        dist[startX][startY]=0;

        boolean found=false;

        while(!q.isEmpty()){
            int current[]=q.poll();
            int cx=current[0];
            int cy=current[1];

            if(cx==targetX && cy==targetY){
                pw.println(dist[cx][cy]);
                found=true;
                break;
            }
            for(int i=0;i<8;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx>=1 && nx<=n && ny>=1 && ny<=n){
                    if(dist[nx][ny]==-1){
                        dist[nx][ny]=dist[cx][cy]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        if(!found){
            pw.println("-1");
        }
        pw.flush();
    }
}
