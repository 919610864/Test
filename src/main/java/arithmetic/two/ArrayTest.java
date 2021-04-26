package arithmetic.two;

/**
 * �Զ��弯��,������
 */
public class ArrayTest {
	
	private int size;		//����ĳ���
	private int data[];
	private int index;		//��ǰ�Ѿ�������ݴ�С
	
	public ArrayTest(int size){		//����ĳ�ʼ������
		this.size = size;
		data = new int[size];		//������ڴ�ռ�{0,0,0,0,0}
		index = 0;
	}
	
	public void print(){
		System.out.println("index:" + index);
		for(int i = 0 ; i < index ; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	/**
	 * ����
	 * @param loc:�±�
	 * @param n:Ԫ��
	 */
	public void insert(int loc,int n){		//ʱ�临�Ӷ� O(n);
		if(index ++ < size){
			for(int i = size - 1; i > loc ; i --){	//Ϊʲô����дsize 0~size-1 ���loc��0 O(n),O(1)=>O(n)
				data[i] = data[i - 1];	//������������һ��
			}
			data[loc] = n;
		}
		//���� ���size*2 0.75 
	}
	public void delete(int loc){	//O(n)
		for(int i = loc ; i < size ; i++){
			if(i != size - 1){		//��Խ�����Լ�һ���ж�
				data[i] = data[i + 1];
			}else{
				data[i] = 0;			//Ĭ��Ϊ0 ����û�����ݵ�
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
