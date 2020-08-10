package Section8;

import java.util.LinkedList;

public class Hash_table {
	//Hash : ���� ���� ���� ���̷� ��ȯ�ϴ� ��
	//Hash table : Ű ���� ���꿡 ���� ���� ������ ������ ������ ����
	//Hashing Function : Key�� ���� ��� ������ �̿��� ������ ��ġ�� ã�� �� �ִ� �Լ�
	//Hash Value or Hash Address : Key�� �ؽ� �Լ��� �����ؼ�, �ؽ� ���� �˾Ƴ���, 
	//							     �̸� ������� �ؽ� ���̺��� �ش� Key�� ���� ������ ��ġ�� �ϰ����ְ� ã�� �� ����
	//Slot : �� ���� �����͸� ������ �� �ִ� ����
	//������ �����Ϳ� ���� Key�� ������ �� �ִ� ���� �Լ��� ������ �� ����.
	LinkedList<Hash>[] data;
	    
	public Hash_table(int size) {
	    this.data = new LinkedList[size];
    }
	    
	public int getHashCode(String key) {
	   int hashCode = 0;
	   for(char c : key.toCharArray()) {      
	        hashCode += c;
	   }
	   return hashCode;
	}
	    
    public int convertToIndex(int hashCode) {
       return hashCode % data.length;
	}
	    
	Hash searchKey(LinkedList<Hash> list, String key) {
	    if(list == null) return null;
	        
	   for(Hash node : list) {
	   if(node.key.equals(key)) {
	                
	         return node;
	      }
	  }
	        return null;
	 }
	    
	 public void put(String key, String value) {
	     int hashCode = getHashCode(key);
	     int index = convertToIndex(hashCode);
	        
	     LinkedList<Hash> list = data[index];
	        
	     if(list == null) {
	         list = new LinkedList<Hash>();
	         data[index] = list;
	     }
	        
	     Hash hash = searchKey(list, key);
	        
	     if(hash == null) {
	        list.addLast(new Hash(key, value));
	     } else {
	    	 hash.setValue(value);
	     }
	}
	    
	 public String get(String key) {
	     int hashCode = getHashCode(key);
	     int index = convertToIndex(hashCode);
	     LinkedList<Hash> list = data[index];
	     Hash node = searchKey(list, key);
	        
	     return node == null ? "Not found" : node.getValue();
	 }
	    
class Hash {
	     String key;
	     String value;
	        
	   public Hash(String key, String value) {
	         this.key = key;
	         this.value = value;
	   }
	        
	   public String getValue() {         
	         return this.value;
	   }
	        
	   public void setValue(String value) {          
	         this.value = value;
	   }
	 }
}

