import java.io.*;
import java.util.*;
public class t4 {
    static long mod=1000000007;
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int t=Integer.parseInt(st.nextToken());

        for(int i=0;i<t;i++){
            st=new StringTokenizer(bf.readLine());

            long A[][]=new long[2][2];

            A[0][0]=Long.parseLong(st.nextToken());
            A[0][1]=Long.parseLong(st.nextToken());
            A[1][0]=Long.parseLong(st.nextToken());
            A[1][1]=Long.parseLong(st.nextToken());

            st=new StringTokenizer(bf.readLine());

            int X=Integer.parseInt(st.nextToken());

            long result[][]=fastmatrix(A,X);

            pw.println(result[0][0]+" "+result[0][1]);
            pw.println(result[1][0]+" "+result[1][1]);
        }
            pw.flush();
            
    }

    public static long[][] multiply(long A[][], long B[][]){
        long C[][]=new long[2][2];

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                long product=(A[i][k]*B[k][j])%mod;
                C[i][j]=(C[i][j]+product)%mod;
                }
            }
        }
        return C;
    }

    public static long[][] fastmatrix(long base[][],int power){
        long result[][]={{1,0},{0,1}};
        
        while(power>0){
            if(power%2==1){
                result=multiply(result,base);
            }
            base=multiply(base, base);
            power=power/2;
        }
        return result;
    }
}
