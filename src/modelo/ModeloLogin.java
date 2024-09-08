package modelo;

import configuracion.Conexion;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ModeloLogin {
    
    //ATRIBUTOS
    private String usuario;
    private String contrasinal;
    
    //METODOS
    //CONSTRUCTOR
    public ModeloLogin() {

        
    }
    
    public ModeloLogin(String usuario, String contrasinal) {
        this.usuario = usuario;
        this.contrasinal = contrasinal;
        
    }
    //GETTERS

    public String getUsuario() {
        return usuario;
    }
    
    public String getContrasinal() {
        return contrasinal;
    }
    //SETTERS
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public void setContrasinal(String contrasinal) {
        this.contrasinal = contrasinal;
    }
    //METODOS A MAIORES
    public boolean existeUsuario() throws SQLException{
        boolean existe = false;
        ResultSet resultado;
        setContrasinal(getMD5(getContrasinal()));
        
        Conexion c1 = new Conexion();
        c1.iniciarConexion();
        resultado = c1.ejecutarConsulta("select usuario,contrasinal from usuario where usuario='"+getUsuario()+"' and contrasinal='"+getContrasinal()+"'");      
        if(resultado.next())existe=true;
        c1.cerrarConexion();
        
        return existe;
    }
    
    private static String getMD5(String input) {
        try {
               MessageDigest md = MessageDigest.getInstance("MD5");
               byte[] messageDigest = md.digest(input.getBytes());
               BigInteger number = new BigInteger(1, messageDigest);
               String hashtext = number.toString(16);

               while (hashtext.length() < 32) {
               hashtext = "0" + hashtext;
               }
               return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
 }
    
    

}
