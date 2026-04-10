import java.util.Scanner;
public class t1 {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    
    int N=sc.nextInt();
    
    for(int i=0;i<N;i++){
        int M=sc.nextInt();
        if(M%2==0){
            System.out.println(M+" is an Even number.");
        }
        else{
             System.out.println(M+" is an Odd number.");
        }
    }
}
}
