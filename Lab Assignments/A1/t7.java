import java.util.Scanner;
public class t7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        
        for(int k=0;k<N;k++){
            int m=sc.nextInt();
            int id[]=new int[m];
            int marks[]=new int[m];
            int sortedId[]=new int[m];
            int sortedmarks[]=new int[m];

            for(int i=0;i<m;i++){
                id[i]=sc.nextInt();
                sortedId[i]=id[i];
            }
            for(int i=0;i<m;i++){
                marks[i]=sc.nextInt();
                sortedmarks[i]=marks[i];
            }

            for(int i=0;i<m;i++){
                for(int j=0;j<m-1;j++){
                     boolean condition1=sortedmarks[j]<sortedmarks[j+1];
                     boolean condition2 = (sortedmarks[j] == sortedmarks[j+1]) && (sortedId[j] > sortedId[j+1]);

                if(condition1 || condition2){
                    int tempM=sortedmarks[j];
                    sortedmarks[j]=sortedmarks[j+1];
                    sortedmarks[j+1]=tempM;
                        
                    int tempI=sortedId[j];
                    sortedId[j]=sortedId[j+1];
                    sortedId[j+1]=tempI;
                    }
                }
            }
            int swapCount=0;
            for(int i=0;i<m;i++){
            int targetStudent=sortedId[i];
            
            if(id[i]!=targetStudent){
                swapCount++;
            for(int j=i+1;j<m;j++){
                if(id[j]==targetStudent){
                    int tempId=id[i];
                    id[i]=id[j];
                    id[j]=tempId;

                    int tempMarks=marks[i];
                    marks[i]=marks[j];
                    marks[j]=tempMarks;
                    break;
            } 
        }
    }
}
            System.out.println("Minimum swaps: "+swapCount);
            for (int i = 0; i < m; i++) {
                    System.out.println("ID: " + sortedId[i] + " Mark: " + sortedmarks[i]);
                }
}
    }
}

