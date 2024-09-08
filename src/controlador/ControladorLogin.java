
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloLogin;
import vista.VistaLogin;
import vista.VistaVp;


public class ControladorLogin implements ActionListener {
    //ATRIBUTOS
    private VistaLogin  vista;
    private ModeloLogin modelo;
    
    //METODOS
    //CONSTRUCTOR

    public ControladorLogin(VistaLogin vista, ModeloLogin modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.setTitle("CONTROL DE ACCESO");
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        
        this.vista.getjButtonEntrar().addActionListener(this);
                       
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        if(vista.getjButtonEntrar() == event.getSource()){
            modelo.setUsuario(vista.getjTextFieldUsuario().getText());
            modelo.setContrasinal(vista.getjPasswordFieldContrasinal().getText());
            
            try {
                boolean existe = modelo.existeUsuario();
                if(existe){
                    vista.getjLabelAccesoDenegado().setText("Acceso permitido");
                    vista.getjLabelAccesoDenegado().setForeground(Color.BLUE);
                    VistaVp vp1         = new VistaVp();
                    ControladorVp cvp1  = new ControladorVp(vp1,modelo,"Ventana principal");
                    vista.dispose();
                    
                    
                    
                }else{
                    JOptionPane.showMessageDialog(vista, "Usuario ou contrasinal incorrecto, revisa os datos de acceso e volva intentalo.", "ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
                    
                    //vista.getjLabelAccesoDenegado().setText("Acceso denegado");
                    //vista.getjLabelAccesoDenegado().setForeground(Color.RED);
                }
                
            } catch (SQLException ex) {
                
            }
        }
        
    }
    
    
    
    

}
