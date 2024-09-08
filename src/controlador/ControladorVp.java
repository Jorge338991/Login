
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloLogin;
import vista.VistaVp;


public class ControladorVp implements ActionListener {
    //ATRIBUTOS
    private VistaVp  vista;
    private ModeloLogin modelo;
    
    
    //METODOS
    //CONSTRUCTOR

    public ControladorVp(VistaVp vista, ModeloLogin modelo,String titulo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.getjButtonSalir().addActionListener(this);
        inciarVista(titulo);
        
    }
    
    public void inciarVista(String titulo){
        this.vista.setTitle(titulo);
        this.vista.setLocationRelativeTo(null);
        this.vista.getjLabel1().setText("Benvido "+modelo.getUsuario());
        this.vista.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        if(vista.getjButtonSalir() == event.getSource()){
            System.exit(-1);
        }
        
    }
}
