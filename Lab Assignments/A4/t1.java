import java.io.*;
import java.util.*;
public class t1{
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());

        int matrix2D[][]=new int[n+1][n+1];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int row=Integer.parseInt(st.nextToken());
            int col=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());

            matrix2D[row][col]=weight;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                pw.print(matrix2D[i][j]+" ");
            }
            pw.println();
        }
        pw.flush();
    }
}