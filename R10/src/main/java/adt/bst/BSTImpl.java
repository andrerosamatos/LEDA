package adt.bst;

import org.w3c.dom.Node;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);

	}

	private int height(BTNode<T> node) {
		int height = 0;
		if (node.isEmpty()) {
			height--;
		} else {
			height = Math.max(height(node.getLeft()), height(node.getRight())) + 1;
		}
		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		return (BSTNode<T>) search(this.root, element);
	}

	private BTNode<T> search(BTNode<T> node, T element) {
		BTNode noh = null;
		if (node.isEmpty() || element.equals(node.getData())) {
			noh = node;
		}
		if (element.compareTo(node.getData()) < 0) {
			noh = search(node.getLeft(), element);
		} else {
			noh = search(node.getRight(), element);
		}
		return noh;

	}

	@Override
	public void insert(T element) {
		insert(this.root, element);
	}

	private void insert(BSTNode node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
		} else {
			if (element.compareTo((T) node.getData()) < 0) {
				insert((BSTNode) node.getLeft(), element);
			} else if (element.compareTo((T) node.getData()) > 0) {
				insert((BSTNode) node.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(this.root);

	}

	private BSTNode<T> maximum(BTNode<T> node) {
		if (!node.getRight().isEmpty()) {
			maximum(node.getRight());
		} 
		return (BSTNode<T>) node;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(this.root);
	}

	private BSTNode<T> minimum(BTNode<T> node) {
		BTNode<T> noh = null;
		if (!node.getLeft().isEmpty()) {
			node = minimum(node);
		} else {
			noh = node;
		}
		return (BSTNode<T>) noh;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BTNode noh = this.root;
		if (!noh.getRight().isEmpty()) {
			noh = minimum(noh);
		}
		BTNode nohaux = noh.getParent();
		while (!nohaux.isEmpty() && noh.isEmpty()) {
			noh = nohaux;
			nohaux = nohaux.getParent();
		}
		return (BSTNode<T>) nohaux;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BTNode noh = this.root;
		if (!noh.getLeft().isEmpty()) {
			noh = noh.getLeft();
			noh = maximum(noh);
		}
		return (BSTNode<T>) noh;
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
