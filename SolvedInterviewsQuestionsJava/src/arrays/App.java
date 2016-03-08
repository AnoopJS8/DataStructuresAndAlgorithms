package arrays;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Integer[] arr=new Integer[]{4,1,3,2,16,9,10,14,8,7,21,42,11,0};
		Integer[] arr=new Integer[]{4,1,3,2,16,9,10,14,8,7,21};
		
		HeapSort heapsort=new HeapSort(arr);
		
		System.out.println("Before Sorting");
		heapsort.printArray();
		
		heapsort.sort();
		
		System.out.println("After Sorting");
		heapsort.printArray();

	}

}
