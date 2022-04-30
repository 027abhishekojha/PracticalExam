package server1;
 
import java.net.*;
import java.io.*;
import java.util.*;
 
public class Server1 {
 
    public static void main(String[] args) {
 
        try {
            String Quote = null;
            Calendar c = Calendar.getInstance();
            Date date = new Date();
            c.setTime(date);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            switch (dayOfWeek) {
                //sunday
                case 1:
                    Quote = "ITS SUNDAY";
                    break;
                //monday
                case 2:
                    Quote = "ITS MONDAY";
                    break;
                //tuesday
                case 3:
                    Quote = "ITS TUESDAY";
                    break;
                //wednesday
                case 4:
                    Quote = "ITS WEDNESDAY";
                    break;
                //thursday
                case 5:
                    Quote = "ITS THURSDAY";
                    break;
                //friday
                case 6:
                    Quote = "ITS FRIDAY";
                    break;
                //saturday
                case 7:
                    Quote = "ITS SATURDAY";
                    break;
                default:
                    Quote = "NO WEEK DAY";
                    break;
            }
            ServerSocket sock = new ServerSocket(6017);
 
            // now listen for connections
            while (true) {
                Socket client = sock.accept();
 
                // we have a connection
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                pout.println("The computer was born to solve problems that did not exist before - Bill Gates");
                pout.println("Abhishek Ojha - 027");
                // write the Quote to the socket
                if (Quote.length() <= 512) {
                    pout.println(Quote);
 
                } else {
                    pout.println("More than 512 characters");
                }
                client.close();
            }
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
