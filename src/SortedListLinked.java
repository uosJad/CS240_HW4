
public class SortedListLinked<T> implements SortedListInterface<T> {

	private Node first, last; 
	private int numOfItems;
	 
	private final int MAX_SIZE = 10000;
	
	public SortedListLinked(){
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
	
	

	public void add(T newEntry) {
		Node b = last;
		Node prev = null;
		while(b.data > newEntry){
			prev = b;
			b = b.adr;
		}
		
		if (prev.data == null){
			Node temp = new Node(b, newEntry);
			last = temp;
		}
		else if (b == null){
			Node temp = new Node(null, newEntry);
			prev.adr = temp;
			first = temp;
		}
		else{
			Node temp = new Node(b, newEntry);
			prev.adr = temp;
		}
		
		numOfItems++;		
	}

	@Override
	public boolean remove(T anEntry) {
		boolean r = false;
		Node prevTemp = null;
		Node b = last;
		Node temp = null;
		int count = 0;
			
		while (numOfItems - 1 - count > -1){ // get current and previous
			prevTemp = temp;
			b = b.adr;
			count++;
			if (b.data == anEntry) temp = b;
		}
		
		if (temp != null) {
			r = true;
			
			if (prevTemp == null) {
				last = temp.adr;
			}
			else if(temp == first) {
				first = prevTemp;
				prevTemp.adr = temp.adr;
			}
			else{
				prevTemp.adr = temp.adr;
			}
			
			temp.adr = null;
			temp.data = null;
			numOfItems--;
		}
			
		
	
		return r;
		
	}

	@Override
	public int getPosition(T anEntry) {
		Node b = last;
		int pos = -1;
		int count = 0;
			
		while (numOfItems - 1 - count > -1){ // get current and previous
			b = b.adr;
			count++;
			if (b.data == anEntry) pos = numOfItems - 1 - count; // saves pos
		}
		
		return pos;
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
	public boolean contains(T anEntry) {
		boolean r = false;
		Node b = last;
		int count = 0;
			
		while (numOfItems - 1 - count > -1){ // get current and previous
			b = b.adr;
			count++;
			if (b.data == anEntry){
				r = true;
				break;
			}
		}
		
		return r;
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
	public int getLength() {
		return numOfItems;
	}

	@Override
	public boolean isEmpty() {
		boolean r = false;
		if (numOfItems == 0) r = true;
		return false;
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
}
