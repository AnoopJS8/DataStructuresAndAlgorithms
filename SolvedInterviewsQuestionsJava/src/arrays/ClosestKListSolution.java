package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class CPoint {
	public double x;
	public double y;

	public CPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class ClosestKList {

	public static CPoint[] closestK(CPoint[] mylist, int K) {
		CPoint[] listK = new CPoint[K];
		for (int i = 0; i < K; i++) {
			listK[i] = new CPoint(0, 0);
		}

		Double[] dist = new Double[mylist.length];
		// Map<CPoint,Double> map=new HashMap<>(); since no two distances are
		// same i can use distance as key
		Map<Double, CPoint> map = new HashMap<>();
		for (int i = 0; i < mylist.length; i++) {
			dist[i] = distance(mylist[i]);
			map.put(dist[i], mylist[i]);
		}
		Arrays.sort(dist);
		for (int i = 0; i < K; i++) {
			listK[i] = map.get(dist[i]);
		}
		//sorting the array in descending order
		/*Arrays.sort(dist,new Comparator(){
			
		});*/
		for(int i=0;i<dist.length;i++)
			System.out.print(dist[i]+" ");
		System.out.println();
		/*--------------To Sort in Descending Order------------------*/
		//Arrays.sort(dist,Collections.reverseOrder());//This works
		Arrays.sort(dist,new Comparator<Double>(){

			@Override
			public int compare(Double o1, Double o2) {
				// TODO Auto-generated method stub
				return (int)(o2-o1);
			}

			/* This is not proper--->
			 * @Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return (int)((Double)o1-(Double)o2);
			}
			 * */
			
		});
		
		for(int i=0;i<dist.length;i++)
			System.out.print(dist[i]+" ");
		System.out.println();
		
		return listK;
	}

	public static double distance(CPoint point) {
		return Math.sqrt((Math.pow(point.x, 2) + Math.pow(point.y, 2)));
	}
}

public class ClosestKListSolution {
	public static void main(String[] args) {

		CPoint[] cpoint=new CPoint[5];
		cpoint[0]=new CPoint(5,5);cpoint[1]=new CPoint(4,4);
		cpoint[2]=new CPoint(3,3);cpoint[3]=new CPoint(2,2);
		cpoint[4]=new CPoint(1,1);
		
		for(int i=0;i<5;i++){
			System.out.print(cpoint[i].x+","+cpoint[i].y+" ");
		}
		System.out.println();
		cpoint=ClosestKList.closestK(cpoint,2);
		for(int i=0;i<2;i++){
			System.out.print(cpoint[i].x+","+cpoint[i].y+" ");
		}
		
	}

}
