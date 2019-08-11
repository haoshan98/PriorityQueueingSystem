package ds.assign1;

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

public class A_Counter extends Thread {

    private static final Counter<Queue_.Node> a = new Counter<>(10, "A");
    public static Queue<sortList> customerToA = new PriorityQueue<>();
    public static Lock lockA = new ReentrantLock();
    public TheCinema cin;

    public A_Counter(TheCinema cin) {
        this.cin = cin;
    }
    public A_Counter() {

    }

    @Override
    public void run() {
        progressA();
    }

    public synchronized void progressA(){
        lockA.lock();
        try {
            while (a.isAvailable()) {
                
                
                //            while( vip.isEmpty() && n_mem.isEmpty()){
                //                System.out.println("Wait for customer coming : ");
                //                notEmpty.await();
                //            }
                Queue_.Node customer = goOutOfQueue();
                
                int ctn = 0;
                if (customer == null) {
                    Thread.sleep(100); //1000!!!
                    ctn++;
                    if (ctn == 5) {
                        System.out.println("Counter A waiting...");
                        ctn = 0;
                    }
                    continue;
                }
                if (customer != null) {
                    //System.out.println("COUNTER A " + customer);
                    cin.dequeueToCounter(customer.getType(), "A", 500);
                    a.setCustomer(customer);
                    a.setAvailable(false);
                    customer.setServeSequence(++customerNumber);
                    customer.setStartTime((System.currentTimeMillis() - systemStartTime) / 1000);
                    a.setStartTime(customer.getStartTime());
                    customer.setWaitingTime(customer.getStartTime() - customer.getArrivalTime());
                    customer.setProcessTime(customer.getNumTicket() * a.getSellRate());

                    customer.setEndTime(customer.getStartTime() + customer.getProcessTime());
                    customer.setRating(5);
                    System.out.println(customer + " go Counter " + a.getCounterType()
                            + "\n[A]Start Time : " + customer.getStartTime() + " | [A]End Time : " + customer.getEndTime()
                            + "\n----------------------------------------------------------------------------------------------");

                    //map.put(customer, a);
                    lockF.lock();
                    try{
                        customerQueue.add(new sortList(customer, a));
                    }finally{
                        lockF.unlock();
                    }
                    customerToA.add(new sortList(customer, a));
                    Thread.sleep(customer.getProcessTime() * 100);  //1000 !!!
                    customer.setRating(3);
                    a.setRating(5);
                    a.setAvailable(true);
                }
                
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lockA.unlock();
        }

    }

    

    public static Counter<Queue_.Node> getA() {
        return a;
    }

    
}
