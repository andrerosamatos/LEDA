package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		head = new DoubleLinkedListNode();
		last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode newHead = new DoubleLinkedListNode<>();
		newHead.next = head;
		newHead.previous = null;
		head.previous = newHead;
	}

	@Override
	public void removeFirst() {
		
		if(isEmpty()) {
		
		} else {
			if (previous.isEmpty) {
				
			}
		}
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
