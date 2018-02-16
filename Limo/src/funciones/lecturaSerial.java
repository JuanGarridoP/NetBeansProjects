package funciones;

import com.fazecast.jSerialComm.*;
import java.awt.List;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import limo.Ventas;

public class lecturaSerial {

    public static leeBuffer bytesH = new leeBuffer();
    public static verificaPuerto verificaH = new verificaPuerto();
    static serial serial = new serial();

    public static verificaPuerto getVerificaH() {
        return verificaH;
    }

    public static void setVerificaH(verificaPuerto verificaH) {
        lecturaSerial.verificaH = verificaH;
    }

    public static leeBuffer getBytesH() {
        return bytesH;
    }

    public static void setBytesH(leeBuffer bytesH) {
        lecturaSerial.bytesH = bytesH;
    }

    public static class verificaPuerto extends Thread {

        public void run() {
            serial.listaPuertos = new List();
            System.out.println("Verificando pierto");
            boolean verifica = true;
            while (true) {
                serial.puertos = SerialPort.getCommPorts();
                if (serial.puertos.length != 0) {
                    for (SerialPort puerto : serial.puertos) {
                        serial.listaPuertos.add(puerto.getSystemPortName().toString());
                    }

                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(lecturaSerial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    serial.listaPuertos.removeAll();
                    JOptionPane.showMessageDialog(null, "Porfavor conecte el Lector", "Atención", JOptionPane.WARNING_MESSAGE);
                }
                System.out.println("puertos   " + serial.puertos.length);
            }
        }
    }

    public static class leeBuffer extends Thread {

        boolean status;
        InputStream in;

        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(lecturaSerial.class.getName()).log(Level.SEVERE, null, ex);
            }
            abrePuerto();
            in = serial.puerto.getInputStream();
            status = true;
            while (status) {
                try {
                    if (in.available() != 0) {
                        System.out.println("antes    "+in.available());
                        int a = in.available();
                        serial.bytesM=0;
                        for (int x = a; x > 0; x--) {
                            serial.bytesM=(char) in.read();
                            if(!String.valueOf(serial.bytesM).equals(null)){
                            serial.mensaje= serial.mensaje + String.valueOf(serial.bytesM);
                            }
                        }
                        Ventas.codigoText.setText(serial.mensaje);
                        serial.mensaje="";
                        in.close();
                    }
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(lecturaSerial.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void abrePuerto() {
        serial.puerto = SerialPort.getCommPort(serial.listaPuertos.getItem(0));
        if (serial.puerto.isOpen() == false) {
            serial.puerto.openPort();
        }
        System.err.println(serial.puerto.isOpen());
    }

}
