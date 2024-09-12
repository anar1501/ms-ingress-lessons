package behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteCollection<E> implements Aggregate<E> {
    private List<E> items = new ArrayList<>();

    public void addItem(E item) {
        items.add(item);
    }

    @Override
    public Iterator<E> createIterator() {
        return new ConcreteIterator();
    }

    private class ConcreteIterator implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < items.size();
        }

        @Override
        public E next() {
            if (this.hasNext()) {
                return items.get(index++);
            }
            return null;
        }
    }
}

