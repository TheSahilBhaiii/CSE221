import java.io.*;
import java.util.*;
public class t8{
    static char grid[][];
    static boolean visited[][];
    static int R,H;

    static int dr[]={-1,1,0,0};
    static int dc[]={0,0,-1,1};
    public static void main(String[] args) throws Exception{
        
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        PrintWriter pw=new PrintWriter(System.out);

        String firstLine =bf.readLine();
        if(firstLine==null)return;

        StringTokenizer st=new StringTokenizer(firstLine);

        R=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());

        grid=new char[R][H];
        visited=new boolean[R][H];

        for(int i=0;i<R;i++){
            grid[i]=bf.readLine().toCharArray();
        }

        int maxDiamonds=0;

        
        for(int i=0;i<R;i++){
            for(int j=0;j<H;j++){
                if(grid[i][j]!='#' && !visited[i][j]){
                int currentIslandDiamonds=dfs(i,j);
                maxDiamonds=Math.max(maxDiamonds,currentIslandDiamonds);
                }
            }
        }
        pw.println(maxDiamonds);
        pw.flush();
        }
        
    static int dfs(int r,int c){
        visited[r][c]=true;

        int diamondCount=0;
        if(grid[r][c]=='D'){
            diamondCount=1;
        }
        for(int i=0;i<4;i++){
            int nextR=r+dr[i];
            int nextC=c+dc[i];

            if(nextR>=0 && nextR<R && nextC>=0 && nextC<H){
               if(grid[nextR][nextC]!='#' && !visited[nextR][nextC]){
                diamondCount+=dfs(nextR,nextC);
               }
            }
        }
        return diamondCount;
    }
}