package greedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

//class Activity implements Comparator<Activity> {
class Activity implements Comparable<Activity> {
	int startTime;
	int finishTime;

	public Activity(int start, int end) {
		this.startTime = start;
		this.finishTime = end;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int endTime) {
		this.finishTime = endTime;
	}

	@Override
	public String toString() {
		return "activity [startTime=" + startTime + ", endTime=" + finishTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + finishTime;
		result = prime * result + startTime;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (finishTime != other.finishTime)
			return false;
		if (startTime != other.startTime)
			return false;
		return true;
	}

	/*@Override
	public int compare(Activity a1, Activity a2) {
		// TODO Auto-generated method stub

		if (a1.getFinishTime() < a2.getFinishTime()) {
			return -1;
		} else if (a1.getFinishTime() > a2.getFinishTime()) {
			return 1;
		} else {
			return 0;
		}
	}*/

	@Override
	public int compareTo(Activity a) {
		// TODO Auto-generated method stub
		return this.finishTime-a.finishTime;
	}

}

public class ActivitySelectionProblem {
	
	public static Set<Activity> greedyActivitySelector(List<Activity> activities,Set<Activity> set){
		int n=activities.size();
		set.add(activities.get(0));
		int k=0;
		for(int m=1;m<n;m++){
			if(activities.get(m).startTime>=activities.get(k).finishTime){//if(activities[m].startTime>=activities[k].finishTime){
				set.add(activities.get(m));
				k=m;
			}
		}
		
		return set;
	}

	public static void main(String[] args) {
		Activity[] activities = new Activity[11];

		/*for (int i = 0; i < activities.length; i++) {
			activities[i] = new Activity(i, 5-i );
		}*/
		activities[0]=new Activity(1,4);activities[1]=new Activity(3,5);activities[2]=new Activity(0,6);
		activities[3]=new Activity(5,7);activities[4]=new Activity(3,9);activities[5]=new Activity(5,9);
		activities[6]=new Activity(6,10);activities[7]=new Activity(8,11);activities[8]=new Activity(8,12);
		activities[9]=new Activity(2,14);activities[10]=new Activity(12,16);//activities[11]=new Activity(1,4);
		
		List<Activity> list=new ArrayList<Activity>();
		for (Object obj : activities) {
			list.add((Activity)obj);
			System.out.print((Activity) obj+" ");
		}
		
		System.out.println();
		
		//Arrays.sort(activities);
		Collections.sort(list);
		for (Object obj : list) {

			System.out.println((Activity) obj);
		}
		//Set<Activity> set= new HashSet<>();
		Set<Activity> set= new LinkedHashSet<>();
		set=greedyActivitySelector(list, set);
		System.out.println(set.size());
		System.out.println();
		for(Activity act:set){
			System.out.print(act);
		}
		

	}
}
