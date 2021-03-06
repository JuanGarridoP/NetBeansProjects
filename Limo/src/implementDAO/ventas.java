/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementDAO;

import clases.usuario;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import limo.Formulario;

/**
 *
 * @author Juan_Garrido
 */
public class ventas extends conexionSQL {

    private static ResultSet res;

    public static ArrayList<String> Buscador(String cadena) {
        ArrayList<String> lista = new ArrayList<>();
        try {
            res = ejecutarSQLselect("select * from limo." + venta.seleccion + " where Lugar LIKE '%" + cadena + "%'");
            while (res.next()) {
                lista.add(res.getString("Lugar"));
            }
            res.close();
            return lista;

        } catch (SQLException e) {
            Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE, null, e);
            //return "Verifique su conexión a base de datos";
            return null;
        }
    }

    public static void Montos(String lugar) {

        try {
            res = ejecutarSQLselect("select * from limo." + venta.seleccion + " where Lugar='" + lugar + "'");
            venta.lista = new ArrayList<>();
            while (res.next()) {
                if (venta.seleccion.equals("zonas")) {
                    venta.lista.add(res.getString("idZona"));
                    venta.lista.add(res.getString("lugar"));
                    venta.lista.add(res.getString("monto"));
                    venta.lista.add(res.getString("zona"));
                } else {
                    venta.lista.add(res.getString("idForanea"));
                    venta.lista.add(res.getString("lugar"));
                    venta.lista.add(res.getString("monto"));
                    venta.lista.add("ZF");
                }

            }

        } catch (SQLException e) {

        }
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
        String sql = "";
        if (idZona == 0) {
            sql = "INSERT INTO limo.ventas(idConductor, idUsuario,idUnidad,idZona,idForanea,folio,fechaHora) VALUES ('" + idConductor + "','" + idUsuario + "','" + idUnidad + "'," + null + ",'" + idForanea + "','" + folio + "','" + fecha + "')";
        } else if (idForanea == 0) {
            sql = "INSERT INTO limo.ventas(idConductor, idUsuario,idUnidad,idZona,idForanea,folio,fechaHora) VALUES ('" + idConductor + "','" + idUsuario + "','" + idUnidad + "','" + idZona + "'," + null + ",'" + folio + "','" + fecha + "')";
        }

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

    public static void fillForm() {
        Formulario.clienteText.setText(venta.cliente);
        Formulario.conductorText.setText(venta.conductor);
        Formulario.destinoText.setText(venta.lista.get(1));
        Formulario.unidadText.setText(venta.numeroEconomico);
        Formulario.zonaText.setText(venta.lista.get(3));
        Formulario.idConductorText.setText(venta.idConductor);
        Formulario.idUnidadText.setText(venta.idUnidad);
        if (venta.seleccion.equals("zonas")) {
            Formulario.idZonaText.setText(venta.lista.get(0));
        } else {
            Formulario.idForaneaText.setText(venta.lista.get(0));
        }
        Formulario.idUsuarioText.setText(String.valueOf(usuario.idRol));

    }
}
