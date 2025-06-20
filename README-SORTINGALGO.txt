This program is a Sorting Algorithm Project, developed using Java.

The user is prompted to provide an array of numbers.

The given array is sorted using the following algorithms:

•Heap Sort
Heap Sort uses heaps to sort elements. A heap is a binary tree which is a data structure made up of nodes that have a maximum of two children nodes.

Steps:
1. A max heap or a heap that begins with the largest element is created.
•The largest element is removed and placed at the end of the array. This is done repeatedly.
2. After an element is removed the heapify method checks whether a node is greater than or equal to its child nodes. If not, they are swapped.
3. After a swap heapify is used on each node.
4. The resulting array should be sorted

•Merge Sort
Merge Sort uses the divide and conquer paradigm, dividing an input array into two halves, sorting each half, and merging them.
The key steps of the Merge Sort algorithm are as follows:
-Divide: the unsorted array is split into two halves. This continues recursively until each subarray contains only one element.
-Conquer: each subarray is sorted
-Merge: the sorted subarrays are merged back together to produce a single sorted array.

•Counting Sort
Counting Sort sorts elements based on the number of times each specific element appears.

Steps:
1. The minimum and maximum elements in the array is determined
2. A counter array is created and the number of times each element appears is determined and added to the array
3. The counter array is changed to hold cumulative frequencies, which are used to sort the elements in the correct order
4. The sorted elements are saved to the array.

•Radix Sort
Radix Sort sorts elements based on the place values of their digits.

Steps:
1. The maximum element in the array is determined
2. Each element is searched digit by digit and each digit is used to update a counter array that tracks the frequency of digits in the ones place, tens place, and so on.
3. The counter array is changed to hold cumulative frequencies of the place values of the elements.
4. The cumulative frequencies are used to sort the elements.

The orignial array is displayed and the arrays gotten using the sorting algorithms is displayed.