package funciones;


import com.fazecast.jSerialComm.SerialPort;
import funciones.lecturaSerial;
import java.awt.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan_Garrido
 */
public class serial {
    public static SerialPort puerto;
    public static int bytes;
    public static List listaPuertos ;
    public static SerialPort[] puertos;
    public static String mensaje="";
    public static char bytesM;

    public static String getMensaje() {
        return mensaje;
    }

    public static void setMensaje(String mensaje) {
        serial.mensaje = mensaje;
    }

    public static SerialPort getPuerto() {
        return puerto;
    }

    public static void setPuerto(SerialPort puerto) {
        serial.puerto = puerto;
    }

    public static int getBytes() {
        return bytes;
    }

    public static void setBytes(int bytes) {
        serial.bytes = bytes;
    }

    public static List getListaPuertos() {
        return listaPuertos;
    }

    public static void setListaPuertos(List listaPuertos) {
        serial.listaPuertos = listaPuertos;
    }

    public static SerialPort[] getPuertos() {
        return puertos;
    }

    public static void setPuertos(SerialPort[] puertos) {
        serial.puertos = puertos;
    }
}
