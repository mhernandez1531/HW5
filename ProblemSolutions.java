/******************************************************************
 *
 *   YOUR NAME / SECTION NUMBER
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     * <p>
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     * Input: [1,50,55,80,90], [55,90]
     * Output: true
     * Input: [1,50,55,80,90], [55,90, 99]
     * Output: false
     * <p>
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE

        // Inserting all list1 elements to a Hashset for quick lookup
        HashSet<Integer> set = new HashSet<>();
        for (int num : list1) {
            set.add(num);
        }

        // Check if all list2 elements are in the HashSet
        for (int num : list2) {
            if (!set.contains(num)) {
                return false; // If any element is missing, B is not subset of A
            }
        }
        return true; // All B elements are inside of A
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE

        // Making a Min-Heap - Priority queue with fixed size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Process each element in the array
        for (int num : array) {
           minHeap.offer(num); // add element to heap

        // If the heap size exceeds k, get rid of smallest elemetn
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Root of Min-Heap is k-th largest element
        return minHeap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE

        // Start a Min-Heap Priority Queue to store all elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // add all array1 elements to the Min-Heap
        for (int num : array1) {
            minHeap.offer(num);
        }

        // add all array2 elements to the Min-Heap
        for (int num : array2) {
            minHeap.offer(num);
        }

        // create array to stroe the sorted results
        int[] sortedArray = new int[array1.length + array2.length];
        int index = 0;

        // remove elements from Min-Heap to get tehm in sorted order
        while (!minHeap.isEmpty()) {
            sortedArray[index++] = minHeap.poll();
        }
        return sortedArray;
    }
}