
public class ListArray<T> implements ListInterface<T>{

	private T[] arr;
	private int numOfItems;
	
	private final int MAX_SIZE = 10; 
	
	public ListArray(){
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[this.MAX_SIZE];
		arr = temp;
		numOfItems = 0;
	}
	
	
	@Override
	public void add(T newEntry) {
		if (numOfItems + 1 <= 10){
			arr[numOfItems] = newEntry;
			numOfItems++;
		}
	}

	@Override
	public void add(int newPosition, T newEntry) {
		if (numOfItems + 1 <= 10 && newPosition <= numOfItems && newPosition > -1){
			for (int i = numOfItems - 1; i > newPosition - 1; i--){
				arr[i+1] = arr[i];
			}
			arr[newPosition] = newEntry;
			numOfItems++;
		}
		
	}

	@Override
	public T remove(int givenPosition) {
		T temp = null;
		if (givenPosition < numOfItems && givenPosition > -1){
			arr[givenPosition] = null;
			for (int i = givenPosition; i < givenPosition + 1; i++){
				arr[i] = arr[i+1];
			}
		}
		
		return temp;
	}

	@Override
	public void clear() {
		for (int i = 0; i < numOfItems; i++){
			arr[i] = null;
		}
		numOfItems = 0;
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		T temp = null;
		if (givenPosition < numOfItems && givenPosition > -1){
			temp = arr[givenPosition];
			arr[givenPosition] = newEntry;
		}
		return temp;
	}

	@Override
	public T getEntry(int givenPosition) {
		T temp = null;
		if (givenPosition < numOfItems && givenPosition > -1){
			temp = arr[givenPosition];
		}
		return temp;
	}

	@Override
	public T[] toArray() {
		
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[this.MAX_SIZE];
		for (int i = 0; i < numOfItems; i++){
			temp[i] = arr[i];
		}
		return temp;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean r = false;
		for (int i = 0; i < numOfItems; i++){
			if (arr[i] == anEntry){
				r = true;
				break;
			}
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
