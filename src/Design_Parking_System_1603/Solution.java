package Design_Parking_System_1603;

public class Solution {


    class ParkingSystem {

        private int[] counter;

        public ParkingSystem(int big, int medium, int small) {
            counter = new int[]{big, medium, small};
        }

        public boolean addCar(int carType) {
            if (counter[carType - 1] == 0) return false;
            counter[carType - 1]--;
            return true;
        }
    }

}
