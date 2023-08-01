import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        for(int tc = 1 ; tc <= t; tc++) {
             
            String clap = "";
            clap = sc.next();
            int[] arr = new int[clap.length()];
             
            for(int i = 0; i < clap.length(); i++) {
                arr[i] = clap.charAt(i) - '0';
            }
 
            int sum = 0, ans = 0;
            for(int i = 0 ; i < arr.length; i++) {
                if(sum < i) {
                    ans += i-sum;
                    sum += i-sum;       
                }
                sum += arr[i];
            }
            System.out.println("#" + tc + " " + ans);
        }
         
    }
 
}