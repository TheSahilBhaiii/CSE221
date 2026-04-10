import java.util.Scanner;
public class t5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();

        int arr[]=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        
        int moves[]=new int[N*N];
        int mIndex=0;


        for(int i=0;i<N;i++){
            for(int j=0;j<N-2;j++){
                if(arr[j]>arr[j+2]){
                    int temp=arr[j];
                    arr[j]=arr[j+2];
                    arr[j+2]=temp;
                    
                    moves[mIndex]=j+1;
                    mIndex++;
                    moves[mIndex]=j+3;
                    mIndex++;
                }
            }
        }
        boolean flag=true;

        for(int i=0;i<N-1;i++){
            if(arr[i]>arr[i+1]){
            flag=false;
            break;
        }
    }

        if(flag==true){
            System.out.println("YES");
            System.out.println(mIndex/2);

            for(int i=0;i<mIndex;i+=2){
            System.out.println(moves[i]+" "+moves[i+1]);
            }
        }
        else{
            System.out.println("NO");
        }
        }
    }
