package IrregularExpressions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static File file = new File("/home/mark/IdeaProjects/GoogleKickStart/src/IrregularExpressions/input.txt");
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
        inputObject.nextLine();
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

    static char[] vowels = {'a','e','i','o','u'};

    static void solve() {
        String inp = inputObject.nextLine();
        boolean spell = false;

        int l = 0; int r = 0;
        int vowelCt = 0;
        while(r < inp.length()){
            while(l < inp.length() && !isVowel(inp.charAt(l))){
                l++;
                if(r < l){
                    r=l;
                }
            }
            if(l == inp.length()){
                break;
            }
            if(isVowel(inp.charAt(r))){
                vowelCt++;
            }
            if(vowelCt == 2){
                int lastStart = findLast(l, r, inp);
                if(lastStart != -1 && containsVowel(inp.substring(r+1, lastStart))){
                    spell = true;
                    break;
                }else{
                    while(vowelCt == 2) {
                        if (isVowel(inp.charAt(l))) {
                            vowelCt--;
                        }
                        l++;
                    }
                }
            }
            r++;
        }

        String out = "Nothing.";
        if(spell){
            out = "Spell!";
        }
        System.out.println(out);
    }

    static boolean isVowel(char c){
        for(char v: vowels){
            if(c == v) return true;
        }

        return false;
    }

    static int findLast(int l, int r, String s){
        int tT = r;
        int sT = s.length() - 1;
        while(tT >= l && sT >=r+1){
            if(s.charAt(tT) == s.charAt(sT)){
                tT--;
                sT--;
            }else{
                tT = r;
                sT--;
            }
        }

        if(tT == l-1){
            return sT + 1;
        }
        return -1;
    }

    static boolean containsVowel(String subject){
        for(char c: subject.toCharArray()){
            if(isVowel(c)) return true;
        }
        return false;
    }

}