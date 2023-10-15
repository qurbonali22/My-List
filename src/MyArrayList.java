import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {
    Item<E>[] itemList = new Item[10];
    int indexItem = 0;

    private void resize() {
        if (indexItem == itemList.length) {
            Item<E>[] items = new Item[itemList.length + 1];
            System.arraycopy(itemList, 0, items, 0, itemList.length);
            itemList = items;
        }
    }

    /**
     * Adding value
     */
    public void add(E value) {
        resize();
        Item item = new Item(value);
        itemList[indexItem++] = item;

    }

    public void add(int index, E value) {
        if (index == 0) {
            addFist(value);
        } else if (index == indexItem) {
            addLast(value);
        } else {
            resize();
            Item item = new Item(value);
            Item[] items = new Item[indexItem - index];
            System.arraycopy(itemList, index, items, 0, items.length);
            itemList[index] = item;
            System.arraycopy(items, 0, itemList, index + 1, items.length);
            indexItem++;
        }
    }

    public  void addFist(E value) {
        resize();
        Item<E> item = new Item<E>(value);
        Item<E>[] items = new Item[itemList.length];
        System.arraycopy(itemList, 0, items, 0, indexItem);
        itemList[0] = item;
        System.arraycopy(items, 0, itemList, 1, indexItem);
        indexItem++;
    }

    public void addLast(E value) {
        resize();
        Item<E> item = new Item<E>(value);
        itemList[indexItem++] = item;
    }

    /**
     * Fetching  value
     */

    public E  get(int index) {
        if (index > itemList.length) {
            return null;
        }

        return itemList[index].getValue();
    }

    public int indexOf(E value) {
        for (int i = 0; i < itemList.length; i++) {
            if (itemList[i] != null && itemList[i].getValue().equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Update value
     */

    public E set(int index, E value) {
        // return old value
        if (index >= itemList.length) {
            return null;
        }
        E result = itemList[index].getValue();
        itemList[index].setValue(value);
        return result;
    }

    /**
     * Remove/delete
     */

    public E remove(int index) {
        // returns deleted value

        if (index >= itemList.length) {
            return null;
        }
        E result = itemList[index].getValue();
        for (int i = index; i + 1 < itemList.length; i++) {
            itemList[i] = itemList[i + 1];
        }
        --indexItem;
        return result;
    }

    public void removeFirst() {
        for (int i = 0; i + 1 < itemList.length; i++) {
            itemList[i] = itemList[i + 1];
        }
        indexItem--;
    }

    public void removeLast() {

        itemList[indexItem - 1] = null;
        --indexItem;
    }

    public int remove(E value) {
        // returns deleted index
        for (int i = 0; i < itemList.length; i++) {
            if (itemList[i].getValue().equals(value)) {
                remove(i);
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        itemList = new Item[10];
    }

    /**
     * Is methods
     */

    public boolean isEmpty(E value) {
        return indexOf(value) == -1;

    }

    public boolean isContains(E value) {
        return indexOf(value) != -1;
    }

    /**
     * Other methods
     */

    public int size() {
        return indexItem;
    }

    public Object[] toArray() {
        Object[] array = new Object[itemList.length];
        System.arraycopy(itemList, 0, array, 0, itemList.length);
        return array;
    }

    public void printAll() {

        for (Item item : itemList) {
            if (item == null) break;
            System.out.print(item.getValue() + ", ");

        }

    }

    public void printFirstAndLast() {
        System.out.println(itemList[0].getValue());
        System.out.println(itemList[indexItem - 1].getValue());

    }

    public String toString() {
        // [1,2,3,4,5]
        StringBuilder result = new StringBuilder();
        result.append("[");

        for (int i = 0; i < itemList.length; i++) {
            if (itemList[i] == null) {
                result.append("]");
                break;
            }
            result.append(itemList[i].getValue());
            if (itemList[i + 1] != null) result.append(",");
        }
        return result.toString();
    }

    /**
     * Iterating
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return itemList[i] != null;
            }

            @Override
            public E next() {
                return itemList[i++].getValue();
            }
        };
    }

    static class Item<E> {
        private E value;

        public Item(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

    }
}
