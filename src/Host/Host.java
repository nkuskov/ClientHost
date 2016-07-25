package Host;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Nikolai on 18.07.2016.
 */
public class Host {




    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to server Side");
        BufferedReader in = null;
        PrintWriter out = null;

        ServerSocket server = null;
        Socket fromclient = null;

        //create server
        try {

            server = new ServerSocket(4444);   //Create Host port

        }
        catch (IOException e){
            System.out.println("Couldn't listen to port 4444");
            System.exit(-1);

        }

        try {
            System.out.println("Waiting for the client");
            fromclient = server.accept();
            System.out.println("Client connected");
        }
        catch (IOException e){
            System.out.println("Can't accept");
            System.exit(-1);
        }

        in = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
        out = new PrintWriter(fromclient.getOutputStream(), true);

        String input,output;

        System.out.println("Waiting for the message");
        while((input =in.readLine())!=null){
            if(input.equalsIgnoreCase("exit")){
                break;

            }
            out.println("S :::" + input);
            System.out.println(input);

        }

        out.close();
        in.close();
        fromclient.close();
        server.close();


    }

}
