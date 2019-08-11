package ds.assign1;

import static ds.assign1.DS_Main.arriveNumber;
import static ds.assign1.DS_Main.customerNumber;
import static ds.assign1.DS_Main.systemStartTime;


public class Queue_<E> implements ADT_Queue<E>{

    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public Queue_(){
        head = null;
        tail = null;
        size = 0;
    }
    
    @Override
    public boolean enqueue(String t, int n) {
        Node<E> node = new Node<>(t, n);
        if(isEmpty()){
            tail = head = node;
        }else if(size == 1){
            tail = node;
            head.next = tail;
        }else{
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    @Override
    public E dequeue() {
        Node<E> temp;
        if(isEmpty()){
            return null;
        }else if(size == 1){
            temp = head;
            head = tail = null;
            size--;
        }else if(size == 2){
            temp = head;
            head = head.next;
            tail = head;
            size--;
        }else{
            temp = head;
            head = head.next;
            size--;
        }
        temp.setStartTime((System.currentTimeMillis() - temp.getArrivalTime()) / 1000);
        return (E)temp;
    }

    @Override
    public boolean isEmpty() {
        if(head == null && tail == null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public E peek() {
        if(! isEmpty()){
            return (E)head;
        }else{
            return null;
        }
    }

    public int size() {
        return size;
    }
    
    public static class Node<E>{
    
        private final String type;  //VIP or N
        private final int numTicket;
        private final int arriveNo;
        private long arrivalTime;
        private long startTime;
        private long waitingTime;
        private long processTime;
        private long endTime;
        private int rating;
        private int serveSequence = 0;
        private Node<E> next;
        
        public Node(String type, int numTicket){
            this.type = type;
            this.numTicket = numTicket;
            arrivalTime = (System.currentTimeMillis() - systemStartTime)/1000;
            arriveNo = ++arriveNumber;
        }

        public String getType() {
            if(type.equals("V")){
                return "VIP";
            }else{
                return "Normal";
            }
        }

        public int getNumTicket() {
            return numTicket;
        }

        public long getArrivalTime() {
            return arrivalTime;
        }

        public void setArrivalTime(long arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        public int getServeSequence() {
            return serveSequence;
        }

        public void setServeSequence(int serveSequence) {
            this.serveSequence = serveSequence;
        }

        public int getArriveNo() {
            return arriveNo;
        }
      
        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getWaitingTime() {
            return waitingTime;
        }

        public void setWaitingTime(long waitingTime) {
            this.waitingTime = waitingTime;
        }

        public long getProcessTime() {
            return processTime;
        }

        public void setProcessTime(long processTime) {
            this.processTime = processTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        @Override
        public String toString() {
//            setServeSequence(++customerNumber);
            return "Customer{" + "type=" + getType() + ", numTicket=" + numTicket + ", arriveNumber="+ getArriveNo() + ", serveNumber="+ getServeSequence() +
                    ", arrivalTime=" + getArrivalTime() + ", startTime=" + startTime + ", rating="+ getRating() + '}';
        }
        
        
        
        
    }
    
}
