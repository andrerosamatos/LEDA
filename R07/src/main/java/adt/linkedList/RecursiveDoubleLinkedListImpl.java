package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insertFirst(T element) {
		if (isEmpty()) {
			data = element;
			next = new RecursiveDoubleLinkedListImpl<>();
		} else {
			RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<T>(data, next, this);
			data = element;
			next = aux;
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			data = next.data;
			next = next.next;
		}
	}

	@Override
	public void removeLast() {
		removeLast(this);
		
	}
	
	private void removeLast(RecursiveSingleLinkedListImpl<T> node) {
		if (next.next == null) {
			next = next.next;
		} else {
			removeLast(this.next);
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
