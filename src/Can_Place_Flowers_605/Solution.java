package Can_Place_Flowers_605;

public class Solution {


    public boolean canPlaceFlowers(int[] flowerbed, int n) {


        for (int i = 0; i < flowerbed.length;i++) {

            if(flowerbed[i]==0){
                int prevIndex = i-1;
                int nextIndex = i+1;
                boolean c1 = true,c2 = true;
                if(prevIndex>=0){
                    c1 = flowerbed[prevIndex] == 0;
                }
                if(nextIndex<=flowerbed.length-1){
                    c2 = flowerbed[nextIndex] == 0;
                }
                if(c1 && c2){
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }


        return n<=0;
    }

}
