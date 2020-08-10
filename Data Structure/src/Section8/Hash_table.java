package Section8;

import java.util.LinkedList;

public class Hash_table {
	//Hash : 임의 값을 고정 길이로 변환하는 것
	//Hash table : 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조
	//Hashing Function : Key에 대해 산술 연산을 이용해 데이터 위치를 찾을 수 있는 함수
	//Hash Value or Hash Address : Key를 해싱 함수로 연산해서, 해쉬 값을 알아내고, 
	//							     이를 기반으로 해쉬 테이블에서 해당 Key에 대한 데이터 위치를 일관성있게 찾을 수 있음
	//Slot : 한 개의 데이터를 저장할 수 있는 공간
	//저장할 데이터에 대해 Key를 추출할 수 있는 별도 함수도 존재할 수 있음.
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

