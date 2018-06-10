package com.elie.SoundManips.Queue;

import com.elie.SoundManips.DoublyLinkedList.DoublyLinkedList;
import com.elie.SoundManips.DoublyLinkedList.EmptyListException;
import com.elie.SoundManips.DoublyLinkedList.InvalidPositionException;

public class DListQueue<T> implements Queue {

 private DoublyLinkedList<T> list; // generic array used for storage
 private StringBuilder sb; // String Builder to manipulate toString()

 // constructs
 public DListQueue() {
  list = new DoublyLinkedList<>();
  sb = new StringBuilder(); // create a new StringBuilder object
 }

 // returns number of elements in queue
 @Override
 public int size() {
  return list.size();
 }

 // test whether queue is empty
 @Override
 public boolean isEmpty() {
  return list.isEmpty();
 }

 // insert element at the rear of the queue
 @SuppressWarnings("unchecked")

 @Override
 public void enqueue(Object o) {
  list.insertLast((T) o);
  sb.append(o + " ");
 }

 // remove and return the first element of the queue
 @Override
 public Object dequeue() throws EmptyListException, InvalidPositionException {
  Object toReturn = list.remove(list.first());
  sb.delete(0, toReturn.toString().length() + 1);
   return toReturn;
 }

 // return the first element of the queue
 @Override
 public Object front() throws EmptyListException {
   return list.first().getElement();
 }

 // return string description of the queue
 public String toString() {
  return sb.toString();
 }

}
