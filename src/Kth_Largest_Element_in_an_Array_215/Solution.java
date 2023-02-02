
package Kth_Largest_Element_in_an_Array_215;


import java.util.Random;

public class Solution {


    public static void main(String[] args) {

        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
    }



    // Quick Select Solution
    public static int findKthLargest(int[] nums, int k) {

        return Select(nums,0,nums.length-1,nums.length-k);
    }

    public static int Select(int A[],int p,int r,int i){

        if(p==r){
            return A[p];
        }

        int q = R_PartitionH(A,p,r);
        int k = q-p+1;

        if(i<=k)
            return Select(A,p,q,i);
        else
            return Select(A,q+1,r,i-k);


    }

    public static Random random = new Random();
    public static int R_PartitionH(int A[],int p, int r){


        int s = random.nextInt(p,r+1);
        int holder = A[p];
        A[p] = A[s];
        A[s] = holder;
        return H_Partition(A,p,r);

    }

    private static int H_Partition(int[] A, int p, int r) {

        int pivot = A[p] ;
        int i=p-1;
        int j=r+1;

        while (true){

            while (true){
                j = j-1;
                if(A[j]<=pivot)
                    break;
            }

            while (true){
                i = i +1;
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


    //Heap Solution
    public static int findKthLargestHeap(int[] nums, int k) {

        MyMinHeap heap = new MyMinHeap(k);

        for (int i = 0; i < nums.length; i++) {
            heap.insert(nums[i]);
        }

        return heap.heap[0];
    }

    public static class MyMinHeap {

        private int [] heap;
        private final int capacity;
        private int size;

        public MyMinHeap(int capacity) {
            this.capacity = capacity;
            heap = new int[capacity];
        }

        public void insert(int val){

            if(size<capacity){
                heap[size] = val;
                int current = size;
                size++;

                while (heap[current] < heap[getParentIndex(current)]) {
                    swap(heap,current,getParentIndex(current));
                    current = getParentIndex(current);
                }
            }else if(val>heap[0]){
                //throw new RuntimeException("Heap is full");
                remove();
                insert(val);
            }
            //System.out.println("size : "+size);

        }


        public int remove(){

            if(size!=0){
                size--;
                return extractMin(heap,size);
            }else{
                throw new RuntimeException("Heap is empty");
            }


        }

        private int extractMin(int[] heap, int n) {

            int min = heap[0];
            heap[0] = heap[n];
            n = n-1;
            heapify(heap,0,n);
            return min;
        }

        private void heapify(int[] heap, int i, int n) {

            int smallest = i;

            if(getLeftChildIndex(i) <= n && heap[getLeftChildIndex(i)]<heap[smallest]){
                smallest = getLeftChildIndex(i);
            }

            if(getRightChildIndex(i)  <= n && heap[getRightChildIndex(i)]<heap[smallest]){
                smallest = getRightChildIndex(i) ;
            }

            if(smallest!=i){
                swap(heap,i,smallest);
                heapify(heap,smallest,n);
            }

        }


        private int getLeftChildIndex(int index){
            return  index*2+1;
        }
        private int getRightChildIndex(int index){
            return  index*2+2;
        }

        private int getParentIndex(int index){
            return (int) ((index/2.0)-0.5);
        }

        private void swap(int heap[], int i1 , int i2){

            int holder = heap[i1];
            heap[i1] = heap[i2];
            heap[i2] = holder;

        }

        public boolean isEmpty(){
            return size==0;
        }

        public void printer(){

            for(int i=0;i<size;i++){
                for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<10;j++){
                    System.out.print(heap[j+(int)Math.pow(2,i)-1]+" ");

                }
                System.out.println();
            }

        }

    }




    // Binary Tree Solution
    public static int findKthLargestTree(int[] nums, int k) {

        MyTree myTree = new MyTree(k);

        for (int i = 0; i < nums.length; i++) {

            myTree.add(nums[i]);

        }

        return myTree.findMin();
    }

    public static class MyTree {

        private int size;
        private int capacity;

        private Node root;

        public MyTree(int capacity) {
            this.capacity = capacity;
        }

        private Node parentOfMinNode;
        private Node minNode;

        public void add(int value){

            // capacity 1
            if(capacity==1){
                if(root==null){
                    root = new Node(value);
                }else{
                    if(root.value<value){
                        root.value = value;
                    }
                }
            }

            // empty
            if(root==null){
                size++;
                root = new Node(value);
                return;
            }
            // has size
            if(size<capacity){
                Node current = root;

                while (true){

                    if(value>=current.value){
                        if(current.right!=null)
                            current = current.right;
                        else{
                            current.right = new Node(value);
                            break;
                        }
                    }else{
                        if(current.left!=null)
                            current = current.left;
                        else{
                            current.left = new Node(value);
                            break;
                        }
                    }

                }
                size++;
                return;
            }

            // find min
            Node parentOfMin = null;
            Node minNode = root;
            if(this.minNode!=null){
                minNode = this.minNode;
                parentOfMin = this.parentOfMinNode;
            }else{
                while (true){
                    if(minNode.left!=null){
                        parentOfMin = minNode;
                        minNode = minNode.left;
                    }else{
                        break;
                    }
                }
                this.minNode = minNode;
                this.parentOfMinNode = parentOfMin;
            }

            //control value is bigger than min else return
            if(value<=minNode.value){
                return;
            }

            // remove min
            //  root is min
            if(minNode.value== root.value){
                root = root.right;
            }else{// other min
                if(minNode.right==null){
                    parentOfMin.left = null;
                }else{
                    parentOfMin.left = minNode.right;
                }
            }
            this.minNode = null;
            this.parentOfMinNode = null;
            // add value
            Node current = root;
            while (true){
                if(value>=current.value){
                    if(current.right!=null)
                        current = current.right;
                    else{
                        current.right = new Node(value);
                        break;
                    }
                }else{
                    if(current.left!=null)
                        current = current.left;
                    else{
                        current.left = new Node(value);
                        break;
                    }
                }
            }

        }


        public int findMin(){
            Node minNode = root;
            while (true){
                if(minNode.left!=null){
                    minNode = minNode.left;
                }else{
                    break;
                }
            }
            return minNode.value;
        }


        public class Node{

            public int value;
            public Node left;
            public Node right;

            public Node(int value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "value=" + value +
                        ", left=" + left +
                        ", right=" + right +
                        '}';
            }
        }
    }

}
