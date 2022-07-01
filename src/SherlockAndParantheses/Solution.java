package SherlockAndParantheses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    static File file = new File("/home/mark/IdeaProjects/GoogleKickStart/src/SherlockAndParantheses/input.txt");
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

    static void solve() {
        int L = inputObject.nextInt();
        int R = inputObject.nextInt();
        int N = Math.min(L, R);
        int out = N * (N + 1) / 2;
        System.out.println(out);
    }
}