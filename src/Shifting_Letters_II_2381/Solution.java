package Shifting_Letters_II_2381;

public class Solution {


    public static void main(String[] args) {
        System.out.println(shiftingLetters("abc", new int[][]{{0, 1, 0}, {1, 2, 1}, {0, 2, 1}}));
        //System.out.println(shiftingLetters("abc", new int[][]{{0, 0, 0}}));
    }


    public static String shiftingLetters(String s, int[][] shifts) {

        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] prefixSum = new int[n];

        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int delta = shifts[i][2] == 0 ? -1 : +1;
            prefixSum[start] += delta;
            if (end + 1 < n) prefixSum[end + 1] -= delta;
        }

        int prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix += prefixSum[i];
            int value = chars[i] + prefix;
            value = (char) ('a' + ((value - 'a') % 26 + 26) % 26);
            chars[i] = (char) value;
        }

        return new String(chars);
    }


    public static String shiftingLetters_TreeSolution(String s, int[][] shifts) {

        char[] chars = s.toCharArray();
        Node root = new Node(0, chars.length - 1);

        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int delta = shifts[i][2] == 0 ? -1 : +1;
            root.add(start, end, delta);
        }

        int[] values = new int[chars.length];
        root.setValues(values);

        for (int i = 0; i < chars.length; i++) {
            int value = chars[i] + values[i];
            value = (char) ('a' + ((value - 'a') % 26 + 26) % 26);
            chars[i] = (char) value;
        }

        return new String(chars);
    }


    public static class Node {

        public int start;
        public int end;
        public int value;

        public Node left;
        public Node right;

        public int mid;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.mid = (this.start + this.end) / 2;
        }

        public void add(int start, int end, int delta) {

            if (start <= this.start && end >= this.end) {
                value += delta;
                return;
            }

            if (start <= mid) {
                Node l = GetOrCreateLeft();
                l.add(start, Math.min(end, mid), delta);
            }

            if (end > mid) {
                Node r = GetOrCreateRight();
                r.add(Math.max(start, mid + 1), end, delta);
            }
        }

        public void setValues(int[] values) {
            for (int i = start; i <= end; i++) {
                values[i] += value;
            }
            if (left != null) left.setValues(values);
            if (right != null) right.setValues(values);
        }

        public int getValue(int index) {
            int total = 0;
            Node current = this;

            while (current != null) {
                total += current.value;
                int mid = current.mid;
                if (index <= mid) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            return total;
        }

        public Node GetOrCreateRight() {
            if (right != null) return right;
            right = new Node(mid + 1, end);
            return right;
        }

        public Node GetOrCreateLeft() {
            if (left != null) return left;
            left = new Node(start, mid);
            return left;
        }

    }

}
