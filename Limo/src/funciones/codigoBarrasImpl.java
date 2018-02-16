/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import implementDAO.conexionSQL;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;

/**
 *
 * @author Juan_Garrido
 */
public class codigoBarrasImpl extends conexionSQL {
    private static ResultSet res;
    public static ImageIcon getBarCode(String num){
         Barcode barcode = null;
        try {
            barcode = BarcodeFactory.createCode39(num, true);
        } catch (Exception e) {
        }
        barcode.setDrawingText(false);

        barcode.setBarWidth(2);
        barcode.setBarHeight(60);
        BufferedImage image = new BufferedImage(300, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) image.getGraphics();

        try {
            barcode.draw(g, 5, 20);
        } catch (Exception e) {
        }
        ImageIcon icon = new ImageIcon(image);
        return icon;
    }
    
    public static boolean searchCode(int num){
        try {
            res = ejecutarSQLselect("select * from limo.conductores where codigo = "+num+"");
            return res.next();
        } catch (SQLException ex) {
            Logger.getLogger(codigoBarrasImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

