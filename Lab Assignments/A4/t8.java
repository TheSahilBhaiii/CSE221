import java.io.*;
import java.util.*;
public class t8{
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken()); //#vertices
        int q=Integer.parseInt(st.nextToken()); //#queries
        

        ArrayList<Integer>[] adj = new ArrayList[n + 1];

            for(int i=1;i<=n;i++){
                adj[i]=new ArrayList<>();

                for(int j=1;j<=n;j++){
                    if(i!=j && gcd(i,j)==1){
                        adj[i].add(j);
                    }
                }
            }
            for(int i=0;i<q;i++){
                st=new StringTokenizer(bf.readLine());

                int x=Integer.parseInt(st.nextToken());//Node
                int k=Integer.parseInt(st.nextToken());//Kth smallest to find

                if(k<= adj[x].size()){
                    pw.println(adj[x].get(k-1));
                }
                else{
                    pw.println("-1");
                }
            }
            pw.flush();
        }
        static int gcd(int a,int b){
            while(b!=0){
                int temp=b;
                b=a%b;
                a=temp;
            }
            return a;
        }
    }