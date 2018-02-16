/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementDAO;

import static implementDAO.conexionSQL.ejecutarSQL;

/**
 *
 * @author Juan_Garrido
 */
public class unidades {
    public static boolean unidadInsert(int idConcesionario, int idConductor, int numero,String placas,String fechaIni, String fechaFin,String modelo){
            String sql="INSERT INTO limo.unidades(idConductor, idConcesionario,numero,placas,modelo,seguroIni,seguroFin) VALUES ('"+idConductor+"','"+idConcesionario+"','"+numero+"','"+placas+"','"+modelo+"','"+fechaIni+"','"+fechaFin+"')";
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
}
