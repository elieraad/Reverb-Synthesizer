package com.elie.SoundManips.DoublyLinkedList;

public class DoublyLinkedList<T> implements DList<T> {

 private DNode<T> header, trailer; // header and trailer node
 private int size; // number of elements in the list

 public DoublyLinkedList() {
  header = new DNode<T>(null, null, null); // create header
  trailer = new DNode<T>(header, null, null); // trailer is preceded by header
  header.setNext(trailer); // header is followed by trailer
  size = 0; // list is empty
 }

 // returns number of elements in the list
 public int size() {
  return size;
 }

 // tests whether the list is empty
 public boolean isEmpty() {
  return (size == 0);
 }

 // return the first node in the list
 @Override
 public DNode<T> first() throws EmptyListException {
  if (isEmpty())
   throw new EmptyListException("List is empty!");
  return header.getNext();
 }

 // return the last node in the list
 @Override
 public DNode<T> last() throws EmptyListException {
  if (isEmpty())
   throw new EmptyListException("List is empty!");
  return trailer.getPrevious();
 }

 // validate the position of the node d
 private void checkPosition(DNode<T> d) throws InvalidPositionException {
  if (d == null)
   throw new InvalidPositionException("Null is not a valid position!");
  if (d == header)
   throw new InvalidPositionException("Header is not a valid position!");
  if (d == trailer)
   throw new InvalidPositionException("Trailer is not a valid position!");
  if (d.getPrevious() == null || d.getNext() == null)
   throw new InvalidPositionException("Node not part of a DLL!");
 }

 // returns the node immediately after node d
 @Override
 public DNode<T> next(DNode<T> d) throws BoundaryViolationException, InvalidPositionException {
  checkPosition(d);
  if (d.getNext() == trailer)
   throw new BoundaryViolationException("Cannot move past last node!");
  return d.getNext();
 }

 // returns the node immediately before node d
 @Override
 public DNode<T> prev(DNode<T> d) throws BoundaryViolationException, InvalidPositionException {
  checkPosition(d);
  if (d.getPrevious() == header)
   throw new BoundaryViolationException("Cannot move past first node!");
  return d.getPrevious();
 }

 // inserts element e at the front of the linked list and returns its new node
 @Override
 public DNode<T> insertFirst(T e) {
  DNode<T> newDNode = new DNode<>(header, e, header.getNext());
  header.getNext().setPrevious(newDNode);
  header.setNext(newDNode);
  size++;
  return newDNode;
 }

 // inserts element e at the back of the linked list and returns its new node
 @Override
 public DNode<T> insertLast(T e) {
  DNode<T> newDNode = new DNode<>(trailer.getPrevious(), e, trailer);
  trailer.getPrevious().setNext(newDNode);
  trailer.setPrevious(newDNode);
  size++;
  return newDNode;
 }

 // inserts element e immediately before node d, and returns its new node
 @Override
 public DNode<T> insertBefore(DNode<T> d, T e) throws InvalidPositionException {
  checkPosition(d);
  DNode<T> newDNode = new DNode<>(d.getPrevious(), e, d);
  d.getPrevious().setNext(newDNode);
  d.setPrevious(newDNode);
  size++;
  return newDNode;
 }

 // //inserts element e immediately after node d, and returns its new node
 @Override
 public DNode<T> insertAfter(DNode<T> d, T e) throws InvalidPositionException {
  checkPosition(d);
  DNode<T> newDNode = new DNode<>(d, e, d.getNext());
  d.getNext().setPrevious(newDNode);
  d.setNext(newDNode);
  size++;
  return newDNode;
 }

 // removes the element stored at node d and returns it
 @Override
 public T remove(DNode<T> d) throws InvalidPositionException {
  checkPosition(d);
  T toReturn = d.getElement();
  d.getPrevious().setNext(d.getNext());
  d.getNext().setPrevious(d.getPrevious());
  d.setNext(null);
  d.setPrevious(null);
  size--;
  return toReturn;
 }

 // replace the element stored at node d and returns the old element
 @Override
 public T replace(DNode<T> d, T e) throws InvalidPositionException {
  checkPosition(d);
  T toReturn = d.getElement();
  d.setElement(e);
  return toReturn;
 }

}
