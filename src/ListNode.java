
public class ListNode<T> implements ListInterface<T>{
	
	private Node first, last; 
	private int numOfItems;
	
	private final int MAX_SIZE = 10000;
	
	public ListNode(){
		first = null;
		last = null;
		numOfItems = 0;
	}
	
	private class Node{
		private Node adr;
		private T data;
		
		public Node(Node a, T d){
			adr = a;
			data = d;
		}
	}
	
	@Override
	public void add(T newEntry) {
		if(numOfItems + 1 <= this.MAX_SIZE){
			if (first == null){
				first = new Node(null, newEntry);
				last = first;
			}
			else{
				last = new Node(last, newEntry);
			}
			numOfItems++;
		}
	}

	@Override
	public void add(int newPosition, T newEntry) {
		if(numOfItems + 1 <= this.MAX_SIZE && newPosition <= numOfItems && newPosition > -1){
			Node temp = last;
			int count = 0;
			
			while (numOfItems - 1 - count != newPosition){
				temp = temp.adr;
				count++;
			}
			Node toPoint = temp.adr;
			Node newNode = new Node(toPoint, newEntry);
			temp.adr = newNode;
			
			if (newPosition == 0) first = newNode;
			else if(newPosition == numOfItems) last = newNode;
			
			numOfItems++;
		}
		
	}

	@Override
	public T remove(int givenPosition) {
		T tempVal = null;
		if(givenPosition < numOfItems && givenPosition > -1){
			Node prevTemp = null;
			Node temp = last;
			int count = 0;
			
			while (numOfItems - 1 - count != givenPosition){ // get current and previous
				prevTemp = temp;
				temp = temp.adr;
				count++;
			}
			
			if (givenPosition == numOfItems - 1) {
				last = temp.adr;
				tempVal = temp.data;
			}
			else if(givenPosition == 0) {
				first = prevTemp;
				prevTemp.adr = temp.adr;
				tempVal = temp.data;
			}
			else{
				prevTemp.adr = temp.adr;
				tempVal = temp.data;
			}
			
			temp.adr = null;
			temp.data = null;
			
			numOfItems--;
			
		}
		return tempVal;
	}

	@Override
	public void clear() {
		first = null;
		last = null;
		numOfItems = 0;
		
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		Node temp = last;
		T tempVal = null;
		if(givenPosition < numOfItems && givenPosition > -1){
			int count = 0;
			
			while (numOfItems - 1 - count != givenPosition){ // get current
				temp = temp.adr;
				count++;
			}
			
			tempVal = temp.data;
			temp.data = newEntry;
		}
		return tempVal;
	}

	@Override
	public T getEntry(int givenPosition) {
		Node temp = last;
		if(givenPosition < numOfItems && givenPosition > -1){
			int count = 0;
			
			while (numOfItems - 1 - count != givenPosition){ // get current
				temp = temp.adr;
				count++;
			}
		}
		return temp.data;
	}

	@Override
	public T[] toArray() {
		
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[MAX_SIZE];
		Node b = last;
		for (int i = numOfItems - 1; i >-1; i--){
			temp[i] = b.data;
			b = b.adr;
			if (b == null) break;
		}
		return temp;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean r = false;
		Node b = last;
		for (int i = numOfItems - 1; i >-1; i--){
			if (b.data == anEntry){
				r = true;
				break;
			}
			b = b.adr;
			if (b == null) break;
		}
		return r;
	}

	@Override
	public int getLength() {
		return numOfItems;
	}

	@Override
	public boolean isEmpty() {
		boolean r = false;
		if (numOfItems == 0) r = true;
		return r;
	}

}
