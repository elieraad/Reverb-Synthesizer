package com.elie.SoundManips.DoublyLinkedList;

public interface Position<T> {
 /**
  * Returns the element stored at this position.
  *
  * @return the stored element
  * @throws IllegalStateException
  *          if position no longer valid
  */
 public T getElement();

}
