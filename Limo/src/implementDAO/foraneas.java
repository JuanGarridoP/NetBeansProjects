/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementDAO;

import clases.venta;
import static implementDAO.conexionSQL.ejecutarSQLselect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan_Garrido
 */
public class foraneas extends conexionSQL {

    private static ResultSet res;

    public static boolean insertForanea(String nombre, float monto) {
        String sql = "INSERT INTO limo.foraneas(Lugar, Monto) VALUES ('" + nombre + "','" + monto + "'')";
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
    
    public static ArrayList<String> buscadorForaneo(String cadena){
        ArrayList<String> lista = new ArrayList<>();
        try {
            res = ejecutarSQLselect("select * from limo.foraneas where Lugar = '"+cadena+"'");
            while (res.next()) {
                lista.add(res.getString("idForanea"));
                lista.add(res.getString("Lugar"));
                lista.add(res.getString("Monto"));
            }
            res.close();
            return lista;

        } catch (SQLException e) {
            Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        
    }
    
    public static ArrayList<String> filtro(String cadena){
        ArrayList<String> lista = new ArrayList<>();
        try {
            res = ejecutarSQLselect("select * from limo.foraneas WHERE Lugar LIKE '%" + cadena + "%'");
            while (res.next()) {
                lista.add(res.getString("Lugar"));
            }
            res.close();
            return lista;

        } catch (SQLException e) {
            Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        
    }
    
    public static boolean updateForanea(int idForanea,String nombre, float monto) {
        try {
            if (ejecutarSQL("UPDATE limo.usuarios SET 'Lugar'='"+nombre+"','Monto'='"+monto+"' WHERE 'idForanea' = '"+idForanea+"'")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
