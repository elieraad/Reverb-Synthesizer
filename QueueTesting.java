package com.elie.SoundManips.Queue;

import com.elie.SoundManips.DoublyLinkedList.EmptyListException;
import com.elie.SoundManips.DoublyLinkedList.InvalidPositionException;

public class QueueTesting {
 
 public static void main(String[] args) throws EmptyListException, InvalidPositionException {
  DListQueue<Integer> queue = new DListQueue<>();
  
  queue.enqueue(4);
  queue.enqueue(3);
  queue.enqueue(2);
  queue.enqueue(1);
  
  System.out.println("Queue: " + queue);
  System.out.println("Front: " + queue.dequeue());
  System.out.println("Resulting queue: " + queue);
  System.out.println("Resulting size: " + queue.size());
  System.out.println(queue.front());

 }

}
