package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {

		if (!node.isEmpty()) {
			return height((BSTNode<T>) node.getLeft()) - super.height((BSTNode<T>) node.getRight());
		}

		return 0;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		if (node == null || node.isEmpty()) {
			return;
		}

		int balance = calculateBalance(node);

		if (Math.abs(balance) <= 1) {
			return;
		}

		if (balance > 0) {

			int sonBalance = calculateBalance((BSTNode<T>) node.getLeft());

			if (sonBalance < 0) {
				this.leftRotation((BSTNode<T>) node.getLeft());
			}
			this.rightRotation(node);
		} else {
			int sonBalance = calculateBalance((BSTNode<T>) node.getRight());

			if (sonBalance > 0) {
				this.rightRotation((BSTNode<T>) node.getRight());
			}

			this.leftRotation(node);
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node == null || node.isEmpty()) {
			return;
		}

		BSTNode<T> parent = (BSTNode<T>) node.getParent();

		while (!parent.isEmpty()) {
			rebalance(parent);
			parent = (BSTNode<T>) parent.getParent();
		}
	}

	// AUXILIARY
	protected void leftRotation(BSTNode<T> node) {
		if (node == null) {
			return;
		}
		BSTNode<T> aux = Util.leftRotation(node);
		if (root.equals(node)) {
			root = aux;
		}
	}

	// AUXILIARY
	protected void rightRotation(BSTNode<T> node) {
		if (node == null) {
			return;
		}

		BSTNode<T> aux = Util.rightRotation(node);
		if (this.root.equals(node)) {
			root = aux;
		}

	}

}
