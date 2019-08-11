package ds.assign1;



import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JFrame;
import movingcustomer.TheCinema;

public class DS_Main {

    public static Queue_<Queue_.Node> vip = new Queue_<>();
    public static Queue_<Queue_.Node> n_mem = new Queue_<>();
    
    public static Queue<sortList> customerQueue = new PriorityQueue<>();
    
    public static long systemStartTime = System.currentTimeMillis();
            
    public static int customerNumber = 0;
    public static int arriveNumber = 0;
    public static Lock lock = new ReentrantLock();
    public static Lock lockF = new ReentrantLock();

    public static TheCinema cin = new TheCinema(700, 500);
    
    public static A_Counter thread1 = new A_Counter(cin);
    public static B_Counter thread2 = new B_Counter(cin);
    public static C_Counter thread3 = new C_Counter(cin);
    public static D_Counter thread4 = new D_Counter(cin);
    public static D_Counter thread5 = new D_Counter(cin);
    
//    public static A_Counter thread1 = new A_Counter();
//    public static B_Counter thread2 = new B_Counter();
//    public static C_Counter thread3 = new C_Counter();
//    public static D_Counter thread4 = new D_Counter();
    
    

    public static void main(String[] args) throws InterruptedException {
        
        for(int i=0; i<1; i++){
            generator("V", 2);
            generator("N", 5);
            generator("V", 7);
            generator("N", 8);
            generator("V", 10);
            generator("N", 6);
            generator("V", 2);
            generator("N", 5);
        
        }
        GUI g = new GUI();
        g.setVisible(true);
        //g.add(TimerDisplay);
        
        JFrame frame = new JFrame("MOVING CUSTOMERS");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(cin); 
                frame.pack();            
                frame.setVisible(true);
         
            thread1.start();
            thread2.start();
            thread4.start();
            thread3.start();
            //gameThread.start(); 
            
        
            thread1.join();
            thread2.join();
            thread4.join();
            thread3.join();
            
    }
       
    public static void generator(String typeOfCustomer, int numOfTicket) throws InterruptedException{
        lock.lock();
        try{
            
            if(typeOfCustomer.equals("V")){
                vip.enqueue(typeOfCustomer, numOfTicket);
                cin.iniCustomer("V");
                System.out.println("VIP Customer added");
            }else{
                n_mem.enqueue(typeOfCustomer, numOfTicket);
                cin.iniCustomer("N");
                System.out.println("Normal Customer added");
            }
        }finally{
            lock.unlock();
        }
    }
    
    public static Queue_.Node goOutOfQueue() {
        if( !vip.isEmpty()){
            return vip.dequeue();
        }else if( !n_mem.isEmpty()){
            return n_mem.dequeue();
        }else{
            return null;
        }
    }
    

    
}


