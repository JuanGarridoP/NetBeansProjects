/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementDAO;

import static implementDAO.conexionSQL.ejecutarSQL;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Juan_Garrido
 */
public class roles extends conexionSQL{
    private static ResultSet res;
    public static Map<Integer, String> getRoles() {
        Map<Integer, String> roles = new HashMap<Integer, String>();
        try {
               res = ejecutarSQLselect("select * from limo.roles");
               while(res.next()){
                   roles.put(res.getInt("idRol"), res.getString("roles"));
                   //roles.add(res.getString("roles"));
                   //ids.add(res.getString("idRol"));
               }
               return roles;
         } catch (SQLException e) {
               Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE,null,e);
               return null;
         }
    }
}
