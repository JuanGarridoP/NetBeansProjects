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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan_Garrido
 */
public class concesionarios extends conexionSQL{
    private static ResultSet res;
    public static boolean conInsert(String nombre, String apellidoP, String apellidoM,String genero,String fechaNac, String direccion,int telefono){
            String sql="INSERT INTO limo.concesionarios(nombre, apellidoP,apellidoM,genero,fechaNac,direccion,telefono) VALUES ('"+nombre+"','"+apellidoP+"','"+apellidoM+"','"+genero+"','"+fechaNac+"','"+direccion+"',"+telefono+")";
            System.out.println(sql);
            try{
               if(ejecutarSQL(sql) != true){
                   return false;
               }
               else{
                System.out.println("Inserto");
                return true;
               }
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
    }
    
    public static HashMap<String, List<String>> buscaConcesionarios(String cadena){
        boolean rcon=true;
        HashMap<String, List<String>> lista = new HashMap<>();
            if(rcon==true){ 
                try {
                    res = ejecutarSQLselect("select * from limo.concesionarios where nombre LIKE '%"+cadena+"%'");
                    while(res.next()){
                        List<String> atrib = new ArrayList<String>();
                        atrib.add(res.getString("idConcesionario"));
                        atrib.add(res.getString("genero"));
                        atrib.add(res.getString("fechaNac"));
                        atrib.add(res.getString("direccion"));
                        atrib.add(res.getString("telefono"));
                        lista.put(res.getString("nombre")+" "+res.getString("apellidoP")+" "+res.getString("apellidoM"),atrib);
                    }
                    res.close();
                    return lista;
                } catch (SQLException e) {
                    Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE,null,e);
                    //return "Verifique su conexión a base de datos";
                }
            }
            else{
           
            }
                 return null;
         }
    
    public static HashMap<String, List<String>> allConcesionarios(){
        boolean rcon=true;
        HashMap<String, List<String>> lista = new HashMap<>();
            if(rcon==true){ 
                try {
                    res = ejecutarSQLselect("select * from limo.concesionarios ");
                    while(res.next()){
                        List<String> atrib = new ArrayList<String>();
                        atrib.add(res.getString("idConcesionario"));
                        atrib.add(res.getString("genero"));
                        atrib.add(res.getString("fechaNac"));
                        atrib.add(res.getString("direccion"));
                        atrib.add(res.getString("telefono"));
                        lista.put(res.getString("nombre")+" "+res.getString("apellidoP")+" "+res.getString("apellidoM"),atrib);
                        
                    }
                    res.close();
                    return lista;
                } catch (SQLException e) {
                    Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE,null,e);
                    //return "Verifique su conexión a base de datos";
                }
            }
            else{
           
            }
                 return null;
         }
    
}
