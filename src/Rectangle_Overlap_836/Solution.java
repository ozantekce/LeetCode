package Rectangle_Overlap_836;


public class Solution {


    public static void main(String[] args) {


        int [] rec1 = new int[]{-6,-10,9,2};
        int [] rec2 = new int[]{0,5,4,8};

        System.out.println(isRectangleOverlap(rec1,rec2));

    }



    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        int rec1X,rec1Y,rec1W,rec1H;

        rec1X = rec1[0];
        rec1Y = rec1[1];
        rec1W = Math.abs(rec1[0]-rec1[2]);
        rec1H = Math.abs(rec1[1]-rec1[3]);

        Rectangle rectangle1 = new Rectangle( rec1X, rec1Y,rec1W,rec1H);
        System.out.println(rectangle1);
        int rec2X,rec2Y,rec2W,rec2H;

        rec2X = rec2[0];
        rec2Y = rec2[1];
        rec2W = Math.abs(rec2[0]-rec2[2]);
        rec2H = Math.abs(rec2[1]-rec2[3]);

        Rectangle rectangle2 = new Rectangle( rec2X, rec2Y,rec2W,rec2H);
        System.out.println(rectangle2);


        return rectangle1.overlaps(rectangle2);
    }



    private static class Rectangle{

        private int x;
        private int y;
        private int width;
        private int height;


        public Rectangle(int x,int y , int w,int h) {

            this.x = x;
            this.y = y;
            this.width = w;
            this.height = h;

        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "x=" + x +
                    ", y=" + y +
                    ", width=" + width +
                    ", height=" + height +
                    '}';
        }

        public boolean overlaps (Rectangle other) {
            return
                    x < other.x + other.width
                    && x + width > other.x
                    && y < other.y + other.height
                    && y + height > other.y;

        }




    }





}
