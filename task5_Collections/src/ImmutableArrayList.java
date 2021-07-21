import java.util.ArrayList;

public final class ImmutableArrayList<T>extends ArrayList<T> {


    @Override
    public T set(int index, T element) {
throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public ImmutableArrayList(int initialCapacity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, T element) {
        super.add(index, element);
    }
}
