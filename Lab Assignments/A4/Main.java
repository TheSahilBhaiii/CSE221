import java.io.*;
import java.util.*;
public class t7{
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());//#rows
        int m=Integer.parseInt(st.nextToken());//#collums
        int k=Integer.parseInt(st.nextToken());//#knights

        boolean board[][]=new boolean[n+1][m+1];

        int dx[]={-2,-2,-1,-1,1,1,2,2};
        int dy[]={-1,1,-2,2,-2,2,-1,1};
        
        boolean collisionFound=false;
 
            for(int i=0;i<k;i++){         //loop till K
                st=new StringTokenizer(bf.readLine());

                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
            
            if(collisionFound){
                continue;
            }
                for(int dir=0;dir<8;dir++){
                    int nx=x+dx[dir];
                    int ny=y+dy[dir];

                    if(nx>=1 && nx<=n && ny>=1 && ny<=m){
                        if(board[nx][ny]){
                            collisionFound=true;
                            break;
                        }
                    }
                }
                    board[x][y]=true;
            }
        if(collisionFound){
            pw.println("YES");
        }
        else{
            pw.println("NO");
        }
        pw.flush();
    }
}