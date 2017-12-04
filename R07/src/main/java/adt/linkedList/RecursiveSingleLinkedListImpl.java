package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		boolean isEmpty = false;
		if (data == null) {
			isEmpty = true;
		}
		return isEmpty;
	}

	@Override
	public int size() {
		int tamanho = 0;
		if (!isEmpty()) {
			tamanho = (this.next.size() + 1);
		} else {
			return 0;
		}
		return tamanho;
	}

	@Override
	public T search(T element) {
		T elemento = null;
		if (!isEmpty()) {
			if (data.equals(element)) {
				elemento = element;
			} else {
				elemento = next.search(element);
			}
		}
		return elemento;
		}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			data = element;
			next = new RecursiveSingleLinkedListImpl<>();
		} else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (search(element) != null) {
			if(data.equals(element)) {
				data = next.data;
				next = next.next;
			} else {
				next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[size()];
		int count = 0;
		return toArray(result, count);
	}
	
	private T[] toArray(T[] result, int count) {
		if (!isEmpty()) {
			result[count] = data;
			result = next.toArray(result, count + 1);
		}
		return result;
		
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}
}
