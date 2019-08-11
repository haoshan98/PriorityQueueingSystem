package ds.assign1;


public class sortList implements Comparable<sortList>{
    private Queue_.Node customer;
    private Counter counter;
    private int arriveNo;
    

    public sortList(Queue_.Node customer, Counter counter){
        this.customer = customer;
        this.counter = counter;
        this.arriveNo = customer.getArriveNo();
    }

    public Queue_.Node getCustomer() {
        return customer;
    }

    public void setCustomer(Queue_.Node customer) {
        this.customer = customer;
    }

    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }
    
    
    @Override
    public int compareTo(sortList o) {
        if(this.arriveNo > o.arriveNo){
            return 1;
        }else if(this.arriveNo == o.arriveNo){
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return "\nsortList{" + "customer=" + customer + ", counter=" + counter + '}';
    }

   
    
    
    
}
