package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		boolean isEmpty = false;
		if (head.isNIL()) {
			isEmpty = true;
		}
		return isEmpty;
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = head;
		while (!aux.isNIL()) {
			if (!isEmpty()) {
				size++;
			} else {

			}
			aux = aux.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = head;
		T result = null;
		if (!isEmpty()) {
			while (!aux.data.equals(element)) {
				if (element.equals(aux.data)) {
					result = aux.data;
				}
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> aux = head;
		if (head.isNIL()) {
			head = new SingleLinkedListNode(element, new SingleLinkedListNode<>());
		} else {
			while (!aux.next.isNIL()) {
				aux = aux.next;
			}
			aux.next = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
		}
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> aux = head;
		SingleLinkedListNode<T> previous = null;
		if (head.data.equals(element)) {
			head = head.next;
		} else {
			while (!aux.isNIL() && (!aux.next.data.equals(element))) {
				previous = aux;
				aux = aux.next;
			}
		}
		if (!aux.isNIL()) {
			previous.next = aux.next;
		}
	}

	@Override
	public T[] toArray() {
		int tamanho = size();
		T[] result = (T[]) new Object[tamanho];
		int count = 0;
		SingleLinkedListNode<T> aux = head;
		while (!aux.isNIL()) {
			result[count] = aux.data;
			aux = aux.next;
			count++;
		}
		return result;

	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
	
}
