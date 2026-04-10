import java.io.*;
import java.util.*;
public class t4{
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());


        int n=Integer.parseInt(st.nextToken());//#vertices
        int m=Integer.parseInt(st.nextToken());//#Edges

        int degree[]=new int[n+1]; 
        
        if(m>0){
            StringTokenizer stU = new StringTokenizer(bf.readLine());
            StringTokenizer stV = new StringTokenizer(bf.readLine());
            for(int i=0;i<m;i++){
                int u=Integer.parseInt(stU.nextToken());
                int v=Integer.parseInt(stV.nextToken());

                degree[u]++;
                degree[v]++;
            }
        }

        int oddCount=0;

        for(int i=1;i<=n;i++){
            if(degree[i]%2!=0){
                oddCount++;
            }
        }
        if(oddCount==0 || oddCount==2){
            pw.println("YES");
        }
        else{
            pw.println("NO");
        }
        pw.flush();
    }
}