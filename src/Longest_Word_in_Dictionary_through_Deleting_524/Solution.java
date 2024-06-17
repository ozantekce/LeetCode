package Longest_Word_in_Dictionary_through_Deleting_524;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("jpthiudqzzeugzwwsngebdeai");
        //list.add("nbmxgkduynigvzuyblwjepn");

        list.add("monkey");
        list.add("plea");


        System.out.println(findLongestWord("wsmzffsupzgauxwokahurhhikapmqitytvcgrfpavbxbmmzdhnrazartkzrnsmoovmiofmilihynvqlmwcihkfskwozyjlnpkgdkayioieztjswgwckmuqnhbvsfoevdynyejihombjppgdgjbqtlauoapqldkuhfbynopisrjsdelsfspzcknfwuwdcgnaxpevwodoegzeisyrlrfqqavfziermslnlclbaejzqglzjzmuprpksjpqgnohjjrpdlofruutojzfmianxsbzfeuabhgeflyhjnyugcnhteicsvjajludwizklkkosrpvhhrgkzctzwcghpxnbsmkxfydkvfevyewqnzniofhsriadsoxjmsswgpiabcbpdjjuffnbvoiwotrbvylmnryckpnyemzkiofwdnpnbhkapsktrkkkakxetvdpfkdlwqhfjyhvlxgywavtmezbgpobhikrnebmevthlzgajyrmnbougmrirsxi", list));

    }


    public static String findLongestWord(String s, List<String> dictionary) {

        String result = "";
        for (String word : dictionary) {
            int j = 0;
            int k = 0;
            if(word.length() <= s.length() && word.length() >= result.length()){
                while (k < word.length()) {
                    char charW = word.charAt(k);
                    int temp = s.indexOf(charW, j);
                    if (temp == -1) break;
                    j = temp + 1;
                    k++;
                }
                if (k == word.length()) {
                    if (word.length() > result.length() || result.compareTo(word) > 0) {
                        result = word;
                    }
                }
            }

        }
        return result;
    }




}
