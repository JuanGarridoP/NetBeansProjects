/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventaFunctions;

import implementDAO.conexionSQL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Juan_Garrido
 */
public class ventaImpl extends conexionSQL{
    private static JasperReport report;
    private static JasperPrint reportFilled;
    private static JasperViewer viwer;
            
            
    public static Collection ticketImpl(){
        Vector collection = new Vector();
        if(insertaVenta()){
            collection.add("");
        }
        return collection;
    }
    
    private static boolean insertaVenta(){
        boolean exec=false;
            try{
                exec=ejecutarSQL("");
               return exec;
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
        
    }
    
    public static void createReport(String path){
        try {
            report = (JasperReport) JRLoader.loadObject(path);
        } catch (JRException ex) {
            Logger.getLogger(ventaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
