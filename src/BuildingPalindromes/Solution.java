package BuildingPalindromes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    static File file = new File("/home/mark/IdeaProjects/GoogleKickStart/src/BuildingPalindromes/input.txt");
    static Scanner inputObject;

    static {
        try {
            inputObject = new Scanner(file);
        } catch (FileNotFoundException e) {
            inputObject = new Scanner(System.in);
        }
    }

    public static void main(String args[]) {
        // Declare integer 'T' (Number of Test Cases)
        int T;
        // & read it from Standard Input
        T = inputObject.nextInt();
        // Loop through the number of Test Cases [1, T]
        for (int test_case = 1; test_case <= T; ++test_case) {
            // Print the Test Case Number to Standard Output
            System.out.print("Case #" + test_case + ": ");
            // Call the 'solve()' function to answer each test
            solve();
        }
        // Close the Object for Input
        inputObject.close();
    }

    static int[][] prefix;

    static void solve() {
        int N = inputObject.nextInt();
        int Q = inputObject.nextInt();
        prefix = new int[N+1][26];
        inputObject.nextLine();
        String s = inputObject.nextLine();

        for(int i = 1; i <= N; i++){
            prefix[i] = Arrays.copyOf(prefix[i - 1],prefix[i].length);
            prefix[i][s.charAt(i-1)-'A']++;
        }


        int out = 0;
        for(int i=0; i<Q; i++){
            int L = inputObject.nextInt();
            int R = inputObject.nextInt();
            if(isPalindrome(prefix[L - 1],prefix[R])){
                out++;
            }

        }

        System.out.println(out);
    }

    static boolean isPalindrome(int[] p1, int[] p2){
        boolean usedOdd = false;
        for(int i=0;i<p2.length;i++){
            if((p2[i] - p1[i]) % 2 != 0 && usedOdd) {
                return false;
            }
            else if((p2[i] - p1[i]) % 2 != 0){
                usedOdd = true;
            }
        }
        return true;
    }
}