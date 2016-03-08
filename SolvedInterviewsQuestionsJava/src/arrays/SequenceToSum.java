package arrays;

/*Given an integer, return all sequences of numbers that sum to it. (Example: 3 -> (1, 2), (2, 1), (1, 1, 1)).*/

map<int, vector<vector<int> > > mem;

vector<vector<int> > getSums(int num) {
	if(num == 0) return vector<vector<int> >();
	if(mem.find(num) != mem.end()) return mem[num];

	int mid = num/2;

	vector<vector<int> > res;
	
	res.push_back(vector<int>(1, num));
	
	for(int i = 1; i <= mid; i++) {
		vector<vector<int> > v1 = getSums(i);
		vector<vector<int> > v2 = getSums(num-i);
		
		for(int a = 0; a < v1.size(); a++) {
			for(int b = 0; b < v2.size(); b++) {
				vector<int> tmp1 = v1[a], tmp2 = v2[b];
				tmp1.insert(tmp1.end(), v2[b].begin(), v2[b].end());
				tmp2.insert(tmp2.end(), v1[a].begin(), v1[a].end());
				
				res.push_back(tmp1);
				res.push_back(tmp2);
			}
		}
	}

	vector<vector<int> > ret;
	map<vector<int>, bool> vis;
	
	for(int i = 0; i < res.size(); i++) {
		if(vis.find(res[i]) == vis.end()) {
			ret.push_back(res[i]);
			vis[res[i]] = true;
		}
	}
	
	mem[num] = ret;
	
	return ret;
}


public class SequenceToSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
