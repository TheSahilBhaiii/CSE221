import java.util.Scanner;

class Train {
    String originalLine;
    String name;
    String time;

    public Train(String line) {
        this.originalLine = line;
        String[] parts = line.split(" ");
        this.name = parts[0];
        this.time = parts[parts.length - 1];
    }
}

public class t8{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int N = sc.nextInt();
            sc.nextLine(); 
            
            Train[] trains = new Train[N];
            for (int i = 0; i < N; i++) {
                String line = sc.nextLine();
                trains[i] = new Train(line);
            }

            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < N - 1 - i; j++) {
                    
                   
                    if (shouldSwap(trains[j], trains[j+1])) {
                        Train temp = trains[j];
                        trains[j] = trains[j+1];
                        trains[j+1] = temp;
                    }
                }
            }

            
            for (int i = 0; i < N; i++) {
                System.out.println(trains[i].originalLine);
            }
        }
    }

    
    public static boolean shouldSwap(Train t1, Train t2) {
        int nameCompare = compareNames(t1.name, t2.name);
        
        if (nameCompare > 0) {
            return true; 
        } 
        else if (nameCompare < 0) {
            return false; 
        }
        
        if (t1.time.compareTo(t2.time) < 0) {
            return true; 
        }

        return false;
    }
    public static int compareNames(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int minLen = Math.min(len1, len2);

        for (int k = 0; k < minLen; k++) {
            char c1 = s1.charAt(k);
            char c2 = s2.charAt(k); 

            if (c1 != c2) {
                int val1 = getCharValue(c1);
                int val2 = getCharValue(c2);
                return val1 - val2; 
            }
        }
        
        
        return len1 - len2;
    }
    public static int getCharValue(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a'; 
        } else {
            return c - 'A' + 26; 
        }
    }
}