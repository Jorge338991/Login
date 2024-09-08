package proyecto12mas1_applogin;


import controlador.ControladorLogin;
import modelo.ModeloLogin;
import vista.VistaLogin;


public class Proyecto12mas1_applogin {

    public static void main(String[] args) {
        
        ModeloLogin m1 = new ModeloLogin();
        VistaLogin  v1 = new VistaLogin();
        ControladorLogin c1= new ControladorLogin(v1,m1);
    }

}
