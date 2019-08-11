package ds.assign1;


public interface ADT_Queue<E> {
    
    /**It is used to insert the specified element into this queue and return true upon success
     * @param t.
     * @param n
     * @return */
    public boolean enqueue(String t, int n); 
    
    /**It is used to retrieves and removes the head of this queue, or returns null if this queue is empty
     * @return .*/
    public E dequeue();
    
    /**It is used to check whether the queue is empty or not and return true if it is empt
     * @return y*/
    public boolean isEmpty();
    
    /*It is used to retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.*/
    public E peek();
    
}
