/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementDAO;

import static implementDAO.conexionSQL.ejecutarSQLselect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import limo.Menu;
import ventaFunctions.ventaImpl;

/**
 *
 * @author Juan_Garrido
 */
public class users extends conexionSQL {
    private static ResultSet res;
    public static boolean userInsert(String usuario, String correo, String password,int rol ){
            Calendar fecha = new GregorianCalendar();
            String created = fecha.get(Calendar.YEAR)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.DAY_OF_MONTH);;
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
            }
    }
    public static boolean userUpdate(String usuario, String correo, String password, int idRol,int idUser, boolean pass){
        try{
                
                boolean exec;
                if(pass){
                   exec = ejecutarSQL("UPDATE limo.usuarios SET 'idRol'='"+idRol+"','Usuario'='"+usuario+"','Correo'='"+correo+"','Password'='"+password+"' WHERE 'IdUsuario'="+idUser+"");
                }
                else{
                   exec = ejecutarSQL("UPDATE limo.usuarios SET 'idRol'='"+idRol+"','Usuario'='"+usuario+"','Correo'='"+correo+"' WHERE 'IdUsuario'="+idUser+"");
                }
                return exec;
            }
            catch(Exception e){
                Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE,null,e);
            }
        return false;
    }
    
    public static String autenticar(String user, String pass) {
            try {
                res = ejecutarSQLselect("select * from limo.usuarios where Usuario='"+user+"'");
                while(res.next()){
                    if(pass.equals(res.getString("Password"))){
                        Menu m = new Menu(); 
                        m.setVisible (true); 
                        return "Autenticado";
                    }
                    else{
                        return "Credenciales inválidas";
                    }
                }
                res.close();
            } catch (SQLException e) {
                Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE,null,e);
                return "Verifique su conexión a base de datos";
            }
            return null;
        }
    
    public static HashMap<String, List<String>> buscaUsuarios(String cadena){
        boolean rcon=true;
        
        HashMap<String, List<String>> usuario = new HashMap<>();
            if(rcon==true){ 
                try {
                    res = ejecutarSQLselect("select * from limo.usuarios INNER JOIN roles ON usuarios.idRol = roles.idRol where Usuario LIKE '%"+cadena+"%'");
                    while(res.next()){
                        List<String> lista = new ArrayList<String>();
                        lista.add(res.getString("idUsuario"));
                        lista.add(res.getString("Correo"));
                        lista.add(res.getString("Password"));
                        lista.add(res.getString("idRol"));
                        lista.add(res.getString("FechaCreacion"));
                        lista.add(res.getString("roles"));
                        usuario.put(res.getString("Usuario"),lista);
                    }
                    res.close();
                    return usuario;
                } catch (SQLException e) {
                    Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE,null,e);
                }
            }
                 return null;
         }
    
         public static HashMap<String, List<String>> allUsuarios(){
        boolean rcon=true;
        HashMap<String, List<String>> usuario = new HashMap<>();
            if(rcon==true){ 
                try {
                    res = ejecutarSQLselect("select * from limo.usuarios ");
                    while(res.next()){
                        List<String> lista = new ArrayList<String>();
                        lista.add(res.getString("idUsuario"));
                        lista.add(res.getString("Correo"));
                        lista.add(res.getString("Password"));
                        lista.add(res.getString("idRol"));
                        lista.add(res.getString("FechaCreacion"));
                        usuario.put(res.getString("Usuario"),lista);
                    }
                    res.close();
                    return usuario;
                } catch (SQLException e) {
                    Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE,null,e);
                }
            }
                 return null;
         }
  
    
}
