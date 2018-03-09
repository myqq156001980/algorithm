package com.abel.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sunzqc on 2017/8/8 15:33.
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 40,000.
 *
 * The order of output does not matter.
 *
 * 样例
 * Given s = "cbaebabacd" p = "abc"
 *
 * return [0, 6]
 *
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
public class FindAnagrams {
    /**
     * @param s a string
     * @param p a non-empty string
     * @return a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<Integer>();
        if(s == null || s.length() < p.length()){
            return indices;
        }
        int[] sMap = new int[26];
        int[] pMap = new int[26];
        for(int i = 0; i < p.length(); i++){
            pMap[p.charAt(i) - 'a']++;
        }
        Queue<Character> queue = new LinkedList<>();
        int index = 0;
        while(index < s.length()){
            queue.add(s.charAt(index));
            sMap[s.charAt(index) - 'a']++;
            if(queue.size() == p.length()){
                if(isAnagrams(sMap, pMap)){
                    indices.add(index - p.length() + 1);
                }
                sMap[queue.poll() - 'a']--;
            }
            index++;
        }
        return indices;
    }
    private boolean isAnagrams(int[] sMap, int[] pMap){
        for(int i = 0; i < sMap.length; i++){
            if(sMap[i] != pMap[i]){
                return false;
            }
        }
        return true;
    }
}
