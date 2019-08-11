package ds.assign1;

import static ds.assign1.DS_Main.customerQueue;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

public class WriteFile {

    private static final String FILENAME = "C:\\Users\\ASUS\\Desktop\\OverallReport.txt";
    private static final String FILENAMEA = "C:\\Users\\ASUS\\Desktop\\Counter_A.txt";
    private static final String FILENAMEB = "C:\\Users\\ASUS\\Desktop\\Counter_B.txt";
    private static final String FILENAMEC = "C:\\Users\\ASUS\\Desktop\\Counter_C.txt";
    private static final String FILENAMED = "C:\\Users\\ASUS\\Desktop\\Counter_D.txt";
    private BufferedWriter bw = null;
    private FileWriter fw = null;

    public void writeF_ALL() {  //write overall report
        try {

            String title = "| Customer | Serve Sequence |  Queue | Counter | No. of Tickets | Arrival Time | Start Processing | End Processing | Processing Time | Waiting Time |";
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            bw.write("                                                  ===Overall Report===");
            bw.newLine();
            bw.newLine();
            bw.write(title);
            bw.newLine();
            bw.write("----------------------------------------------------------------------------------------------------------------------------------------------------------");
            bw.newLine();
            Iterator it = customerQueue.iterator();
            while (it.hasNext()) {

                sortList sl = customerQueue.poll();
                Queue_.Node customer = sl.getCustomer();
                Counter counter = sl.getCounter();
                bw.write("| " + String.format("%8s",customer.getArriveNo()) + " | " + String.format("%14s",customer.getServeSequence()) + 
                        " | " + String.format("%6s",customer.getType()) + " | " + String.format("%7s",counter.getCounterType()) + 
                        " | " + String.format("%14s",customer.getNumTicket()) +
                        " | " + String.format("%12s",customer.getArrivalTime()) + " | " + String.format("%16s",customer.getStartTime()) + 
                        " | " + String.format("%14s",customer.getEndTime()) + " | " + String.format("%15s",customer.getProcessTime()) + 
                        " | " + String.format("%12s",customer.getWaitingTime()) + " |");
                bw.newLine();
                //it.remove(); // avoids a ConcurrentModificationException
            }
            
            System.out.println("Overall Report Generated.");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
    }
    
    public void writeF_Counter(Queue<sortList> customerTo_, String type){
        try {
            String filename;
            if(type.equals("A")){
                filename = getFILENAMEA();
            }else if(type.equals("B")){
                filename = getFILENAMEB();
            }else if(type.equals("C")){
                filename = getFILENAMEC();
            }else{
                filename = getFILENAMED();
            }
            String title = "| Customer | Serve Sequence |  Queue | Counter | No. of Tickets | Arrival Time | Start Processing | End Processing | Processing Time | Waiting Time |";
            fw = new FileWriter(filename);
            bw = new BufferedWriter(fw);
            bw.write("                                                   ===Report of Counter " + type + "===");
            bw.newLine();
            bw.newLine();
            bw.write(title);
            bw.newLine();
            bw.write("----------------------------------------------------------------------------------------------------------------------------------------------------------");
            bw.newLine();
            Iterator it = customerTo_.iterator();
            while (it.hasNext()) {

                sortList sl = customerTo_.poll();
                Queue_.Node customer = sl.getCustomer();
                Counter counter = sl.getCounter();
                bw.write("| " + String.format("%8s",customer.getArriveNo()) + " | " + String.format("%14s",customer.getServeSequence()) + 
                        " | " + String.format("%6s",customer.getType()) + " | " + String.format("%7s",counter.getCounterType()) + 
                        " | " + String.format("%14s",customer.getNumTicket()) +
                        " | " + String.format("%12s",customer.getArrivalTime()) + " | " + String.format("%16s",customer.getStartTime()) + 
                        " | " + String.format("%14s",customer.getEndTime()) + " | " + String.format("%15s",customer.getProcessTime()) + 
                        " | " + String.format("%12s",customer.getWaitingTime()) + " |");
                bw.newLine();
                //it.remove(); // avoids a ConcurrentModificationException
            }
            
            System.out.println("Report for Counter " + type + " Generated.");
            
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
    }

    public static String getFILENAMEA() {
        return FILENAMEA;
    }

    public static String getFILENAMEB() {
        return FILENAMEB;
    }

    public static String getFILENAMEC() {
        return FILENAMEC;
    }

    public static String getFILENAMED() {
        return FILENAMED;
    }
    
    
}
