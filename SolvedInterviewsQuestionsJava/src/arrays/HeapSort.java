package arrays;

public class HeapSort {
	
	private Integer[] array;
	private int heapSize;
	public HeapSort(Integer[] _array){
		super();
		this.array=_array;
		this.setHeapSize(array.length);
	}
	public Integer[] getArray() {
		return array;
	}
	public int getHeapSize() {
		return heapSize;
	}
	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}
	
	private int parent(int i){
		//return (int)Math.floor((i-1)/2);
		//return (i-1)/2;
		//System.out.println("parent->"+array[i/2]+"-->index="+i/2);
		return i/2;
	}
	private int left(int i){
		//System.out.println("Left CHild->"+"array[2*i]"+"-->index="+2*i);
		return 2*i;//2*i+1;//2*(i+1);//2*i;//i<<1;    //2*i
	}
	private int right(int i){
		//System.out.println("Right Child->"+"array[2*i+1]"+"-->index="+(2*i+1));
		return 2*i+1;//2*i+2;//2*(i+2);//2*i+1; //i<<1+1;   //2*i+1
	}
	public void maxHeapify(int i){
		int leftChild=left(i);
		int rightChild=right(i);
		//int length=this.array.length;
		int largest;
		if (leftChild<getHeapSize() && this.array[leftChild]>this.array[i]){
			largest=leftChild;
		}else{
			largest=i;
		}
		if(rightChild<getHeapSize() && this.array[rightChild]>this.array[largest]){
			largest=rightChild;
		}
		if (largest!=i){
			int temp=this.array[i];
			this.array[i]=array[largest];
			array[largest]=temp;
			maxHeapify(largest);			
			
		}
				
	}
	public void buildMaxHeap(){
		//int len=this.array.length;
		//setHeapSize(len);
		//for(int i=len/2;i>=0;i--)
		for(int i=getHeapSize()/2;i>=0;i--)
		{
			maxHeapify(i);
		}
		//printArray();
	}
	public void sort(){
		buildMaxHeap();
		printArray();
		for(int i=this.array.length-1;i>=1;i--){
			int temp=this.array[0];
			this.array[0]=this.array[i];
			this.array[i]=temp;
			setHeapSize(i-1);
			maxHeapify(0);
			
		}
	}
	public void printArray()
	{
		for(int i=0;i<this.array.length;i++)
		{
			System.out.print(this.array[i]+" ");
			
		}
		System.out.println();
	}

}
