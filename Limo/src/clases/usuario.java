/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Juan_Garrido
 */
public class usuario {

    public static String nick;
    public static int idUsuario;
    public static int idRol;

    public static String getNick() {
        return nick;
    }

    public static void setNick(String nick) {
        usuario.nick = nick;
    }

    public static int getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(int idUsuario) {
        usuario.idUsuario = idUsuario;
    }

    public static int getIdRol() {
        return idRol;
    }

    public static void setIdRol(int idRol) {
        usuario.idRol = idRol;
    }

}
