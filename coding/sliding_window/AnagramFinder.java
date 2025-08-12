package coding.sliding_window;
import java.util.*;

public class AnagramFinder {

    // ip: bcadefghcbad , abc
        // find the starting index of all possible anagrams
        
    public static List<Integer> findAnagramIndices(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) return indices;

        int[] pFreq = new int[26]; // Frequency of target string 'p'
        int[] windowFreq = new int[26]; // Frequency of current window in 's'

        // Initialize frequencies for first window and pattern
        for (int i = 0; i < pLen; i++) {
            pFreq[p.charAt(i) - 'a']++;
            windowFreq[s.charAt(i) - 'a']++;
        }

        // Sliding window across 's'
        for (int i = 0; i <= sLen - pLen; i++) {
            // Compare frequencies
            if (Arrays.equals(pFreq, windowFreq)) {
                indices.add(i);
            }

            // Slide the window (skip on last iteration)
            if (i + pLen < sLen) {
                windowFreq[s.charAt(i) - 'a']--;               // remove left char
                windowFreq[s.charAt(i + pLen) - 'a']++;        // add right char
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        String source = "cbaebabacd";
        String pattern = "abc";
        List<Integer> result = findAnagramIndices(source, pattern);
        System.out.println("Anagram starting indices: " + result);
    }
}


