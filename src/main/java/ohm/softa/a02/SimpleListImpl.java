package ohm.softa.a02;


import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object> {

    private element head;
    private int size;

    public SimpleListImpl() {
        head = null;
    }

    @Override
    public Iterator<Object> iterator() {
        return new SimpleIterator();
    }

    @Override
    public void add(Object item) {
        if(head == null){
            head = new element(item);
        }
        else{
            element current = head;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(new element(item));
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleList result = new SimpleListImpl();
        for(Object o : this){
            if(filter.include(o)){
                result.add(o);
            }
        }
        return result;
    }

    private class SimpleIterator implements Iterator<Object>{
        private element current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Object tmp  = current.getItem();
            current = current.getNext();
            return tmp;
        }
    }

    // TODO: Implement the required methods.
     static private class element{
        private element next;
        private Object item;

        element(Object item){
            this.item = item;
            this.next = null;
        }

        public Object getItem(){
            return item;
        }

        public element getNext(){
            return next;
        }

        public void setNext(element next){
            this.next = next;
        }
    }
}
