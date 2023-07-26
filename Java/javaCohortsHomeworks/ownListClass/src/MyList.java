import java.util.Arrays;

public class MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int capacity;
    private Object[] array;

    // Constructor without capacity parameter (default capacity 10)
    public MyList() {
        this(DEFAULT_CAPACITY);
    }

    // Constructor with capacity parameter
    public MyList(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T data) {
        ensureCapacity();
        array[size++] = data;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            capacity *= 2;
            array = Arrays.copyOf(array, capacity);
        }
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) array[index];
        }
        return null;
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            array[--size] = null;
        }
    }

    public void set(int index, T data) {
        if (index >= 0 && index < size) {
            array[index] = data;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (data.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (data.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T[] toArray() {
        return (T[]) Arrays.copyOf(array, size);
    }

    public void clear() {
        Arrays.fill(array, 0, size, null);
        size = 0;
        capacity = DEFAULT_CAPACITY;
        array = new Object[DEFAULT_CAPACITY];
    }

    public MyList<T> sublist(int start, int finish) {
        if (start >= 0 && start < size && finish >= start && finish < size) {
            MyList<T> subList = new MyList<>(finish - start + 1);
            for (int i = start; i <= finish; i++) {
                subList.add(get(i));
            }
            return subList;
        }
        return null;
    }

    public boolean contains(T data) {
        return indexOf(data) >= 0;
    }
}
