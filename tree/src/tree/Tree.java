package tree;

public class Tree {
	int array[];
	int smallArray[];
	int bigArray[];
	int divArray[];

	//int smallLength = getSmallArray().length;
	public static void main(String[] args) {
		Tree t = new Tree();
		t.getArray();
		t.getBigArray();
		t.getSmallArray();
		t.getDivArray();
		int interval=0;
		int l = t.smallArray.length;
		
			for (int j=0; j < t.divArray.length; j++){
				int midpoint=0;
				interval = 26/t.divArray[j];
				for(int i =0; i < t.divArray[j]; i++){
					
					//midpoint = midpoint + interval;
					if(midpoint != interval){
						t.insert(midpoint, i);
						//System.out.println(midpoint);
					}
				}
			}
		
		
		/*
		for(int i=0; i < t.getArray().length;i++ ){
			t.getArray()[i] = 0;
			
		}
		for(int i=0; i < t.getSmallArray().length; i++){
			System.out.println("array val "+t.getSmallArray()[i]+"\nindex "+ i);
			t.insert(t.getSmallArray()[i], i);
		}
		for(int i=0; i < t.array.length;i++ ){
			System.out.println(t.array[i]);
		}
		
		
		 */
		//t.display(t.array);
		
		//TODO you now have what you need to devide 26 by for each row
		//now you need to use the div array to figure out the midpoints in each section
		//somehow
	}
	
	public int[] getDivArray(){
		int a = (int) Math.ceil(Math.log(smallArray.length) / Math.log(2));
		divArray = new int [a+1];		
		for (int i=0; i < a+1; i++){
			if(i==0){
			divArray[i] = getNextNum(i+1);
			}else{
			divArray[i] = getNextNum(divArray[i-1]);
			}
			//System.out.println(divArray[i]);

		}
		return divArray;
	}
	public int getNextNum(int num){
		
		if(num == 1){
			return 2;
		}
		if(num < 12){
		num = (num * 2)-1;
		}
		return num;
	}
	
	public void insert(int val, int pos){
		System.out.println("array val " + val);
		if(array[pos] == 0){
			array[pos] = val;
		}
		if(val == array[pos]){
			
		}else{
			if(val < array[pos]){
				insert(val,getLeft(pos));
			}else{
				if(val > array[pos]){
					insert(val,getRight(pos));
				}				
			}
		}
	}
	public int getLeft(int pos){
		return pos*2;
	}
	public int getRight(int pos){
		return (pos*2)+1;
	}
	public static void display(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(" hi");

			System.out.print(arr[i] + " ");
		}
	}

	public int[] getArray(){

		//int a = (int) Math.ceil(Math.log(smallArray.length) / Math.log(2));
		// now we have the height of the array and with the height we have the size

		int size = (int) Math.pow(2, 5);
		array = new int [size];
		//now we have the final array
		//array size 32
	
		return array;
	}
	public int [] getSmallArray(){
		int count=0;
		int k=0;
		for(int i=0; i < bigArray.length; i++){
			if(bigArray[i] != 0){
				count++;
			}
		}	
		
		smallArray = new int [count];
		 
		for(int i=0; i < bigArray.length; i++){
			if(bigArray[i] != 0){
				smallArray[k]= bigArray[i];
				k++;
			}
		}
		//now we have an array of only the relevant numbers

		return smallArray;
	}
	public int[] getBigArray(){
		int bigSize = (int) Math.pow(2, 26);
		bigArray = new int[bigSize];
		int val = 26;

		for (int i = 0; i < 26; i++) {

			int bigIndex = (int) Math.pow(2, i);
			bigArray[bigIndex] = val;
			val--;
		}
		
		// ////////////////unbalanced array completed!//////////////////////
		return bigArray;
	}
	public int findMidUp(int minPos, int maxPos){
		int val = maxPos - minPos;
		val = (int) Math.ceil(val / 2);
		val = maxPos - val;
		return val;
	}
	public int findMidDn(int minPos, int maxPos){
		int val = maxPos - minPos;
		val = (int) Math.ceil(val / 2);
		val = minPos - val;
		return val;
	}
}









        public Node fillBST(int arr[]){
            return fillBST(arr,0,arr.length-1);
        }
        public Node fillBST(int[] arr, int start, int end){
            if(start > end)
                return null;
            int mid = (start+end+1)/2;
            Node n = new Node (arr[mid]);
            
            
            
            n.setLeft(fillBST(arr, start,mid-1));
            
            n.setRight(fillBST(arr, mid+1,end));

            return n;
        }
	public void display(Node n){
            if(n == null){
            return;
            }          
            System.out.print(n.getData() + " ");
            display(n.getRight());
            //display(n.getLeft());
	}