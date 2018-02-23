/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementDAO;

import clases.venta;
import static implementDAO.conexionSQL.ejecutarSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import limo.Formulario;

/**
 *
 * @author Juan_Garrido
 */
public class ventas extends conexionSQL {

    private static ResultSet res;

    public static ArrayList<String> Buscador(String tabla, String cadena) {
        boolean rcon = true;
        ArrayList<String> lista = new ArrayList<>();
        if (rcon == true) {
            try {

                int cont = 0;

                res = ejecutarSQLselect("select * from limo." + tabla + " where Lugar LIKE '%" + cadena + "%'");
                while (res.next()) {
                    lista.add(res.getString("Lugar"));
                }
                res.close();
                return lista;

            } catch (SQLException e) {
                Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE, null, e);
                //return "Verifique su conexión a base de datos";
            }
        } else {
            //return "Verifique su conexión...";
        }
        return null;
    }

    public static String Montos(String lugar) {
        boolean rcon = true;
        if (rcon == true) {
            try {
                res = ejecutarSQLselect("select * from limo.foraneas where Lugar='" + lugar + "'");
                while (res.next()) {
                    return res.getString("Monto");
                }

            } catch (SQLException e) {
                Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE, null, e);
                return "Verifique su conexión a base de datos";
            }
        } else {
            return "Verifique su conexión...";
        }
        return "null";
    }

    

    public void cleanVentas() {
        venta.idConductor = "";
        venta.idUnidad = "";
        venta.conductor = "";
        venta.fechaNac = "";
        venta.direccion = "";
        venta.codigoBarras = "";
        venta.telefono = "";
        venta.permiso = "";
        venta.numeroEconomico = "";
        venta.placas = "";
        venta.modelo = "";
        venta.seguroFin = "";
    }
    
    public static boolean ventaInsert(int idConductor, int idUsuario, int idUnidad, int idZona, int idForanea, String folio, String fecha) {
        String sql = "INSERT INTO limo.conductores(idConductor, idUsuario,idUnidad,idZona,idForanea,folio,fechaHora) VALUES ('" + idConductor + "','" + idUsuario + "','" + idUnidad + "','" + idZona + "','" + idForanea + "','" + folio + "','" + fecha+ "')";
        System.out.println(sql);
        try {
            if (ejecutarSQL(sql) == true) {
                return true;
            } 
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static String buscaFolio() {
        boolean rcon = true;
        String folio = "", newFolio = "";
        String[] partFolio;
        DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        Date date = new Date();
        if (rcon == true) {
            try {
                res = ejecutarSQLselect("SELECT * FROM ventas ORDER BY idVenta DESC LIMIT 1");
                while (res.next()) {
                    folio = res.getString("folio");
                };
                if (!folio.equals("")) {
                    partFolio = folio.split("-");
                    if (partFolio[1].equals(dateFormat.format(date))) {
                        newFolio = String.valueOf((Integer.parseInt(partFolio[0])) + 1) + "-" + dateFormat.format(date);
                    } else {
                        newFolio = "1" + "-" + dateFormat.format(date);
                    }
                } else {
                    newFolio = "1" + "-" + dateFormat.format(date);
                }
                return newFolio;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
    
    public static void fillForm(){
        Formulario.clienteText.setText(venta.cliente);
        Formulario.conductorText.setText(venta.conductor);
        Formulario.destinoText.setText(venta.destino);
        Formulario.unidadText.setText(venta.numeroEconomico);
        Formulario.zonaText.setText(venta.zona);
    }
}
