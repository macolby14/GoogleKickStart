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
        int out = 0;
        for(int i=1; i<=Math.min(L,R);i++){
            out += i;
        }
       /*
       () - case 2
       ()() - case 3 (()) - case 2
       ()()() - 3 + 2 + 1
       ()()()() - 4 + 3 + 2 + 1
        - Take min of L and R

        */
        System.out.println(out);
    }
}