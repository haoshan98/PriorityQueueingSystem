package ds.assign1;

import static ds.assign1.A_Counter.getA;
import static ds.assign1.B_Counter.getB;
import static ds.assign1.DS_Main.customerNumber;
import static ds.assign1.DS_Main.customerQueue;
import static ds.assign1.DS_Main.goOutOfQueue;
import static ds.assign1.DS_Main.lockF;
import static ds.assign1.DS_Main.systemStartTime;
import static ds.assign1.D_Counter.getD;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import movingcustomer.TheCinema;


public class C_Counter extends Thread {
    
    private static final Counter<Queue_.Node> c = new Counter<>(30, "C");
    public static Queue<sortList> customerToC = new PriorityQueue<>();
    public static Lock lockC = new ReentrantLock();
    public TheCinema cin;
    
    public C_Counter(TheCinema cin){
        this.cin = cin;
    }
    public C_Counter() {

    }
    
    @Override
    public void run(){
        progressC();
    }
    
    public synchronized void progressC(){
        lockC.lock();
        try{
            while(c.isAvailable()){
    //            while( vip.isEmpty() && n_mem.isEmpty()){
    //                System.out.println("Wait for customer coming : ");
    //                notEmpty.await();
    //            }
                Queue_.Node customer = goOutOfQueue();
                int ctn = 0;
                if(customer == null){
                        Thread.sleep(100); //1000!!!
                    ctn++;
                    if(ctn == 5){
                        System.out.println("Counter C waiting...");
                        ctn = 0;
                    }
                    continue; 
                }
                if(customer != null && (!getA().isAvailable() && !getB().isAvailable() && !getD().isAvailable())){  // serve better(shorter overall time)
                    cin.dequeueToCounter(customer.getType(), "C", 300);
                    c.setCustomer(customer);
                    c.setAvailable(false);
                    customer.setServeSequence(++customerNumber);
                    customer.setStartTime((System.currentTimeMillis() - systemStartTime)/1000);
                    c.setStartTime(customer.getStartTime());
                    customer.setWaitingTime(customer.getStartTime() - customer.getArrivalTime());
                    customer.setProcessTime(customer.getNumTicket() * c.getSellRate());

                    customer.setEndTime(customer.getStartTime() + customer.getProcessTime());
                    customer.setRating(3);
                    System.out.println(customer + " go Counter " + c.getCounterType()
                    + "\n[C]Start Time : " + customer.getStartTime() + " | [C]End Time : " + customer.getEndTime()
                    + "\n----------------------------------------------------------------------------------------------" ); 

                    //map.put(customer, c);
                    lockF.lock();
                    try{
                        customerQueue.add(new sortList(customer, c));
                    }finally{
                        lockF.unlock();
                    }
                    customerToC.add(new sortList(customer, c));
                    Thread.sleep(customer.getProcessTime() * 100);  //1000 !!!
                    customer.setRating(3);
                    c.setRating(3);
                    c.setAvailable(true);
                }
            }
        } catch (InterruptedException ex) {
                 ex.printStackTrace();
        }finally{
            lockC.unlock();
        }
    }

    public static Counter<Queue_.Node> getC() {
        return c;
    }
    
    
}
