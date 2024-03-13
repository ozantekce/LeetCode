public class Greatest_Common_Divisor_of_Strings_1071 {


    public static void main(String[] args) {

        System.out.println(gcdOfStrings("ABCABC","ABC"));
        System.out.println(gcdOfStrings("ABABAB","ABAB"));
        System.out.println(gcdOfStrings("LEET","CODE"));

    }



    public static String gcdOfStrings(String str1, String str2) {


        String shortStr;
        String longStr;

        if(str1.length() > str2.length()){
            longStr = str1;
            shortStr = str2;
        }else{
            longStr = str2;
            shortStr = str1;
        }

        for (int i = 0; i < shortStr.length(); i++) {

            if(canSplit(shortStr.length()-i-1,shortStr,shortStr) &&
                    canSplit(shortStr.length()-i-1,shortStr,longStr)
            ){
                return shortStr.substring(0,shortStr.length()-i);
            }

        }

        return "";
    }




    private static boolean canSplit(int endIndex, String splitter, String str){

        int sizeOfSplitter = endIndex + 1;
        int sizeOfStr = str.length();
        if (sizeOfStr % sizeOfSplitter != 0) return false;
        if (sizeOfStr == sizeOfSplitter) return str.equals(splitter);

        for (int i = 0; i < sizeOfStr; i++) {
            int j = i % sizeOfSplitter;
            if(splitter.charAt(j) != str.charAt(i)) return false;
        }

        return true;
    }



}
