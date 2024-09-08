
package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Conexion {
    //ATRIBUTOS
    private Connection      miConexion;
    private Statement       enviarSql;
    private ResultSet       resultado;
    private int             insertUpdateFeito;
    //METOTDOS
    public Conexion() {
        
    }
    //GETTERS AND SETTERS

    public Connection getMiConexion() {
        return miConexion;
    }

    public void setMiConexion(Connection miConexion) {
        this.miConexion = miConexion;
    }
    
    
    public int getInsertUpdateFeito() {
        return insertUpdateFeito;
    }

    public void setInsertUpdateFeito(int insertUpdateFeito) {
        this.insertUpdateFeito = insertUpdateFeito;
    }
    //METODOS A MAIORES

    
    public void iniciarConexion(){
        try{
        miConexion =  DriverManager.getConnection("jdbc:mysql://localhost:3306/bdprueba", "root", "");
        enviarSql = miConexion.createStatement();
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null,"Error o iniciar a conexion.\nError:"+error);
        }
    }
    
    public void cerrarConexion(){
        try{
            miConexion.close();
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null,"Error o cerrar a conexion.\nError:"+error);
        }
    }
    
    public ResultSet ejecutarConsulta(String consulta){
        try{
            resultado = enviarSql.executeQuery(consulta);
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, "Ha sido imposible ejecutar la consulta\nError:"+error);
        }
        return resultado;
    }
    public int ejecutarActualizacion(String consulta){
        insertUpdateFeito=-1;
            
        try{
           
            insertUpdateFeito = enviarSql.executeUpdate(consulta);
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, "Ha sido imposible ejecutar la actualización\nError:"+error);
        }
        return insertUpdateFeito;
    }
}
