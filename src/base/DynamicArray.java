package base;

import java.util.Arrays;
import java.util.Locale;

public class DynamicArray<T> {
    public DynamicArray() {
        this.size = 0;
        this.length = 10;
        this.db = (T[]) new Object[this.length];
    }

    public DynamicArray(T[] db) {
        this();
        for (T element : db) {
            this.add(element);
        }
    }

    private int size;
    private int length;
    private T[] db;


    public void add(T element) {
        checkLength();
        db[size++] = element;
    }

    public void add(T element, int index) {
        checkLength();
        for (int i = size; i > index; i--) {
            db[i] = db[i - 1];
        }
        size++;
        db[index] = element;
    }

    public T remove(int index) {
        T res = null;
        if (index < size) {
            res = db[index];
            for (int i = index; i < size; i++) {
                db[i] = db[i - +1];
            }
            size--;
            checkLength();
        }
        return res;
    }

    public int remove(T element) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (db[i].equals(element)) {
                remove(i);
                count++;
            }
        }
        return count;
    }

    public T min(java.util.Comparator<? super T> comparator) {
        T minimalResult = db[0];
        for (int i = 1; i < size; i++) {
            if (comparator.compare(minimalResult, db[i]) > 0) {
                minimalResult = db[i];
            }
        }
        return minimalResult;
    }

    public T max(java.util.Comparator<? super T> comparator) {
        T maximumResult = db[0];
        for (int i = 1; i < size; i++) {
            if (comparator.compare(maximumResult, db[i]) < 0) {
                maximumResult = db[i];
            }
        }
        return maximumResult;
    }

    public T sum() throws Exception {
        if (db[0] instanceof Long || db[0] instanceof Short || db[0] instanceof Integer) {
            Long res = 0L;
            for (int i = 0; i < size; i++) {
                res += ((Number) db[i]).longValue();
            }
            return (T) res;
        } else if (db[0] instanceof Double || db[0] instanceof Short) {
            Double res = 0.0;
            for (int i = 0; i < size; i++) {
                res += ((Number) db[i]).doubleValue();
            }
            return (T) res;
        } else
            throw new Exception(db[0].getClass().getSimpleName() + "невозможно сложить");
    }

    public T multiply() throws Exception {
        if (db[0] instanceof Long || db[0] instanceof Short || db[0] instanceof Integer) {
            Long res = 0L;
            for (int i = 0; i < size; i++) {
                res *= ((Number) db[i]).longValue();
            }
            return (T) res;
        } else if (db[0] instanceof Double || db[0] instanceof Float) {
            Double res = 0.0;
            for (int i = 0; i < size; i++) {
                res *= ((Number) db[i]).doubleValue();
            }
            return (T) res;
        } else
            throw new Exception(db[0].getClass().getSimpleName() + "произведение невозможно");
    }

    public Integer find(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(this.db[i])) return i;
        }
        return -1;
    }

    public boolean checkExistence(T element) {
        return this.find(element) != -1;
    }

    public void bubbleSort(java.util.Comparator<? super T> comparator) {
        for (int j = 1; j < size; j++) {
            Boolean isSorted = true;
            for (int i = 0; i < size - j; i++) {
                if (comparator.compare(db[i], db[i + 1]) > 0) {
                    T temp = db[i];
                    db[i] = db[i + 1];
                    db[i + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
    }

    public void insertSort(java.util.Comparator<? super T> comparator) {
        for (int j = 1; j < size; j++) {
            T key = db[j];
            int i = j - 1;
            while ((i >= 0 && comparator.compare(db[i], key) > 0)) {
                db[i + 1] = db[i];
                i--;
            }
            db[i + 1] = key;
        }
    }

    public void simpleChoiceSort(java.util.Comparator<? super T> comparator) {
        for (int i = 0; i < size - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < size; ++j) {
                if (comparator.compare(db[j], db[minPos]) < 0) {
                    minPos = j;
                }
            }
            T temp = db[minPos];
            db[minPos] = db[i];
            db[i] = temp;
        }
    }

    public T getElement(int index) {
        if(index>0 && index<size) return db[index];
        else return null;
    }
    public T replace(T element, int index) {
        if (index > 0 && index < size) {
            T oldElement = db[index];
            db[index] = element;
            return oldElement;
        } else return null;
    }
    public void printArray(){
        System.out.println(db);
    }
    public int size(){
        return this.size;
    }

    private void checkLength() {
        if (size > 0 && (double) size / length > 0.8) {
            length = (int) (length * 1.2);
            db = Arrays.copyOf(db, length);
        }
        if (size > 10 && (double) size / length < 0.3) {
            length = (int) (length * 0.5);
            db = Arrays.copyOf(db, length);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i <size; i++) {
            sb.append(db[i].toString());
            if (i != size -1) sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
