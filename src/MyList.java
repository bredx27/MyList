/**
 * Created by E6410 on 13.11.2017.
 */
public class MyList<T> {
    private Node<T> first;
    private Node<T> current;
    private Node<T> last;
    private Integer size = 0;

    public void toLast() {
        this.current = last;
    }
    public void toFirst() {
        this.current = first;
    }
    public void toNext() {
        current = current.getNext();
    }
    public void addBeforeCurrent(T content) {
        size++;
        Node<T> result = new Node<>();
        result.setContent(content);
        if(!initCurrentNodeIfNotPresent()) {
            //no elements
            current = result;
            first = result;
            last = result;
        } else {
            Node<T> before = getNodeBefore(current);
            before.setNext(result);
            result.setNext(current);
        }
    }
    public Node<T> getNodeBefore(Node<T> node) {
        if(first==null) return new Node<T>();
        Node<T> temp = first;
        while(temp.getNext()!=node) {
            temp = temp.getNext();
        }
        return temp;
    }
    public T get(Integer counter) {
        if(counter<0) return null;
        Node<T> temp = first;
        for(int i = 0;i<=counter;i++) {
            temp = temp.getNext();
        }
        return temp!=null ? temp.getContent(): null;
    }
    public void addAfterCurrent(T content) {
        size++;
        Node<T> node = new Node<>();
        node.setContent(content);
        if(!initCurrentNodeIfNotPresent()) {
            setCurrent(node);
            return;
        }
        node.setNext(current.getNext());
        current.setNext(node);
        current = node;
    }
    private boolean initCurrentNodeIfNotPresent() {
        boolean result = current != null;
        if(first==null) {
            Node<T> temp = new Node<>();
            first = temp;
            last = temp;
            current = temp;
        }
        return result;
    }
    private void checkList() {
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public Node<T> getCurrent() {
        return current;
    }

    public void setCurrent(Node<T> current) {
        this.current = current;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

}
