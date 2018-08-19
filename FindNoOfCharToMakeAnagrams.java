package test;

import java8features.StreamsMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindNoOfCharToMakeAnagrams {
    public static void main(String[] args) {
        String[] first = {"weedfaf","aab","bcd","bbd","jk","abc"};
        String[] second = {"wxejdbe","bab","bdd","bbd","kj","xy"};

        int[] result = new int[first.length];

        for(int i=0;i<first.length;i++){
            if(first[i].length() != second[i].length()) {
                result[i] = -1;
            }
            else{
                char[] firstCharArr = first[i].toCharArray();
                char[] secondCharArr = second[i].toCharArray();
                int count = 0;
                HashMap<Character, Integer> firstCharMap = new HashMap<>();
                HashMap<Character, Integer> secondCharMap = new HashMap<>();
                for (int j=0; j< first[i].length(); j++){
                    // get the map for firstCharArr
                    char charAtPosJ = firstCharArr[j];
                    if(firstCharMap.get(charAtPosJ)==null)
                        firstCharMap.put(charAtPosJ,1);
                    else
                        firstCharMap.put(charAtPosJ,firstCharMap.get(charAtPosJ)+1);
                    // get the map for secondCharArr
                    charAtPosJ = secondCharArr[j];
                    if(secondCharMap.get(charAtPosJ)==null)
                        secondCharMap.put(charAtPosJ,1);
                    else
                        secondCharMap.put(charAtPosJ,secondCharMap.get(charAtPosJ)+1);
                }
                for (Map.Entry<Character, Integer> entry:
                     firstCharMap.entrySet()) {
                    Character key = entry.getKey();
                    int keysValueInFirstString = (firstCharMap.get(key)!= null)? firstCharMap.get(key) : 0;
                    int keysValueInSecondString = (secondCharMap.get(key)!= null)? secondCharMap.get(key) : 0;
                    if(keysValueInFirstString > keysValueInSecondString){
                        count+= keysValueInFirstString-keysValueInSecondString;
                    }
                }
                result[i] = count;
            }
        }
        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
    }
}
