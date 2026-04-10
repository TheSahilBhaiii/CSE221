import java.io.*;
import java.util.*;
public class t3 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        long a=Long.parseLong(st.nextToken());
        long b=Long.parseLong(st.nextToken());
        long mod=107;

        long ans=fastpower(a,b,mod);

        pw.println(ans);
        pw.flush();
    }

    public static long fastpower(long base,long power,long mod){
    long res=1;

    base=base%mod;

    while(power>0){
        if(power%2==1){
            res=(res*base)%mod;
        }
        base=(base*base)%mod;
        power=power/2;
    }
    return res;
    }
}
