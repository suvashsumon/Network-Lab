import java.io.*;
import java.net.*;
import java.util.*;

public class MySelf {

  public static void main(String[] args) throws IOException, InterruptedException {
    Socket s = new Socket("localhost", 5876);

    // sending message
    PrintWriter pr = new PrintWriter(s.getOutputStream());
    pr.println("Hello from client");
    pr.flush();

    // receiving message
        InputStreamReader isr = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        System.out.println("Server : "+str);

        Scanner sc = new Scanner(System.in);
        String msg;

        while(true)
        {
          System.out.print("You : ");
          msg = sc.nextLine();
          pr.println(msg);
          pr.flush();

          str = br.readLine();
          System.out.println("Server : "+str);

          Thread.sleep(1000);
        }

  }
}
