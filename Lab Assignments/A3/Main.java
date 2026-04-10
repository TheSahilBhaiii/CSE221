import java.io.*;
import java.util.*;

public class Main {
    // Make these global so our recursive method can access them easily
    static PrintWriter pw;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Start the recursive printing process from index 0 to n - 1
        printOptimalOrder(0, n - 1);

        // Print a final newline and flush the output bucket
        pw.println();
        pw.flush();
    }

    // The Recursive Divide and Conquer Method
    public static void printOptimalOrder(int left, int right) {
        // Base case: If the left boundary crosses the right, we've processed this chunk
        if (left > right) {
            return;
        }

        // 1. Find the middle element of the current segment
        // We use left + (right - left) / 2 to prevent integer overflow on massive arrays
        int mid = left + (right - left) / 2;

        // 2. "Insert" it by printing it immediately
        pw.print(arr[mid] + " ");

        // 3. Recursively process the left half
        printOptimalOrder(left, mid - 1);

        // 4. Recursively process the right half
        printOptimalOrder(mid + 1, right);
    }
}