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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan_Garrido
 */
public class ventas extends conexionSQL{
    private static ResultSet res;
    
    public static ArrayList<String> Buscador(String tabla, String cadena){
boolean rcon=true;
ArrayList<String> lista = new ArrayList<>();
   if(rcon==true){ 
       try {
           
           int cont=0;

           res = ejecutarSQLselect("select * from limo."+tabla+" where Lugar LIKE '%"+cadena+"%'");
           while(res.next()){
               lista.add(res.getString("Lugar"));
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

public static String Montos(String lugar){
boolean rcon=true;
   if(rcon==true){ 
       try {
           res = ejecutarSQLselect("select * from limo.foraneas where Lugar='"+lugar+"'");
           while(res.next()){
               return res.getString("Monto");
           }
         
           
       } catch (SQLException e) {
           Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE,null,e);
           return "Verifique su conexión a base de datos";
       }
   }
   else{
       return "Verifique su conexión...";
   }
        return "null";
}

public static boolean venta(int conductor,int usuario,int unidad, int  destino,int foranea){
        return false;

    
            /*String created = fecha.get(Calendar.YEAR)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.DAY_OF_MONTH);;
            String sql="INSERT INTO limo.usuarios(Usuario, Correo,Password,idRol,FechaCreacion) VALUES ('"+usuario+"','"+correo+"','"+password+"',"+rol+",'"+created+"')";
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
            }*/
            
   }
    
}
