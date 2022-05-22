
/**
 * Liz Attumalil
 * 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Comparator;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		List<Country>[] lists = (List<Country>[]) new List[3];
		lists[0] = new ArrayList<>();
		lists[1] = new LinkedList<>();
		lists[2] = new Stack<>();
		
		readData(lists, "countries.txt");
		for(int i=0; i<lists.length; i++) {
			System.out.println("List " + (i+1) + ": ");
			printList(lists[i]);
		}
		int index = (int)(Math.random() * lists[0].size());
		for(int i=0; i<lists.length; i++) {
			Country c = new Country("", "United States", 0.0);
			int found = search(lists[i], c);
			if(found == -1) {
				System.out.println(c.getName() + " not found in list " + (i+1));
			}
			else {
				System.out.println(c.getName() + " found in list " + (i+1) + " at index: " + (found+1));
			}
		}
		System.out.println("\nSorting the collections by name");
		for(int i=0; i<lists.length; i++) {
			sort(lists[i], new ComparatorByName());
			System.out.println("List " + (i+1) + ": ");
			printList(lists[i]);
		}
		System.out.println("\nSorting the collections by area");
		for(int i=0; i<lists.length; i++) {
			sort(lists[i], new ComparatorByArea());
			System.out.println("Sorted List " + (i+1) + ": " );
			printList(lists[i]);
		}
		List<Country> all = (List<Country>) ((ArrayList<Country>)lists[0]).clone();
		combineAll(all, lists[1]);
		combineAll(all, lists[2]);
		System.out.println("\nAll lists combined and sorted: ");
		sort(all, new ComparatorByArea());
		printList(all);
		
	}
	
	/**
	 * Method to read a file and populate the array of lists
	 * @param list
	 * @param filename
	 */
	public static void readData(List<Country>[] list, String filename) {
		File file = new File(filename);
		int i = 0;
		try {
			Scanner read = new Scanner(file);
			while(read.hasNextLine()) {
				String line = read.nextLine();
				String[] att = line.split("\\|");
				Country c = new Country(att[0], att[1], Double.parseDouble(att[2]));
				list[i%3].add(c);
				i++;
			}
			read.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
	}
	/**
	 * Generic and Recursive Linear Search method 
	 * @param <E>
	 * @param list list of items to search
	 * @param key the value being searched
	 * @return returns the index where key is found, false otherwise
	 */
	public static <E> int search(List<E> list, E key) {  //Time complexity: O(n)
		int found = 0;

		for (int index = 0; index < list.size(); index++) {
			found = searchHelper(list, key, index);
			if (found != -1) {
				return found - 1;
			}
		}
        return found;

	}

	public static <E> int searchHelper(List<E> list, E key, int index) { 
		Iterator<E> iter = list.iterator();
		E currentElement = null;
		int j = -1;

		while (iter.hasNext() && j < index) {
            currentElement = iter.next();
            j++;
        }

        if (index < list.size()) {
            index++;
            if (currentElement.equals(key)) {
                return index;
            }
        }
        return -1;
	}


	
	/**
	 * Generic Selection Sort method that uses a comparator object
	 * to order the elements in the list
	 * @param <E>
	 * @param list of elements to be sorted
	 * @param c comparator object used to compare the elements in list
	 */
	public static <E> void sort(List<E> list, Comparator<E> c) {  //O(n^2)
		int currentMinIndex;
		E currentMin;
		for (int i=0; i<list.size()-1; i++) {
			currentMinIndex = i;
			currentMin = list.get(i);
			for(int j=i+1; j<list.size(); j++) {
				if(c.compare(currentMin, list.get(j))> 0) {
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}
			list.set(currentMinIndex, list.get(i));
			list.set(i, currentMin);
		}
	
		
	}
	
	/**
	 * Method to add the elements of list2 to list1
	 * @param <E>
	 * @param list1 First list - will be modified
	 * @param list2 Second list - stays unchanged
	 */
	public static <E> void combineAll(List<E> list1, List<E> list2){  //Time complexity: O(n)
		Iterator<E> iter = list2.iterator();

		while(iter.hasNext()) {
			E val = iter.next();
			list1.add(val);
		}
	}
	
	/**
	 * Generic method to print the elements of list one per line
	 * @param <E>
	 * @param list of elements to be printed
	 */
	public static <E> void printList(List<E> list) {
		Iterator<E> iterator = list.iterator();
		System.out.println("[");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("]");
	}
	
}
