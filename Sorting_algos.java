import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


class SortAlgo {
protected int[] array;

//Constructor
public SortAlgo (int[] array) {
this.array = array;
}


}


class HeapAlgo extends SortAlgo {

//Constructor	
	public HeapAlgo(int[] array) {
super(array);
}

	
	 public void sort(int arr[]) {
int n = arr.length;



	System.out.print(" Unsorted Array: \n"+" {");
			
			for(int i=0; i<n ; i++)
		{
			System.out.print(array[i]+",");	
		}
		System.out.println("}");
		


for (int i = n / 2 - 1; i >= 0; i--) {
heapify(arr, n, i);
}

// One by one extract an element from the heap
for (int i = n - 1; i > 0; i--) {
// Move current root to end
int temp = arr[0];
arr[0] = arr[i];
arr[i] = temp;


heapify(arr, i, 0);
}
}
	
	
	
	void heapify(int arr[], int n, int i) {
int largest = i; // Initialize largest as root
int leftChild = 2 * i + 1; // left = 2*i + 1
int rightChild = 2 * i + 2; // right = 2*i + 2


if (leftChild < n && arr[leftChild] > arr[largest]) {
largest = leftChild;
}


if (rightChild < n && arr[rightChild] > arr[largest]) {
largest = rightChild;
}


if (largest != i) {
int swap = arr[i];
arr[i] = arr[largest];
arr[largest] = swap;


heapify(arr, n, largest);
}
}

	
	
	
	
	public static void saveArray(int size, int[] array, int[] output){
		
		int i;
		int n=size;
		
		String file="gp15file.txt";
		
		
		try{
		
		FileWriter heap_fw1=new FileWriter(file);
		PrintWriter heap_pw1=new PrintWriter(heap_fw1);
		
		
heap_pw1.print(" \t\t Heap Sort \n");
		
heap_pw1.print(" Unsorted Array: \n"+" {");
			
			for(i=0; i<n ; i++)
		{
			heap_pw1.print(array[i]+",");	
		}
		heap_pw1.println("}");
	
	
	
	
	
		
		heap_pw1.print(" Array sorted with Heap Sort: \n"+" {");
		
		 for(i=0; i<n ; i++ ){
			heap_pw1.print(output[i]+",");
			}	
		heap_pw1.print("}\n");
		
		heap_pw1.close();
		heap_fw1.close();
		
		
		
		System.out.print(" Array sorted with Heap Sort: \n"+" {");
		for(i=0; i<n ; i++ ){
			System.out.print(output[i]+",");
			}	
		System.out.print("}\n");
		
		
		System.out.println("Heap Sort Algorithm: Array saved to "+file+" successfully.\n");
		}
		
		catch (IOException error){
			System.out.println("Save failed. \n Error: "+error);
		}
	
	}
	
}


class MergeAlgo extends SortAlgo {
	
//Constructor
	public MergeAlgo(int[] array) {
super(array);
}
	
	
	

	static void mergeSort(int[] array, int left, int right) {
if (left < right) {
// Find the middle point
int middle = left + (right - left) / 2;

// Recursively sort the first and second halves
mergeSort(array, left, middle);
mergeSort(array, middle + 1, right);

// Merge the sorted halves
merge(array, left, middle, right);
}
}


static void merge(int[] array, int left, int middle, int right) {
// Find sizes of two subarrays to be merged
int n1 = middle - left + 1;
int n2 = right - middle;

// Create temporary arrays
int[] leftArray = new int[n1];
int[] rightArray = new int[n2];

// Copy data to temporary arrays
for (int i = 0; i < n1; ++i)
leftArray[i] = array[left + i];
for (int j = 0; j < n2; ++j)
rightArray[j] = array[middle + 1 + j];

// Merge the temporary arrays

// Initial indexes of the two subarrays
int i = 0, j = 0;

// Initial index of the merged subarray
int k = left;
while (i < n1 && j < n2) {
if (leftArray[i] <= rightArray[j]) {
array[k] = leftArray[i];
i++;
} else {
array[k] = rightArray[j];
j++;
}
k++;
}

// Copy remaining elements of leftArray[], if any
while (i < n1) {
array[k] = leftArray[i];
i++;
k++;
}

// Copy remaining elements of rightArray[], if any
while (j < n2) {
array[k] = rightArray[j];
j++;
k++;
}


}


	public static void saveArray(int[] unsorted_arr, int[] sorted_arr){
		
		int i;
		int size=unsorted_arr.length;
		
		String file="gp15file.txt";
		
		
		try{
		
		FileWriter merge_fw1=new FileWriter(file);
		PrintWriter merge_pw1=new PrintWriter(merge_fw1);
		
		
		
merge_pw1.print(" \t\t Merge Sort \n");
		
merge_pw1.print(" Unsorted Array: \n"+" {");
			
			for(i=0; i<size; i++ )
		{
			merge_pw1.print(unsorted_arr[i]+",");	
		}
		merge_pw1.println("}");
	
	
	System.out.print(" Unsorted Array: \n"+" {");
			
			for(i=0; i<size ; i++)
		{
			System.out.print(unsorted_arr[i]+",");	
		}
		System.out.println("}");
	
	
	
	
		
		merge_pw1.print(" Array sorted with Merge Sort: \n"+" {");
		
		 for(i=0; i<size; i++ ){
			merge_pw1.print(sorted_arr[i]+",");
			}	
		merge_pw1.print("}");
		
		merge_pw1.close();
		merge_fw1.close();
		
		
			System.out.print(" Array sorted with Merge Sort: \n"+" {");
		for(i=0; i<size; i++ ){
			System.out.print(sorted_arr[i]+",");
			}	
		System.out.print("}\n");
		
		
		
		
		
		
		System.out.println("Merge Sort Algorithm: Array saved to "+file+" successfully.\n");
		}
		
		catch (IOException error){
			System.out.println("Merge Sort Algorithm: Failed to save array to file. \n Error: "+error);
		}
	
	}
}


class CountingAlgo extends SortAlgo {

//Constructor
public CountingAlgo(int[] array) {
super(array);
}


//findmin finds the smallest element in the array and returns it
	public static int findMin(int[] array1) {
int min = array1[0];
for (int i = 1; i < array1.length; i++) {
if (array1[i] < min) {
min = array1[i];
}
}
return min;
}
	
	//findmax finds the largest element in the array and returns it
	public static int findMax(int[] array1) {
int max = array1[0];
for (int i = 1; i < array1.length; i++) {
if (array1[i] > max) {
max = array1[i];
}
}
return max;
	}



public void countingSort(){
						
//Calling the max and min methods						
		int min=findMin(array);
		int max=findMax(array);
						
						
		//Array to store the number of times a certain element appears
		int[] ele_counter= new int[max-min+1];
		//max-min+1 is the size of the new array which is equal to the number of unique numbers in the original array


//Saves the number of times an element appears to the element counter array
for (int i = 0; i < array.length; i++) {
ele_counter[array[i] - min]++;
}

//Array changed to hold cumulative frequency
for (int i = 1; i < ele_counter.length; i++) { ele_counter[i] += ele_counter[i - 1]; }

	int[] sorted_arr= new int[array.length];
	
// Saves the sorted elements to the new array
for (int i = array.length - 1; i >= 0; i--) {
sorted_arr[ele_counter[array[i] - min] - 1] = array[i];
ele_counter[array[i] - min]--;
}

saveArray(array, sorted_arr);

}

public void saveArray( int[] array, int[] output){
		
		int i;
		int length=array.length;
		
		String file="gp15file.txt";
		
		
		try{
		
		FileWriter counting_fw1=new FileWriter(file);
		PrintWriter counting_pw1=new PrintWriter(counting_fw1);
		
		
		
counting_pw1.print(" \t\t Counting Sort \n");
		
counting_pw1.print(" Unsorted Array: \n"+" {");
			
			for(i=0; i<length ; i++)
		{
			counting_pw1.print(array[i]+",");	
		}
		counting_pw1.println("}");
		
	
		System.out.print(" Unsorted Array: \n"+" {");
			
			for(i=0; i<length ; i++)
		{
			System.out.print(array[i]+",");	
		}
		System.out.println("}");
		
		
	
	
		
		counting_pw1.print(" Array sorted with Counting Sort: \n"+" {");
		
		 for(i=0; i<length ; i++ ){
			counting_pw1.print(output[i]+",");
			}	
		counting_pw1.print("}");
		
		counting_pw1.close();
		counting_fw1.close();
		
		
			System.out.print(" Array sorted with Counting Sort: \n"+" {");
		for(i=0; i<length ; i++ ){
			System.out.print(output[i]+",");
			}	
		System.out.print("}\n");
		
		
		
		
		System.out.println("Counting Sort Algorithm: Array saved to "+file+" successfully.\n");
		}
		
		catch (IOException error){
			System.out.println("Counting Sort Algorithm: Failed to save array to file. \n Error: "+error);
		}
	
	}



}



class RadixAlgo extends SortAlgo {

//Constructor
public RadixAlgo(int[] array) {
super(array);
}

//Finds largest element in array 
public int getMax(int[] array){
		int max=array[0];
		for(int i=0; i<array.length; i++){
			if(array[i]>max){
				max=array[i];
		}
		
	}
	return max;
	}



public void radixSort(){
		int maximum=getMax(array);
		int exp;
		for(exp=1; maximum/exp>0 ; exp*=10){
		countingSort(exp);
		}
	}		


//Counting Sort Algorithm
public void countingSort(int exp){
		int size=array.length;
		int[] occur= new int[size];
		
		for(int i=0; i<size; i++){
			occur[(array[i]/exp)%10]++;
		}
		
		for(int i=1; i<10; i++){
			occur[i]+=occur[i-1];
		}
		
		int[] output= new int[size];
		
	for(int i=size-1 ; i>=0 ; i--){
		output[occur[(array[i]/exp)%10]-1]=array[i];
		occur[(array[i]/exp)%10]--;
	}
	
	saveArray(size, array, output);
	}



public void saveArray(int size, int[] array, int[] output){
		
		int i;
		int n=size;
		
		String file="gp15file.txt";
		
		
		try{
		
		FileWriter radix_fw1=new FileWriter(file);
		PrintWriter radix_pw1=new PrintWriter(radix_fw1);
		
			
radix_pw1.print(" \t\t Radix Sort \n");

radix_pw1.print(" Unsorted Array: \n"+" {");
			
			for(i=0; i<n ; i++)
		{
			radix_pw1.print(array[i]+",");	
		}
		radix_pw1.println("}");
	
	
	System.out.print(" Unsorted Array: \n"+" {");
			
			for(i=0; i<n ; i++)
		{
			System.out.print(array[i]+",");	
		}
		System.out.println("}");
	
	
		
		radix_pw1.print(" Array sorted with Radix Sort: \n"+" {");
		
		 for(i=0; i<n ; i++ ){
			radix_pw1.print(output[i]+",");
			}	
		radix_pw1.print("}");
		
		radix_pw1.close();
		radix_fw1.close();
		
		
			System.out.print(" Array sorted with Radix Sort: \n"+" {");
		for(i=0; i<n ; i++ ){
			System.out.print(output[i]+",");
			}	
		System.out.print("}\n");
		
		
		
		
		System.out.println("Radix Sort Algorithm: Array saved to "+file+" successfully.");
		}
		
		catch (IOException error){
			System.out.println("Radix Sort Algorithm: Failed to save array to file. \n Error: "+error);
		}
	
	}
}


class Main {
    public static void main(String[] args) {		
    			
    //Heap Sort
    int[] array_h = {9, 1, 3, 8, 6, 5, 2, 4, 7};
int n = array_h.length;

HeapAlgo heapSort = new HeapAlgo(array_h);
heapSort.sort(array_h);

heapSort.saveArray(n, array_h, array_h);
    
    																
    //Merge Sort					

int[] array_m = {12, 11, 13, 5, 6, 7};


int[] arraym_copy= new int[array_m.length];
for (int i=0; i<array_m.length; i++){
	arraym_copy[i]= array_m[i];
}

MergeAlgo merge= new MergeAlgo(array_m);
merge.mergeSort(array_m, 0, array_m.length - 1);

merge.saveArray(arraym_copy, array_m);		
    							
    								
    //Counting Sort									
   int[] array_c = {3, 9, 7, 2, 1, 6, 4, 8, 5, 1};

CountingAlgo counting= new CountingAlgo(array_c);
counting.countingSort();										
    											
 	
    	//Radix Sort
    	int[] array_r = {3, 9, 7, 2, 1, 6, 4, 8, 5, 1};
RadixAlgo radix = new RadixAlgo(array_r);
radix.radixSort();
    	
    	
    }
}