package com.elie.SoundManips.Queue;

import com.elie.SoundManips.DoublyLinkedList.EmptyListException;
import com.elie.SoundManips.DoublyLinkedList.InvalidPositionException;

public interface Queue {

 public int size(); // Returns the number of elements in the queue.

 public boolean isEmpty(); // Returns a boolean indicating whether the queue is empty

 public void enqueue(Object o) ; // Adds object o to the back of queue.

 public Object dequeue() throws EmptyListException, InvalidPositionException; // Removes and returns the first element from the queue

 public Object front() throws EmptyListException; // Returns the first element of the queue, without removing it

}
