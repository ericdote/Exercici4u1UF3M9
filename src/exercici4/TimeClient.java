package exercici4;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TimeClient {

    static String HOST = "localhost";
    static int PORT = 8745;
    DataOutputStream outToServer;
    BufferedReader bf;
    Socket ss;

    public TimeClient(String host, int port) throws IOException {
        ss = new Socket(host, port);
        outToServer = new DataOutputStream(ss.getOutputStream());
        bf = new BufferedReader(new InputStreamReader(ss.getInputStream()));
        String dia = JOptionPane.showInputDialog(null, "Diu el numero del dia: ", "Entrando", 3);
        String mes = JOptionPane.showInputDialog(null, "Diu el mes: ", "Entrando", 3);
        String any = JOptionPane.showInputDialog(null, "Diu l'any: ", "Entrando", 3);
        outToServer.writeInt(Integer.valueOf(dia));
        outToServer.writeInt(Integer.valueOf(mes));
        outToServer.writeInt(Integer.valueOf(any));
        bf.close();
        outToServer.close();
        ss.close();
    }

    public static void main(String[] args) throws IOException {
        new TimeClient(HOST, PORT);
    }

}
