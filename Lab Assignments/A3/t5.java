import java.io.*; 
import java.util.*;
public class t5{
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int t=Integer.parseInt(st.nextToken());

        for(int i=0;i<t;i++){
            st=new StringTokenizer(bf.readLine());

            long a=Long.parseLong(st.nextToken());
            long n=Long.parseLong(st.nextToken());
            long m=Long.parseLong(st.nextToken());

            long A[][]={{1,a%m},{0,a%m}};

            long result[][]=fastMatrix(A,n,m);

            pw.println(result[0][1]);
        }
        pw.flush();
    }

    public static long[][] multiply(long A[][],long B[][],long mod){
        long C[][]=new long[2][2];

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    long product=(A[i][k]*B[k][j])% mod;
                    C[i][j]=(C[i][j]+product)%mod;
                }
            }
        }
        return C;
    }
    public static long[][] fastMatrix(long base[][],long power, long mod){
        long result[][]={{1,0},{0,1}};

        while(power>0){
            if(power%2==1){
                result=multiply(result, base, mod);
            }
            base=multiply(base, base, mod);
            power=power/2;
        }
        return result;
    }
}
