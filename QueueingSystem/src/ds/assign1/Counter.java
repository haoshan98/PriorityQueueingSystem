package ds.assign1;


public class Counter<E> {
    private long startTime;
    private long endTime;
    private long processTime;
    private final int sellRate;  //Time to sell a ticket
    private final String counterType;
    private int rating;
    private boolean available;
    private E customer;
    
    public Counter(int sellRate, String counterType){
        this.sellRate = sellRate;
        this.counterType = counterType;
        available = true;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getCounterType() {
        return counterType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public E getCustomer() {
        return customer;
    }

    public void setCustomer(E customer) {
        this.customer = customer;
    }

    public int getSellRate() {
        return sellRate;
    }

    public long endTime(int sellRate, int numTicketBuy) {
        endTime = (sellRate * numTicketBuy) + startTime;
        return endTime;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public long process(int sellRate, int numTicketBuy){
        processTime = sellRate * numTicketBuy;
        return processTime;
    }
    
    @Override
    public String toString() {
        return counterType;
    }
    
    

}
