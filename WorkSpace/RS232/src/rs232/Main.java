/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs232;

import app.Com;
import app.Parameters;
import com.fazecast.jSerialComm.*;
import java.awt.List;
import java.io.InputStream;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author giovynet
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static String value = "";

    public static void main(String[] args) throws Exception {
        /*Parameters param = new Parameters();
        System.out.println(param.getParity());
        Com com = new  Com(param);
        System.out.println(com.getFreeSerialPort());
        param.setPort("COM1");
        Com com = new Com(param);
        for (int i = 0; i < 10; i++) {
        Thread.sleep(800);
        System.out.println("Send 0XFF");
        com.sendSingleData(0xFF);
        }*/
        SerialPort[] puertos = SerialPort.getCommPorts();

        System.out.println(puertos.length);
        
        List listaPuertos = new List();
        List data = new List();
        for (SerialPort puerto : puertos) {
            listaPuertos.add(puerto.getSystemPortName().toString());
        }

        listaPuertos.getItem(0);
        //SerialPort puerto = SerialPort.getCommPort(listaPuertos.getItem(0));
        //puerto.openPort();
        //puerto.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);
       SerialPort puerto = SerialPort.getCommPort(listaPuertos.getItem(0));
        boolean stado = true;
        puerto.openPort();
                        puerto.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 0, 0);
        try {
            while(stado) {
               
                puerto.openPort();
                InputStream in = puerto.getInputStream();
                System.out.print((char)in.read());
                if(puerto.getParity() != 0 ){
               // System.out.print(puerto.bytesAvailable());
                
                }
                if(puerto.bytesAvailable() == -1){
                    puerto.closePort();
                    stado=false;
                    break;
                }
                System.out.println("sale");
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
