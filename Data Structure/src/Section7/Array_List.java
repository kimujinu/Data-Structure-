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
        for (int i = size - 1; i >= index; i--) {        // 엘리먼트 중간에 데이터를 추가하기 위해서는 끝의 엘리먼트부터 index의 노드까지 뒤로 한칸씩 이동시켜야 합니다.
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;        // index에 노드를 추가합니다.
        size++;        // 엘리먼트의 숫자를 1 증가 시킵니다.
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
        Object removed = elementData[index];        // 엘리먼트를 삭제하기 전에 삭제할 데이터를 removed 변수에 저장합니다.
        for (int i = index + 1; i <= size - 1; i++) {        // 삭제된 엘리먼트 다음 엘리먼트부터 마지막 엘리먼트까지 순차적으로 이동해서 빈자리를 채웁니다.
            elementData[i - 1] = elementData[i];
        }
        size--;   // 크기를 줄입니다.
        elementData[size] = null;        // 마지막 위치의 엘리먼트를 명시적으로 삭제해줍니다. 
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
 
    public ListIterator listIterator() {        // ListIterator 인스턴스를 생성해서 리턴합니다.
        return new ListIterator();
    }
 
     
 
    class ListIterator {
        private int nextIndex = 0;        // 현재 탐색하고 있는 순서를 가르키는 인덱스 값
        public boolean hasNext() {        // next 메소르를 호출할 수 있는지를 체크합니다.
            return nextIndex < size();            // nextIndex가 엘리먼트의 숫자보다 적다면 next를 이용해서 탐색할 엘리먼트가 존재하는 것이기 때문에 true를 리턴합니다. 
        }
         
        public Object next() {        // 순차적으로 엘리먼트를 탐색해서 리턴합니다. 
            return elementData[nextIndex++];            // nextIndex에 해당하는 엘리먼트를 리턴하고 nextIndex의 값을 1 증가 시킵니다.
        }
         
        public boolean hasPrevious(){        // previous 메소드를 호출해도 되는지를 체크합니다.
            return nextIndex > 0;            // nextIndex가 0보다 크다면 이전 엘리먼트가 존재한다는 의미입니다.
        }
         
        public Object previous(){        // 순차적으로 이전 노드를 리턴합니다.
            return elementData[--nextIndex];            // 이전 엘리먼트를 리턴하고 nextIndex의 값을 1감소합니다. 
        }
         
        public void add(Object element){        // 현재 엘리먼트를 추가합니다. 
            ArrayList.this.add(nextIndex++, element);
        }
        public void remove(){        // 현재 엘리먼트를 삭제합니다. 
            ArrayList.this.remove(nextIndex-1);
            nextIndex--;
        }
         
 
    }
 
}