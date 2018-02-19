/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementDAO;

import clases.venta;
import static implementDAO.conexionSQL.ejecutarSQLselect;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan_Garrido
 */
public class conductores extends conexionSQL {

    private static ResultSet res;

    public static HashMap<String, String> buscaConductores(String cadena) {
        boolean rcon = true;
        HashMap<String, String> lista = new HashMap<>();
        if (rcon == true) {
            try {
                res = ejecutarSQLselect("select * from limo.conductores where nombre LIKE '%" + cadena + "%'");
                while (res.next()) {
                    lista.put(res.getString("nombre") + " " + res.getString("apellidoP") + " " + res.getString("apellidoM"), res.getString("idConductor"));
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

    public static boolean conInsert(String nombre, String apellidoP, String apellidoM, String genero, String fechaNac, String direccion, int telefono, int codigo, boolean concesionario, String permiso) {
        String sql = "INSERT INTO limo.conductores(nombre, apellidoP,apellidoM,genero,fechaNac,direccion,telefono,permiso,codigo) VALUES ('" + nombre + "','" + apellidoP + "','" + apellidoM + "','" + genero + "','" + fechaNac + "','" + direccion + "'," + telefono + ",'" + permiso + "'," + codigo + ")";
        System.out.println(sql);
        try {
            if (ejecutarSQL(sql) != true) {
                return false;
            } else {
                System.out.println("Inserto");
                if (concesionario) {
                    return concesionarios.conInsert(nombre, apellidoP, apellidoM, genero, fechaNac, direccion, telefono);
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static HashMap<String, String> buscaCodigo(String codigo, String destino,String cliente,String zona) {
        boolean rcon = true;
        HashMap<String, String> lista = new HashMap<>();
        if (rcon == true) {
            try {
                res = ejecutarSQLselect("select conductores.*,unidades.numero,unidades.placas,unidades.modelo,unidades.seguroIni,unidades.seguroFin from limo.conductores INNER JOIN unidades where codigo='" + codigo + "'");
                while (res.next()) {
                    venta.idConductor = res.getString("idConductor");
                    venta.idUnidad = res.getString("idUnidad");
                    venta.conductor = res.getString("nombre") + " " + res.getString("apellidoP") + " " + res.getString("apellidoM");
                    venta.fechaNac = res.getString("fechaNac");
                    venta.direccion = res.getString("direccion");
                    venta.codigoBarras=res.getString("codigo");
                    venta.telefono=res.getString("telefono");
                    venta.permiso=res.getString("permiso");
                    venta.numeroEconomico=res.getString("numero");
                    venta.placas=res.getString("placas");
                    venta.modelo=res.getString("modelo");
                    venta.seguroIni=res.getString("seguroIni");
                    venta.seguroFin=res.getString("seguroFin");
                    venta.zona=zona;
                    venta.cliente= cliente;
                    lista.put("idConductor", res.getString("idConductor"));
                    lista.put("idUnidad", res.getString("idUnidad"));
                    lista.put("conductor", res.getString("nombre") + " " + res.getString("apellidoP") + " " + res.getString("apellidoM"));
                    lista.put("fechaNac", res.getString("fechaNac"));
                    lista.put("direccion", res.getString("direccion"));
                    lista.put("codigoBarras", res.getString("codigo"));
                    lista.put("telefono", res.getString("telefono"));
                    lista.put("permiso", res.getString("permiso"));
                    lista.put("numeroEconomico", res.getString("numero"));
                    lista.put("placas", res.getString("placas"));
                    lista.put("modelo", res.getString("modelo"));
                    lista.put("seguroIni", res.getString("seguroIni"));
                    lista.put("seguroFin", res.getString("seguroFin"));
                }
                res.close();
                return lista;
            } catch (SQLException e) {
                Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null, e.getMessage(), "Atención", JOptionPane.ERROR_MESSAGE);
            }
        } 
        return null;
    }

}
