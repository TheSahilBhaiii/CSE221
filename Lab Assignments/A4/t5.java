import java.io.*;
import java.util.*;
public class t5{
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());


        int n=Integer.parseInt(st.nextToken());//#Vertices
        int m=Integer.parseInt(st.nextToken());//#Edges

        int diff[]=new int[n+1];
        
        if(m>0){
            StringTokenizer stU = new StringTokenizer(bf.readLine());
            StringTokenizer stV = new StringTokenizer(bf.readLine());
            for(int i=0;i<m;i++){
                int u=Integer.parseInt(stU.nextToken());
                int v=Integer.parseInt(stV.nextToken());

                diff[u]--;
                diff[v]++;
            }
        }

        for(int i=1;i<=n;i++){
            pw.print(diff[i]+" ");
        }
        pw.flush();
    }
}