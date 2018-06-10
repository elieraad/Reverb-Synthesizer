package com.elie.SoundManips;

import com.elie.SoundManips.DoublyLinkedList.EmptyListException;
import com.elie.SoundManips.DoublyLinkedList.InvalidPositionException;
import com.elie.SoundManips.Queue.DListQueue;

public class SoundManips {

 private static final double DAMPING_RATIO = 0.79;
 private DListQueue<Double> q1, q2;

 public SoundManips(int samplesPerLoop) {
  q1 = new DListQueue<>();
  q2 = new DListQueue<>();

  for (int i = 0; i < samplesPerLoop; i++)
   q1.enqueue(2 * Math.random() - 1); // enqueue a number between -1.0 and 1.0

  q2.enqueue(0.0); // enqueue 0.0
 }

 public double karplusStrong() throws EmptyListException, InvalidPositionException {

  double a = (double) q1.dequeue();
  double b = (double) q2.dequeue();
  double c = DAMPING_RATIO * average(a, b); // multiply the average of the front queues by the damping ratio

  q1.enqueue(c);
  q2.enqueue(a);

  return c;
 }

 // computes the average between two numbers
 private double average(double a, double b) {
  return (a + b) / 2;
 }

}
