package Compare_Version_Numbers_165;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        String version1 = "0.1";
        String version2 = "1.1";

        System.out.println(compareVersion(version1,version2));

    }


    public static int compareVersion(String version1, String version2) {


        String [] regionsOfVersion1 = version1.split("\\.");
        String [] regionsOfVersion2 = version2.split("\\.");
        System.out.println(Arrays.toString(regionsOfVersion1));
        System.out.println(Arrays.toString(regionsOfVersion2));
        for (int i = 0; i < Math.max(regionsOfVersion1.length,regionsOfVersion2.length); i++) {

            if(regionsOfVersion1.length<=i&&regionsOfVersion2.length<=i){
                return 0;
            }
            else if(regionsOfVersion1.length<=i){

                int r2 = Integer.parseInt(regionsOfVersion2[i]);
                if(r2!=0){
                    return -1;
                }

            }
            else if(regionsOfVersion2.length<=i){
                int r1 = Integer.parseInt(regionsOfVersion1[i]);
                if(r1!=0){
                    return +1;
                }
            }else{

                int r1 = Integer.parseInt(regionsOfVersion1[i]);
                int r2 = Integer.parseInt(regionsOfVersion2[i]);

                if(r1>r2){
                    return 1;
                }else if(r2>r1){
                    return -1;
                }

            }

        }

        System.out.println("hi");
        return 0;
    }

}
