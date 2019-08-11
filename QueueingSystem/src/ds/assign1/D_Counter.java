package ds.assign1;

import static ds.assign1.A_Counter.getA;
import static ds.assign1.DS_Main.customerNumber;
import static ds.assign1.DS_Main.customerQueue;
import static ds.assign1.DS_Main.goOutOfQueue;
import static ds.assign1.DS_Main.lockF;
import static ds.assign1.DS_Main.systemStartTime;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import movingcustomer.TheCinema;


public class D_Counter extends Thread {
    
    private static final Counter<Queue_.Node> d = new Counter<>(15, "D");
    public static Queue<sortList> customerToD = new PriorityQueue<>();
    public static Lock lockD = new ReentrantLock();
    public TheCinema cin;
    
    public D_Counter(TheCinema cin){
        this.cin = cin;
    }
    public D_Counter() {

    }
    
    @Override
    public void run(){
        progressD();
    }
    
    public synchronized void progressD(){
        lockD.lock();
        try{
            while(d.isAvailable()){
//                while( vip.isEmpty() && n_mem.isEmpty()){
//                    System.out.println("Wait for customer coming : ");
//                    notEmpty.await();
//                }
                Queue_.Node customer = goOutOfQueue();
                int ctn = 0;
                if(customer == null){
                    Thread.sleep(100); //1000!!!
                    ctn++;
                    if(ctn == 5){
                        System.out.println("Counter D waiting...");
                        ctn = 0;
                    }
                    continue;
                }
                if(customer != null && !getA().isAvailable()){  
                    cin.dequeueToCounter(customer.getType(), "D", 200);
                    d.setCustomer(customer);
                    d.setAvailable(false);
                    customer.setServeSequence(++customerNumber);
                    customer.setStartTime((System.currentTimeMillis() - systemStartTime)/1000);
                    d.setStartTime(customer.getStartTime());
                    customer.setWaitingTime(customer.getStartTime() - customer.getArrivalTime());
                    customer.setProcessTime(customer.getNumTicket() * d.getSellRate());
                    //Counter counter = goCounter();

                    
                    customer.setEndTime(customer.getStartTime() + customer.getProcessTime());
                    customer.setRating(4);
                    System.out.println(customer + " go Counter " + d.getCounterType()
                     + "\n[D]Start Time : " + customer.getStartTime() + " | [D]End Time : " + customer.getEndTime()
                     + "\n----------------------------------------------------------------------------------------------" ); 
                    
                    //map.put(customer, d);
                    lockF.lock();
                    try{
                        customerQueue.add(new sortList(customer, d));
                    }finally{
                        lockF.unlock();
                    }
                    customerToD.add(new sortList(customer, d));
                    Thread.sleep(customer.getProcessTime() * 100);  //1000 !!!
                    customer.setRating(4);
                    d.setRating(4);
                    d.setAvailable(true);
                }
            }
        } catch (InterruptedException ex) {
                 ex.printStackTrace();
        }finally{
            lockD.unlock();
        }
    }

    public static Counter<Queue_.Node> getD() {
        return d;
    }
    
    
}
