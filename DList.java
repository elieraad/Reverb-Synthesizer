package com.elie.SoundManips.DoublyLinkedList;

public interface DList<T> {

 public DNode<T> first() throws EmptyListException; // Returns the first node in the list

 public DNode<T> last() throws EmptyListException;// Returns the last node in the list

 public DNode<T> next(DNode<T> d) 
   throws BoundaryViolationException, InvalidPositionException;// Returns the node immediately after node d

 public DNode<T> prev(DNode<T> d) 
   throws BoundaryViolationException, InvalidPositionException;// Returns the node immediately before node d

 public DNode<T> insertFirst(T e); // Inserts element e at the front of the list and returns its new node

 public DNode<T> insertLast(T e);// Inserts element e at the back of the list and returns its new node.

 public DNode<T> insertBefore(DNode<T> d, T e) 
   throws InvalidPositionException;// Inserts element e immediately before node d and returns its new node

 public DNode<T> insertAfter(DNode<T> d, T e) 
   throws InvalidPositionException;// Inserts element e immediately after node d and returns its new node

 public T remove(DNode<T> d) 
   throws InvalidPositionException;// Removes the element stored at node d and returns it

 public T replace(DNode<T> d, T e) 
   throws InvalidPositionException;// Replaces the element stored at node d and returns the replaced element

}
