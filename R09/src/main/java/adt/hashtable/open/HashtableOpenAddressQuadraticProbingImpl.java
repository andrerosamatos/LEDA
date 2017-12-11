package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable> extends AbstractHashtableOpenAddress<T> {

   public HashtableOpenAddressQuadraticProbingImpl(int size, HashFunctionClosedAddressMethod method, int c1, int c2) {
      super(size);
      hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
      this.initiateInternalTable(size);
   }

   @Override
   public void insert(T element) {
      int probe = 0;
      boolean adicionou = false;
      while (probe <= this.size() && adicionou == false) {

         int index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
         if (this.table[index] == null || this.table[index].equals(deletedElement)) {
            this.table[index] = element;
            elements++;
            adicionou = true;
         } else {
            probe++;
            COLLISIONS++;
         }
      }
      if (probe > size()) {
         throw new HashtableOverflowException();
      }
   }

   @Override
   public void remove(T element) {
      int probe = 0;
      boolean removeu = false;
      if (element != null) {
         while (probe <= size() && removeu == false) {

            int index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
            if (this.table[index] != null && this.table[index].equals(element)) {
               this.table[index] = deletedElement;
               removeu = true;
               elements--;
            } else {
               probe++;
            }
         }
      }
   }

   @Override
   public T search(T element) {
      boolean achou = false;
      int probe = 0;
      T elemento = null;
      while (probe <= size() && achou == false) {

         int index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
         if (this.table[index] != null && this.table[index].equals(element)) {
            achou = true;
            elemento = element;
         } else {
            probe++;
         }
      }
      return elemento;
   }

   @Override
   public int indexOf(T element) {
      boolean achou = false;
      int probe = 0;
      int indice = -1;
      while (probe <= size() && achou == false) {

         int index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
         if (this.table[index].equals(element)) {
            achou = true;
            indice = index;
         } else {
            probe++;
         }
      }
      return indice;
   }
}
