/* Jeffrey Lin
 * APCS2 period 03
 * HW32 -- Getting Past the Velvet Rope
 * 2017-04-19
 */

import java.util.ArrayList;

public class ArrayPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E> {
  private final ArrayList<E> _data = new ArrayList<>();

  public ArrayPriorityQueue() {
  }

  @Override
  public void add(E x) {
    int c = 0;
    for ( int i = 0; i < _data.size() - 1; i++ ) {
      if ( _data.get(i).compareTo(x) < 0 ) {
        c = i;
      }
    }

    _data.add(c, x);
  }

  @Override
  public boolean isEmpty() {
    return _data.isEmpty();
  }

  @Override
  public E peekMin() {
    if ( this.isEmpty() ) {
      throw new RuntimeException();
    }

    return _data.get(_data.size() - 1);
  }

  @Override
  public E removeMin() {
    if ( this.isEmpty() ) {
      throw new RuntimeException();
    }

    return _data.remove(_data.size() - 1);
  }
}

