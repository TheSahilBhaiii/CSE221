import java.util.Scanner;
public class t3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        for(int i=0;i<n;i++){
            long x=sc.nextLong();

            long sum= (x*(x+1))/2;
            System.out.println(sum);
        }
    }
    
}
