package com.elie.SoundManips.DoublyLinkedList;

public class DNode<T> implements Position<T> {

 private T element; // reference to the element stored in a node
 private DNode<T> previous, next;// reference to the previous and next node in the list

 public DNode(DNode<T> p, T e, DNode<T> n) {
  setPrevious(p);
  element = e;
  setNext(n);
 }

 // GETTERS AND SETTERS
 @Override
 public T getElement() {
  return element;
 }

 public DNode<T> getPrevious() {
  return previous;
 }

 public void setPrevious(DNode<T> previous) {
  this.previous = previous;
 }

 public DNode<T> getNext() {
  return next;
 }

 public void setNext(DNode<T> next) {
  this.next = next;
 }

 public void setElement(T element) {
  this.element = element;
 }

}
