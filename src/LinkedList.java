public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> head;
    private boolean isSorted;


    public LinkedList() {
        this.head = null;
        this.isSorted = true;
    }

    public boolean add(T element) {

        if (element == null) return false;
        else {

            Node<T> newNode = new Node<T>(element);

            if (isEmpty()) {
                head = new Node<T>(null);
                head.setNext(newNode);
                return true;
            }

            else {

                Node<T> ptr = head;
                while (ptr.getNext() != null) ptr = ptr.getNext();
                ptr.setNext(newNode);
                checkSorted();

                return true;
            }
        }
    }

    public boolean add(int index, T element){
        Node<T> ptr = head;
        Node<T> trailer = head;
        Node<T> newNode;

        if (element == null){return false;}
        if (index >= 0 && index < size()){
            if (size() == 0){
                newNode = new Node<T>(element, null);
                ptr.setNext(newNode);
            }
            int counter = 0;
            ptr = ptr.getNext();
            while (counter < index){
                ptr = ptr.getNext();
                trailer = trailer.getNext();
                counter ++;
            }
            newNode = new Node<T>(element, ptr);
            trailer.setNext(newNode);
        } else {
            return false;
        }
        isSorted = false;
        return true;
    }

    public void clear() {
        head = null;
        isSorted = true;
    }

    public T get(int index){
        Node<T> ptr = head;
        T value = null;
        if (index >= 0 && index < size()){
            int counter = 0;
            ptr = ptr.getNext();
            while (counter < index){
                ptr = ptr.getNext();
                counter++;
            }
            value = ptr.getData();
        }
        return value;
    }

    public int indexOf(T element) {
        if (element == null) return -1;
        else {
            if (head == null) {
                head = new Node<T>(null);
            }
            Node<T> ptr = head.getNext();
            int i = 0;
            while (ptr != null && ptr.getData() != element) {
                if (isSorted() && ptr.getData().compareTo(element) > 0) {
                    ptr = null;
                    break;
                }
                ptr = ptr.getNext();
                i++;
            }
            if (ptr != null) return i;

            else return -1;

        }
    }

    public boolean isEmpty() {
        if (head== null){
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        if (isEmpty()) return 0;
        else {

            Node<T> ptr = head.getNext();
            int i = 0;
            while (ptr != null) {
                ptr = ptr.getNext();
                i++;
            }
            return i;
        }
    }

    public void sort() {
        if (isEmpty() || isSorted()) return;
        else {

            int swap = 1;
            Node<T> head1;
            Node<T> body;
            Node<T> tail;
            while (swap != 0) {
                swap = 0;
                head1 = head.getNext().getNext();
                body = head.getNext();
                tail = head;
                while (head1!= null) {
                    if (head1.getData().compareTo(body.getData()) < 0) {
                        swap++;
                        tail.setNext(head1);
                        body.setNext(head1.getNext());
                        head1.setNext(body);
                        head1 = body;
                        body = tail.getNext();

                    }

                    tail = body;
                    body= head1;
                    head1 = head1.getNext();

                }
            }
        }
        isSorted = true;
    }

    public T remove(int index) {
        Node<T> nextNode = head;
        Node<T> trailer = head;
        T removedValue = null;

        if (index >= 0 && index < size()){
            int counter = 0;
            nextNode = nextNode.getNext();
            while (counter < index){
                nextNode = nextNode.getNext();
                trailer = trailer.getNext();
                counter ++;
            }
            removedValue = nextNode.getData();
            nextNode = nextNode.getNext();
            trailer.setNext(nextNode);
            return removedValue;
        } else {
            return removedValue;
        }
    }

    public void equalTo(T element) {
        if (element == null) return;
        else {
            Node<T> ptr = head.getNext();
            int i = 0;
            while (ptr != null) {
                if (isSorted() && ptr.getData().compareTo(element) > 0) {
                    while (ptr.getNext() != null) {
                        ptr.setNext(ptr.getNext().getNext());
                    }
                    remove(i);
                } else if (ptr.getData() != element) {
                    remove(i);
                    i--;
                }
                ptr = ptr.getNext();
                i++;
            }
        }
    }

    public void reverse() {
        if (isEmpty() || size() == 1) return;
        Node<T> ptr = head.getNext().getNext();
        Node<T> trailer = head.getNext();
        while (ptr != null) {
            trailer.setNext(ptr.getNext());
            ptr.setNext(head.getNext());
            head.setNext(ptr);
            ptr = trailer.getNext();
        }
        checkSorted();
    }

    public void merge(List<T> otherList) {
        if (otherList == null) return;
        LinkedList<T> other = (LinkedList<T>) otherList;

        sort();
        other.sort();
        Node<T> Ptr = head.getNext();
        Node<T> Trailer = head;
        Node<T> otherPtr = other.head.getNext();
        Node<T> otherTrailer = other.head;
        while (otherPtr != null) {
            if (otherPtr.getData().compareTo(Ptr.getData()) <= 0) {
                otherTrailer.setNext(otherPtr.getNext());
                Trailer.setNext(otherPtr);
                otherPtr.setNext(Ptr);
                otherPtr = otherTrailer.getNext();
                Trailer = Trailer.getNext();

            } else if (Ptr.getNext() == null) {
                otherTrailer.setNext(otherPtr.getNext());
                Ptr.setNext(otherPtr);
                otherPtr.setNext(null);
                otherPtr = otherTrailer.getNext();

            } else {
                Trailer = Ptr;
                Ptr = Ptr.getNext();

            }
        }
    }

    public boolean rotate(int n) {

        if (n <= 0 || size() <= 1 || n >= size()) return false;
        else {

            Node<T> ptr = head.getNext();
            Node<T> trailer = head;
            Node<T> end = head;
            for (int i = 0; i < size() - n; i++) {
                trailer = ptr;
                ptr = ptr.getNext();
            }
            while (end.getNext() != null) end = end.getNext();
            end.setNext(head.getNext());
            trailer.setNext(null);
            head.setNext(ptr);
            checkSorted();

            return true;
        }
    }

    public String toString() {
        Node<T> node = head;
        String output = "";
        T data = null;
        if (node.getNext() == null){
            return output;
        } else {
            node = head.getNext();
            while (node != null){
                data = node.getData();
                node = node.getNext();
                output = output + "\n" + data.toString();
            }
            return output;
        }
    }


    public boolean isSorted() {
        return isSorted;
    }

    public void checkSorted() {

        Node<T> trailer = head;
        Node<T> ptr = trailer.getNext();


        if (ptr == null || ptr.getNext() == null) isSorted = true;
        else {
            while (ptr.getNext() != null) {
                trailer = ptr;
                ptr = ptr.getNext();
                if (ptr.getData().compareTo(trailer.getData()) >= 0) isSorted = true;
                else {
                    isSorted = false;
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {

    }

}