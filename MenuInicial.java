import javax.swing.*;
import java.awt.*;

public class MenuInicial extends JFrame {

    JPanel inicio, tittleJus, seleccion ;

    JButton aprender, salir;

    JLabel titulo;

    MenuInicial(){
        inicio = new JPanel(new BorderLayout());
        seleccion = new JPanel(new GridLayout(2,1,5,5 ));
        tittleJus = new JPanel(new FlowLayout());

        aprender = new JButton("Aprender");
        salir = new JButton("salir");

        titulo= new JLabel("SignLearn");


        aprender.addActionListener(e -> {
            MenuSuperior menu = new MenuSuperior();
            add(menu);
        });




        tittleJus.add(titulo);

        inicio.add(tittleJus, BorderLayout.NORTH);
        seleccion.add(aprender);
        seleccion.add(salir);
        inicio.add(seleccion, BorderLayout.CENTER);
        add(inicio);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        MenuInicial menu = new MenuInicial();
    }

}
