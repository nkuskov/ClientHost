package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Nikolai on 18.07.2016.
 */
public class Client {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Client side");

        Socket fromserver = null;

        if(args.length == 0){
            System.out.println("use: client hostname");
            System.exit(-1);
        }

        System.out.println("Connecting to... " + args[0]);

        fromserver = new Socket(args[0],4444);

        BufferedReader in = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
        PrintWriter out = new PrintWriter(fromserver.getOutputStream(), true);
        BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

        String fuser,fserver;

        while ((fuser=inu.readLine())!=null){
            out.println(fuser);
            fserver = in.readLine();
            System.out.println(fserver);
            if(fuser.equalsIgnoreCase("close")) break;
            if(fuser.equalsIgnoreCase("exit")) break;

        }

        in.close();
        out.close();
        inu.close();
        fromserver.close();


    }
}
