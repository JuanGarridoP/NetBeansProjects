/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementDAO;

import static implementDAO.conexionSQL.ejecutarSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan_Garrido
 */
public class locales extends conexionSQL {
    private static ResultSet res;
    public static boolean insertLocal(String nombre, float monto, String zona) {
        String sql = "INSERT INTO limo.zonas(local, montoLocal, zona) VALUES ('" + nombre + "','" + monto + "','"+zona+"')";
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
    
    public static ArrayList<String> buscadorLocal(String cadena){
        ArrayList<String> lista = new ArrayList<>();
        try {
            res = ejecutarSQLselect("select * from limo.zonas where local = "+cadena+"");
            while (res.next()) {
                lista.add(res.getString("idZona"));
                lista.add(res.getString("zona"));
                lista.add(res.getString("montoLocal"));
            }
            res.close();
            return lista;

        } catch (SQLException e) {
            Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        
    }
    
    public static boolean updateLocal(int idZona,String nombre, float monto, String zona) {
        try {
            if (ejecutarSQL("UPDATE limo.usuarios SET 'local'='"+nombre+"','montoLocal'='"+monto+"','zona'='+"+zona+"' WHERE 'idZona' = '"+idZona+"'")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
