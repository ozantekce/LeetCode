package Product_of_the_Last_K_Numbers_1352;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    class ProductOfNumbers {

        private List<Integer> products;

        public ProductOfNumbers() {
            products = new ArrayList<>();
            products.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                products.clear();
                products.add(1);
            } else {
                products.add(num * products.get(products.size() - 1));
            }
        }

        public int getProduct(int k) {
            if (k >= products.size())
                return 0;
            return products.get(products.size() - 1) / products.get(products.size() - 1 - k);
        }
    }


}
