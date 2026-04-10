import java.io.*;
import java.util.*;
public class t3{
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());

        int matrix2D[][]=new int[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            int k=Integer.parseInt(st.nextToken()); //Outgoing edges

            for(int j=0;j<k;j++){
                int neighbour=Integer.parseInt(st.nextToken());
                matrix2D[i][neighbour]=1;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pw.print(matrix2D[i][j]+" ");
            }
            pw.println();
        }
        pw.flush();
    }
}