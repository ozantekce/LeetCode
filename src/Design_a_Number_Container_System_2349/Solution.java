package Design_a_Number_Container_System_2349;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

    }


    class NumberContainers {

        HashMap<Integer, Integer> indexToNumberMap;
        HashMap<Integer, PriorityQueue<Integer>> numberToMinIndicesMap;
        HashMap<Integer, HashSet<Integer>> numberToRemovedIndicesMap;

        public NumberContainers() {
            indexToNumberMap = new HashMap<>();
            numberToMinIndicesMap = new HashMap<>();
            numberToRemovedIndicesMap = new HashMap<>();
        }

        public void change(int index, int number) {
            if (indexToNumberMap.containsKey(index)) {
                int oldNumber = indexToNumberMap.get(index);
                if (oldNumber == number) return;
                HashSet<Integer> removedIndices = getOrCreateRemovedIndices(oldNumber);
                removedIndices.add(index);
            }

            PriorityQueue<Integer> indices = getOrCreateMinIndices(number);
            indices.add(index);
            indexToNumberMap.put(index, number);

            HashSet<Integer> removedIndices = getRemovedIndices(number);
            if(removedIndices != null){
                removedIndices.remove(index);
                if(removedIndices.isEmpty())
                    removeRemovedIndices(number);
            }

        }

        public int find(int number) {
            PriorityQueue<Integer> indices = getMinIndices(number);
            if (indices == null) return -1;
            HashSet<Integer> removedIndices = getRemovedIndices(number);
            if (removedIndices != null) {
                int lastIndex = -1;
                while (!indices.isEmpty()) {
                    int currentIndex = indices.peek();
                    if (removedIndices.contains(currentIndex) || lastIndex == currentIndex) {
                        indices.poll();
                        removedIndices.remove(currentIndex);
                        lastIndex = currentIndex;
                    } else {
                        break;
                    }
                }
                if (removedIndices.isEmpty())
                    removeRemovedIndices(number);
            }

            if (indices.isEmpty()) {
                removeMinIndices(number);
                return -1;
            }

            return indices.peek();
        }


        private HashSet<Integer> getOrCreateRemovedIndices(int number) {
            HashSet<Integer> removedIndices;
            if (!numberToRemovedIndicesMap.containsKey(number)) {
                numberToRemovedIndicesMap.put(number, new HashSet<>());
            }
            removedIndices = numberToRemovedIndicesMap.get(number);
            return removedIndices;
        }

        private PriorityQueue<Integer> getOrCreateMinIndices(int number) {
            PriorityQueue<Integer> indices;
            if (!numberToMinIndicesMap.containsKey(number)) {
                numberToMinIndicesMap.put(number, new PriorityQueue<>());
            }
            indices = numberToMinIndicesMap.get(number);
            return indices;
        }

        private HashSet<Integer> getRemovedIndices(int number) {
            HashSet<Integer> removedIndices;
            if (!numberToRemovedIndicesMap.containsKey(number)) {
                return null;
            }
            removedIndices = numberToRemovedIndicesMap.get(number);
            return removedIndices;
        }

        private PriorityQueue<Integer> getMinIndices(int number) {
            PriorityQueue<Integer> indices;
            if (!numberToMinIndicesMap.containsKey(number)) {
                return null;
            }
            indices = numberToMinIndicesMap.get(number);
            return indices;
        }

        private void removeRemovedIndices(int number) {
            numberToRemovedIndicesMap.remove(number);
        }

        private void removeMinIndices(int number) {
            numberToMinIndicesMap.remove(number);
        }

    }



}
