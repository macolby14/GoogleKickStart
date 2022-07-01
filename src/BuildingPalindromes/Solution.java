package BuildingPalindromes;

import java.io.File;
import java.io.FileNotFoundException;
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

    static boolean[][] cache;

    static void solve() {
        int N = inputObject.nextInt();
        int Q = inputObject.nextInt();
        cache = new boolean[N][N];
        inputObject.nextLine();
        String s = inputObject.nextLine();

        Map<Character, Integer> freq = new HashMap<>();
        int runningCt = 0;
        for(int i = 0; i<s.length(); i++){
           freq = new HashMap<>();

            for(int j=i; j<s.length(); j++){
                int existingCt = freq.getOrDefault(s.charAt(j),0);
                freq.put(s.charAt(j),existingCt + 1);
                cache[i][j] = isPalindrom(freq);
            }
        }

        int out = 0;
        for(int i=0; i<Q; i++){
            int L = inputObject.nextInt() - 1;
            int R = inputObject.nextInt() - 1;
            if(cache[L][R]) out++;
//            if(canBePalindrome(s.substring(L,R + 1))) out++;
        }

        System.out.println(out);
    }

    static boolean isPalindrom(Map<Character, Integer> freq){
        boolean seenOdd = false;
        for(int i: freq.values()){
            if(i % 2 != 0 && seenOdd) return false;
            else if(i%2 != 0) seenOdd = true;
        }
        return true;
    }

    static boolean canBePalindrome(String s){
        Map<Character, Integer> freq = new HashMap<>();
        System.out.println(s);
        for(int i = 0; i < s.length(); i++){
            int existing = freq.getOrDefault(s.charAt(i),0);
            freq.put(s.charAt(i),existing + 1);
        }

        boolean seenOdd = false;
        for(int i: freq.values()){
            if(i % 2 != 0 && seenOdd) return false;
            else if(i%2 != 0) seenOdd = true;
        }

        System.out.println(freq);

        return true;
    }
}