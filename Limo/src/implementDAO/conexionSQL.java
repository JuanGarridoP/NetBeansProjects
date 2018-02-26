/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementDAO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import limo.*;
import java.util.ArrayList;
/**
 *
 * @author Juan_Garrido
 */
public class conexionSQL {
    private static Connection con ;
    private static Statement stm;
    private static ResultSet rset;
    private ArrayList<String> lista;
    
    
    private static Connection conexion() throws SQLException{   
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/limo?user=root&password=");
            return con;

        }catch(ClassNotFoundException | SQLException e){
            Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
            con.close();
        }
        return null;
    }
    private static void closeCon() throws SQLException{   
        try{
            conexion().close();
        }catch(SQLException e){
            Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
        }   
    }
    protected static ResultSet ejecutarSQLselect(String sql) throws SQLException{
        try {
            stm = conexion().createStatement();
            rset = stm.executeQuery(sql);
            return rset;
            } catch (SQLException e) {
                Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE,null,e);
                closeCon();
                return null;
            }
        }
    protected static boolean ejecutarSQL(String sql) throws SQLException{
        try {
            stm = conexion().createStatement();
            stm.executeUpdate(sql);
            return true;
            } catch (SQLException e) {
                Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE,null,e);
                closeCon();
                return false;
            }
        }
 
/**
*
*Método utilizado para realizar la instrucción SELECT
*@param sql Cadena que contiene la instrucción SQL a ejecutar
*@return resultado regresa los registros generados por la consulta
*
*/
public ResultSet ejecutarSQLSelect(String sql)
{
   
   
   try {
      stm = con.createStatement();
      rset = stm.executeQuery(sql);
      
      while(rset.next()){
          //System.out.println(resultado.getString("nombre"));
      }
      
   } catch (SQLException e) {
      Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE,null,e);
      return null;
   }
 
   return null;
}



    
    
    
}
