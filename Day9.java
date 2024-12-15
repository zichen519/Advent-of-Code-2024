import java.util.*;
import java.io.*;
public class Day9 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//read input
		Scanner in = new Scanner(new File("Day9.txt"));
		
		List<Integer> disk = new ArrayList<>();
		int id = 0;
		boolean space = false;
		char[] input = in.next().toCharArray();
		
		//turn input into an array of ids (-1 for blank)
		
		for(char n : input) {
			int x = Character.getNumericValue(n);
			
			if(space) {
				for(int i = 0; i < x; i++) {
					disk.add(-1);
				}
				space = !space;
			}else {
				for(int i = 0; i < x; i++) {
					disk.add(id);
					
					
					
				}
				id++;
				space=!space;
			}
			
		}
		//reverse loop looking for files
		for(int i = disk.size()-1; i >=0;i--) {
			if(disk.get(i)!=-1) {
				//get length of the file block
				if(i<disk.size()-1&&disk.get(i)== disk.get(i+1)) continue;
				int len = 0;
				for(int j = i; j >= 0; j--) {
					if(disk.get(j)== disk.get(i)) {
						len++;
					}
					else break;
				}
				
				
				
				for(int j = 0; j < disk.size(); j++) {
					//stop moving files to the right
					if(j>i) break;
					//search for empty blocks big enough
					if(disk.get(j)==-1) {
						if(j>0&&disk.get(j-1)==-1)continue;
						int spaceLen = 0;
						int spaceIndex = j;
						while(spaceIndex<disk.size()&&disk.get(spaceIndex)==-1) {
							spaceLen ++;
							spaceIndex++;
						}
						
						//swap the blocks
						if(spaceLen>=len) {
							
							for(int k = 0; k < len; k++) {
								int temp = disk.get(i-k);
								disk.set(i-k, -1);
								disk.set(j+k, temp);
							}
							break;
						}
						
						
					}
				}
				
			}
			
			
		}
		
		//get final result
		long sum = 0;
		
		for(int i = 0; i < disk.size(); i++) {
			if(disk.get(i)!=-1) {
				sum+= i*disk.get(i);
			}
		}
		System.out.println(sum);
 	}

}
