import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class t7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (!st.hasMoreTokens()) return;

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int leftIdx = findFirstGreaterOrEqual(a, x);
            int rightIdx = findLastLessOrEqual(a, y);

            if (leftIdx == -1 || rightIdx == -1 || leftIdx > rightIdx) {
                out.println(0);
            } else {
                out.println(rightIdx - leftIdx + 1);
            }
        }
        
        out.flush();
    }

    static int findFirstGreaterOrEqual(int[] a, int x) {
        int left = 0, right = a.length - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= x) {
                ans = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    static int findLastLessOrEqual(int[] a, int y) {
        int left = 0, right = a.length - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] <= y) {
                ans = mid;
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}