public class Algorithms {

    /**
     * SELECTION SORT
     * 
     * time complexity: O(n^2)
     * space complexity: O(1) - no additional space
     */
    public static void selectionSort(int[] list) { 
        int minIndex; 
        for (int i=0; i<list.length-1; i++) {     
            int min = list[i];      
            minIndex = i;     
            for (int j=i; j<list.length; j++){       
                if (list[j] < min){          
                    min = list[j];          
                    minIndex = j;       
                }     
            }     
            int temp = list[i];     
            list[i] = list[minIndex];     
            list[minIndex] = temp; 
        }   
    }

    public static <E extends Comparable<E>> void selectionSort(E[] list) { 
        int minIndex; 
        for (int i=0; i<list.length-1; i++) {    
            E min = list[i];      
            minIndex = i;     
            for (int j=i; j<list.length; j++){       
                if (list[j].compareTo(min) < 0){          
                    min = list[j];          
                    minIndex = j;       
                }     
            }     
            E temp = list[i];     
            list[i] = list[minIndex];     
            list[minIndex] = temp; 
        }   
    }

    /**
     * INSERTION SORT
     * 
     * time complexity: O(n^2)
     * space complexity: O(1)
     */
    public static void insertionSort(int[] list) { 
        for (int i=1; i<list.length; i++) {  
            //Insert element i in the sorted sub-list 
            int currentVal = list[i]; 
            int j = i; 
            while (j > 0 && currentVal < (list[j - 1]))   { // Shift element (j-1) into element (j) 
                list[j] = list[j - 1]; j--; 
            } 
            // Insert currentVal at position j  
            list[j] = currentVal; 
        } 
    }

    public static <E extends Comparable<E>> void insertionSort(E[] list) { 
        for (int i=1; i<list.length; i++) {  
            //Insert element i in the sorted sub-list 
            E currentVal = list[i]; 
            int j = i; 
            while (j > 0 && currentVal.compareTo(list[j-1]) < 0) { // Shift element (j-1) into element (j) 
                list[j] = list[j - 1]; j--; 
            } 
            // Insert currentVal at position j  
            list[j] = currentVal; 
        } 
    }

    /**
     * BUBBLE SORT
     * 
     * time complexity: O(n^2)
     * space complexity: O(1)
     */
    public static void bubbleSort(int[] list) {  
        boolean sorted = false;  
        for (int k=1; k < list.length && !sorted; k++) {    
            sorted = true;    
            for (int i=0; i<list.length-k; i++) {      
                if (list[i] > list[i+1]) {         
                    // swap         
                    int temp = list[i];         
                    list[i] = list[i+1];         
                    list[i+1] = temp;         
                    sorted = false;      
                }    
            } 
        }
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean sorted = false;  
        for (int k=1; k < list.length && !sorted; k++) {    
            sorted = true;    
            for (int i=0; i<list.length-k; i++) {      
                if (list.get[i] > list[i+1]) {     
                    // swap         
                    int temp = list[i];         
                    list[i] = list[i+1];         
                    list[i+1] = temp;         
                    sorted = false;      
                }    
            } 
        }
    }

    /**
     * MERGE SORT
     * 
     * time complexity: O(nlogn)
     * space complexity: O(n)
     */
    public static void mergeSort(int[] list) { 
        if (list.length > 1) { // ==1: base case 
            int[] firstHalf = new int[list.length/2]; 
            int[] secondHalf = new int[list.length - list.length/2]; 
            System.arraycopy(list, 0, firstHalf, 0, list.length/2); 
            System.arraycopy(list,  list.length/2, secondHalf, 0, list.length-list.length/2); 
            
            mergeSort(firstHalf); 
            mergeSort(secondHalf); 
            merge(firstHalf, secondHalf, list);  
        } 
    }

    public static void merge(int[] list1, int[] list2, int[] list) { 
        int list1Index = 0; 
        int list2Index = 0; 
        int listIndex = 0; 
        while( list1Index < list1.length && list2Index < list2.length) { 
            if (list1[list1Index] < list2[list2Index]) 
                list[listIndex++] = list1[list1Index++]; 
            else 
                list[listIndex++] = list2[list2Index++]; 
        } 
        while(list1Index < list1.length) 
            list[listIndex++] = list1[list1Index++]; 
        while(list2Index < list2.length) 
            list[listIndex++] = list2[list2Index++]; 
    }

    /**
     * QUICK SORT
     * 
     * time complexity: O(nlogn) - avg, O(n^2) - worst case
     * space complexity: O(1)
     */
    public static void quickSort(int[] list) { quickSort(list, 0, list.length-1); }

    public static void quickSort(int[] list, int first, int last) { 
        if (last > first) { 
            int pivotIndex = partition(list, first, last); 
            quickSort(list, first, pivotIndex-1); 
            quickSort(list, pivotIndex+1, last); 
        } 
    }
    
    public static int partition(int list[], int first, int last){ 
        int pivot; 
        int index, pivotIndex; pivot = list[first];// pivot is the first element 
        
        pivotIndex = first; 
        for (index = first + 1; index <= last; index++)   
            if (list[index] < pivot){     
                pivotIndex++;     
                swap(list, pivotIndex, index);   
            } 
        swap(list, first, pivotIndex);
        return pivotIndex; 
    }
    
    /**
     * HEAP SORT
     * 
     * time complexity: worst case - O(nlogn)
     * space complexity: O(n)
     */
    public static <E extends Comparable<E>>  void heapSort(E[] list) { 
        Heap<E> heap = new Heap<>();    
        for(int i=0; i<list.length; i++){       
            heap.add(list[i]);    
        } 
        for (int i=list.length-1; i>=0; i--) { 
            list[i] = heap.remove(); 
        } 
    }

    /**
     * BUCKET SORT
     * 
     * time complexity: O(n+t)
     * space complexity: O(t)
     */
    public static void bucketSort(int[] list) {     
        int t = max(list); 
        ArrayList<ArrayList<Integer>> buckets; 
        buckets = new ArrayList<>(t+1); 
        for(int i=0; i<t+1; i++) 
            buckets.add(new ArrayList<>());// bucket i 
            
            //Distribute the data on the buckets 
            for(int i=0; i<list.length; i++) { 
                ArrayList<Integer> bucket = buckets.get(list[i]); 
                bucket.add(list[i]); 
            } 
            
            // Move the data from the buckets back to the list 
            int k = 0; 
            for(int i=0; i<buckets.size(); i++) { 
                ArrayList<Integer> bucket = buckets.get(i); 
                for(int j=0; j<bucket.size(); j++) 
                    list[k++] = bucket.get(j); 
            }
    }

    /**
     * RADIX SORT
     * 
     * time complexity: O(d*n) (D: number of radix positions)
     * space complexity: O(1)
     */
    public static void radixSort(ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> buckets;
        buckets = new ArrayList<>(10);// 10 buckets
        Integer digits = 5;
        for (int i = 0; i < digits; i++) {
            for (int j = 0; j < 10; j++) { // create buckets for iteration i
                buckets.add(new ArrayList<>());
            }
        }
        // Distribute data on buckets
        for (int j = 0; j < list.size(); j++) {
            int digit = list.get(j) % (10 * (j + 1)) / (int) Math.pow(10, j);
            ArrayList<Integer> bucket = buckets.get(digit);
            bucket.add(list.get(j));
            buckets.set(digit, bucket);
        }
        // Move data from the buckets back to the list
        int k = 0;
        for (int i = 0; i < buckets.size(); i++) {
            ArrayList<Integer> bucket = buckets.get(i);
            for (int j = 0; j < bucket.size(); j++){
                list.set(k++, bucket.get(j));
            }
        }
        buckets.clear(); // for next iteration
    }
}
