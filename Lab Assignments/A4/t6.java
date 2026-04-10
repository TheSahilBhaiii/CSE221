import java.io.*;
import java.util.*;
public class t6{
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());//size of board
        st=new StringTokenizer(bf.readLine());
        //start postion of king (coordinates)
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());

        ArrayList<String> moves=new ArrayList<>();
        
        
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if(i==0 &&j==0){
                        continue;
                    }
                    int nx=x+i;
                    int ny=y+j;
                    
                    if(nx>=1 && nx<=n && ny>=1 && ny<=n){
                    moves.add(nx+" "+ny);
                    }
                }
            }
            pw.println(moves.size());
        

        for(int i=0;i<moves.size();i++){
            pw.println(moves.get(i));
        }
        pw.flush();
    }
}