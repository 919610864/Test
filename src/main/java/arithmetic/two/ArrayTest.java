package arithmetic.two;

/**
 *
 */
public class ArrayTest {
	
	private int size;		//
	private int data[];
	private int index;		//
	
	public ArrayTest(int size){		//
		this.size = size;
		data = new int[size];
		index = 0;
	}
	
	public void print(){
		System.out.println("index:" + index);
		for(int i = 0 ; i < index ; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}


	public void insert(int loc,int n){		// O(n);
		if(index ++ < size){
			for(int i = size - 1; i > loc ; i --){
				data[i] = data[i - 1];	//
			}
			data[loc] = n;
		}
	}
	public void delete(int loc){	//O(n)
		for(int i = loc ; i < size ; i++){
			if(i != size - 1){		//
				data[i] = data[i + 1];
			}else{
				data[i] = 0;			//
			}
		}
		index -- ;
	}
	
	public void update(int loc,int n){//O(1)
		data[loc] = n;
	}
	
	public int get(int loc){		//O(1)
		return data[loc];
	}
	
	
	public static void main(String[] args) {
		//ArrayList

		int oldCapacity = 10;
		int newCapacity = oldCapacity + (oldCapacity >> 1);

		System.out.println(newCapacity);
		String s1 = "ja";
		String s2 = "va";
		String s3 = "java";
		String s4 = s1 + s2;
		String s5 = "j" + "a" + "v" + "a";
		System.out.println(s3 == s5);
		System.out.println(s3 == s4);
	}
}
