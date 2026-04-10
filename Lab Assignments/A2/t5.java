import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class t5 {
    public static void main(String[] args) throws IOException {
        // Fast I/O for large inputs
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (!st.hasMoreTokens()) return;

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken()); // K can be up to 10^9

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        long currentSum = 0; // Use long to prevent overflow!
        int maxLength = 0;

        // The Sliding Window
        for (int right = 0; right < n; right++) {
            currentSum += arr[right]; // 1. Expand window to the right

            // 2. If the window is too heavy, shrink it from the left
            while (currentSum > k && left <= right) {
                currentSum -= arr[left];
                left++;
            }

            // 3. Keep track of the maximum valid window size seen
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Output the result
        System.out.println(maxLength);
    }
}