/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementDAO;

import static implementDAO.conexionSQL.ejecutarSQLselect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan_Garrido
 */
public class conductores extends conexionSQL{
    private static ResultSet res;
    public static HashMap<String, String> buscaConductores(String cadena){
        boolean rcon=true;
        HashMap<String, String> lista = new HashMap<>();
            if(rcon==true){ 
                try {
                    res = ejecutarSQLselect("select * from limo.conductores where nombre LIKE '%"+cadena+"%'");
                    while(res.next()){
                        lista.put(res.getString("nombre")+" "+res.getString("apellidoP")+" "+res.getString("apellidoM"),res.getString("idConductor"));
                    }
                    res.close();
                    return lista;
                } catch (SQLException e) {
                    Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE,null,e);
                    //return "Verifique su conexión a base de datos";
                }
            }
            else{
                //return "Verifique su conexión...";
            }
                 return null;
         }
    
    public static boolean conInsert(String nombre, String apellidoP, String apellidoM,String genero,String fechaNac, String direccion,int telefono, int codigo, boolean concesionario, String permiso){
            String sql="INSERT INTO limo.conductores(nombre, apellidoP,apellidoM,genero,fechaNac,direccion,telefono,permiso,codigo) VALUES ('"+nombre+"','"+apellidoP+"','"+apellidoM+"','"+genero+"','"+fechaNac+"','"+direccion+"',"+telefono+",'"+permiso+"',"+codigo+")";
            System.out.println(sql);
            try{
               if(ejecutarSQL(sql) != true){
                   return false;
               }
               else{
                System.out.println("Inserto");
                if(concesionario){
                    return concesionarios.conInsert(nombre, apellidoP, apellidoM, genero, fechaNac, direccion, telefono);
                }
                return true;
               }
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
            
            
    }
    
}