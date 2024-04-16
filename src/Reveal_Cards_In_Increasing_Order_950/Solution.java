package Reveal_Cards_In_Increasing_Order_950;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
        //System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{1, 1000})));
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{1, 2, 3, 4})));

    }

    //

    public static int[] deckRevealedIncreasing(int[] deck) {

        QuickSort_H(deck, 0, deck.length-1);
        DoubleLinkedList<Integer> res = new DoubleLinkedList<>();
        res.addFirst(deck[deck.length-1]);
        //System.out.println(res);
        for (int i = deck.length-2; i >= 0; i--) {
            int val = deck[i];
            res.shiftRight();
            //System.out.println(res);
            res.addFirst(val);
            //System.out.println(res);
            //System.out.println("--------------");
        }

        for (int i = 0; i < deck.length; i++) {
            deck[i] = res.removeFirst();
        }

        return deck;
    }


    public static void QuickSort_H(int A[],int p, int r){
        if(p<r){
            int q = hoaresPartition(A,p,r);
            QuickSort_H(A,p,q);
            QuickSort_H(A,q+1,r);
        }
    }

    public static int hoaresPartition(int A[], int p, int r){

        int pivot = A[p];
        int i = p-1;
        int j = r+1;
        while (true){

            while (true){
                j=j-1;
                if(A[j]<=pivot)
                    break;
            }
            while (true){
                i=i+1;
                if(A[i]>=pivot)
                    break;
            }
            if(i<j){
                int holder = A[i];
                A[i] = A[j];
                A[j] = holder;
            }else{
                return j;
            }

        }

    }


    private static class DoubleLinkedList<E> {

        private Node<E> head = null;
        private Node<E> tail = null;
        private int size=0;

        public void addFirst(E data) {
            Node<E> temp = new Node<>(data, head, tail);
            if (head == null) {
                head = tail = temp;
                head.next = head.prev = head;
            } else {
                head.prev = temp;
                tail.next = temp;
                head = temp;
            }
            size++;
        }


        public void addLast(E data) {
            Node<E> temp = new Node<>(data, head, tail);
            if (tail == null) {
                head = tail = temp;
                head.next = head.prev = head;
            } else {
                tail.next = temp;
                head.prev = temp;
                tail = temp;
            }
            size++;
        }


        public void shiftLeft() {
            if (head != null) {
                head = head.next;
                tail = tail.next;
            }
        }

        public void shiftRight() {
            if (head != null) {
                head = head.prev;
                tail = tail.prev;
            }
        }


        public E removeFirst() {
            if (size == 0) return null;
            E val = head.data;
            if (size == 1) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
            }
            size--;
            return val;
        }


        public E removeLast() {
            if (size == 0) return null;
            E val = tail.data;
            if (size == 1) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
            }
            size--;
            return val;
        }



        public E get(int i){

            Node<E> temp=head;

            for (int j = 0; j < i; j++) {
                temp=temp.next;
            }

            return temp.data;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty(){return size==0;}

        public E getFirst() {
            return head.data;
        }

        public E getLast() {
            return tail.data;
        }


        private StringBuilder stringBuilder = new StringBuilder();
        @Override
        public String toString() {
            stringBuilder.setLength(0);

            if(isEmpty())return "[]";
            stringBuilder.append("[");

            Node current = head;
            stringBuilder.append(head.data);
            current = current.next;
            int i = 1;
            while (i<size){
                stringBuilder.append(", "+current.data);
                current = current.next;
                i++;
            }
            stringBuilder.append("]");
            return  stringBuilder.toString();
        }


        private static class Node<E> {
            private E data;
            private Node<E> next;
            private Node<E> prev;

            public Node(E data, Node<E> next, Node<E> prev) {
                this.data = data;
                this.next = next;
                this.prev = prev;
            }
        }


    }

}
