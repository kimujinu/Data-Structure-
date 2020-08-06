package Section7;

public class Array_List {

	public static void main(String[] args) {
		Array_List Main = new Array_List();
		Main.start();
	}
	
	public void start() {
		solve();
	}
	
	public void solve() {
		ArrayList numbers = new ArrayList();
		
		numbers.addLast(10);
		numbers.addLast(20);
	    numbers.addLast(30);
		numbers.addLast(40);
		numbers.add(1, 15);
		numbers.addFirst(5);
		System.out.println(numbers);
		
		ArrayList.ListIterator it = numbers.listIterator();
		while (it.hasNext()) {
		    int value = (int) it.next();
		    System.out.println(value);
		}
	}

}
class ArrayList {
    private int size = 0;
    private Object[] elementData = new Object[100];
 
    public ArrayList() {
 
    }
    
    public boolean addLast(Object element) {
        elementData[size] = element;
        size++;
        return true;
    }
     
    public boolean add(int index, Object element) {
        for (int i = size - 1; i >= index; i--) {        // ������Ʈ �߰��� �����͸� �߰��ϱ� ���ؼ��� ���� ������Ʈ���� index�� ������ �ڷ� ��ĭ�� �̵����Ѿ� �մϴ�.
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;        // index�� ��带 �߰��մϴ�.
        size++;        // ������Ʈ�� ���ڸ� 1 ���� ��ŵ�ϴ�.
        return true;
    }
     
    public boolean addFirst(Object element){
        return add(0, element);
    }
 
    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++) {
            str += elementData[i];
            if (i < size - 1)
                str += ",";
        }
        return str + "]";
    }
     
    public Object remove(int index) {
        Object removed = elementData[index];        // ������Ʈ�� �����ϱ� ���� ������ �����͸� removed ������ �����մϴ�.
        for (int i = index + 1; i <= size - 1; i++) {        // ������ ������Ʈ ���� ������Ʈ���� ������ ������Ʈ���� ���������� �̵��ؼ� ���ڸ��� ä��ϴ�.
            elementData[i - 1] = elementData[i];
        }
        size--;   // ũ�⸦ ���Դϴ�.
        elementData[size] = null;        // ������ ��ġ�� ������Ʈ�� ��������� �������ݴϴ�. 
        return removed;
    }   
     
    public Object removeFirst(){
        return remove(0);
    }
 
    public Object removeLast(){
        return remove(size-1);
    }
 
    public Object get(int index) {
        return elementData[index];
    }
 
    public int size() {
        return size;
    }
 
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }
 
    public ListIterator listIterator() {        // ListIterator �ν��Ͻ��� �����ؼ� �����մϴ�.
        return new ListIterator();
    }
 
     
 
    class ListIterator {
        private int nextIndex = 0;        // ���� Ž���ϰ� �ִ� ������ ����Ű�� �ε��� ��
        public boolean hasNext() {        // next �޼Ҹ��� ȣ���� �� �ִ����� üũ�մϴ�.
            return nextIndex < size();            // nextIndex�� ������Ʈ�� ���ں��� ���ٸ� next�� �̿��ؼ� Ž���� ������Ʈ�� �����ϴ� ���̱� ������ true�� �����մϴ�. 
        }
         
        public Object next() {        // ���������� ������Ʈ�� Ž���ؼ� �����մϴ�. 
            return elementData[nextIndex++];            // nextIndex�� �ش��ϴ� ������Ʈ�� �����ϰ� nextIndex�� ���� 1 ���� ��ŵ�ϴ�.
        }
         
        public boolean hasPrevious(){        // previous �޼ҵ带 ȣ���ص� �Ǵ����� üũ�մϴ�.
            return nextIndex > 0;            // nextIndex�� 0���� ũ�ٸ� ���� ������Ʈ�� �����Ѵٴ� �ǹ��Դϴ�.
        }
         
        public Object previous(){        // ���������� ���� ��带 �����մϴ�.
            return elementData[--nextIndex];            // ���� ������Ʈ�� �����ϰ� nextIndex�� ���� 1�����մϴ�. 
        }
         
        public void add(Object element){        // ���� ������Ʈ�� �߰��մϴ�. 
            ArrayList.this.add(nextIndex++, element);
        }
        public void remove(){        // ���� ������Ʈ�� �����մϴ�. 
            ArrayList.this.remove(nextIndex-1);
            nextIndex--;
        }
         
 
    }
 
}