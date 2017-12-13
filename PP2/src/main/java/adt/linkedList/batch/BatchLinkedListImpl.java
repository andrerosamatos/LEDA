package adt.linkedList.batch;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.SingleLinkedListNode;
import util.GenericException;

/**
 * Manipula elementos da LinkedList em bloco (batch).
 * 
 * @author campelo
 * @author adalberto
 *
 * @param <T>
 */
public class BatchLinkedListImpl<T> extends DoubleLinkedListImpl<T> implements BatchLinkedList<T> {

	/*
	 * Nao modifique nem remova este metodo.
	 */
	public BatchLinkedListImpl() {
		head = new DoubleLinkedListNode<T>();
		last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void inserirEmBatch(int posicao, T[] elementos) throws GenericException {
		if (posicao < 0 || posicao > this.size() || elementos == null) {
			throw new GenericException();
		} else {
			DoubleLinkedListNode<T> cNode = (DoubleLinkedListNode<T>) elementos[0];
			cNode.setPrevious(null);

			DoubleLinkedListNode<T> dNode = null;
			DoubleLinkedListNode<T> fNode = (DoubleLinkedListNode<T>) elementos[1];
			DoubleLinkedListNode<T> eNode = null;
			DoubleLinkedList<T> lista = null;
			for (int i = 1; i < elementos.length - 1; i++) {
				dNode = (DoubleLinkedListNode<T>) elementos[i];
				eNode = (DoubleLinkedListNode<T>) elementos[i + 1];
				dNode.setNext(eNode);
				eNode.setPrevious(dNode);
			}
			cNode.setNext(fNode);
			fNode.setPrevious(cNode);
			eNode.setNext(null);

			int count = -1;
			DoubleLinkedListNode<T> aux = null;
			DoubleLinkedListNode<T> proximo = null;

			while (count != posicao) {
				aux = (DoubleLinkedListNode<T>) head.getNext();
				proximo = (DoubleLinkedListNode<T>) aux.getNext();
				count++;
			}
			aux.setNext(cNode);
			cNode.setPrevious(aux);
			eNode.setNext(proximo);
			proximo.setPrevious(eNode);
		}
	}

	@Override
	public void removerEmBatch(int posicao, int quantidade) throws GenericException {
		if (posicao < 0 || posicao > this.size() || quantidade > this.size()) {
			throw new GenericException();
		} else {
			int count = -1;
			DoubleLinkedListNode<T> aux = null;
			DoubleLinkedListNode<T> proximo = null;

			while (count != posicao) {
				aux = (DoubleLinkedListNode<T>) head.getNext();
				proximo = (DoubleLinkedListNode<T>) aux.getNext();
				count++;
			}
			while (quantidade > 1) {
				proximo = (DoubleLinkedListNode<T>) proximo.getNext();
				quantidade--;
			}

			if (proximo.getNext().isNIL()) {
				aux.setNext(null);
			} else {
				aux.setNext(proximo.getNext());
				proximo = (DoubleLinkedListNode<T>) proximo.getNext();
				proximo.setPrevious(aux);
			}
		}
	}

	/*
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo,
	 * comecando a navegacao pelo Head
	 */
	public String toStringFromHead() {

		String result = "";
		DoubleLinkedListNode<T> aNode = (DoubleLinkedListNode<T>) getHead();

		while (!aNode.isNIL()) {

			if (!result.isEmpty()) {
				result += " ";
			}

			result += aNode.getData();
			aNode = (DoubleLinkedListNode<T>) aNode.getNext();

		}

		return result;
	}

	/*
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo,
	 * porem comecando a navegacao pelo Last
	 * 
	 * Este metodo produz o MESMO RESULTADO de toStringFromHead()
	 * 
	 */
	public String toStringFromLast() {

		String result = "";
		DoubleLinkedListNode<T> aNode = getLast();

		while (!aNode.isNIL()) {

			if (!result.isEmpty()) {
				result = " " + result;
			}

			result = aNode.getData() + result;
			aNode = (DoubleLinkedListNode<T>) aNode.getPrevious();

		}

		return result;
	}

	@Override
	public String toString() {
		return toStringFromHead();
	}

}
