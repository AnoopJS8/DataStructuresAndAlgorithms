package arrays;

/*public class RotateArray {

}
TestCase: [1,2,3,4,5,6,7]
5

[3,4,5,6,7,1,2]

[1,2,3,4,5,6,7]
3

Solution
[5,6,7,1,2,3,4]


*/
public class RotateArray {
/*    public void rotate(int[] nums, int k) {
        int swaps=0;
        int len=nums.length;
        int i=0;
        k+=1;
        while(swaps<len/2){
            int temp;
            temp=nums[i];
            nums[i]=nums[i+k%len];
            nums[i+k%len]=temp;
            i++;
            swaps++;
            for(int it:nums)
            System.out.print(it+" ");
        System.out.println();
            
        }
        //for(int it:nums)
          //  System.out.print(it+" ");
        //System.out.println();
    }*/
    public void rotate(int[] nums, int k) {
        int[] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[(i+k)%nums.length]=nums[i];
            //System.out.println((i+k)%(nums.length));
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=temp[i];
        }
        //System.out.println();
        
    }
}