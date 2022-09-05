import java.net.*;
import java.io.*;
import java.util.*;

public class Server 
{
    public static void main(String [] args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(5876);
        Socket s = ss.accept();

        System.out.println("request accepted");

        // receiving message
        InputStreamReader isr = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        System.out.println("Client : "+ str);

        // sending message
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("Hello from server");
        pr.flush();

        Scanner sc = new Scanner(System.in);
        String msg;

        while(true)
        {
            str = br.readLine();
            System.out.println("Client : "+ str);

            System.out.print("You : ");
          msg = sc.nextLine();
          pr.println(msg);
            pr.flush();

            Thread.sleep(1000);
        }
    }
}