import javax.swing.*;
import java.awt.*;

public class MenuSuperior extends JPanel {

    JButton botones[];

    MenuSuperior(){

        botones = new JButton[5];
        botones[0] = new JButton(Abecedario.abecedario.get('a'));
        botones[1] = new JButton(Abecedario.abecedario.get('f'));
        botones[2] = new JButton(Abecedario.abecedario.get('k'));
        botones[3] = new JButton(Abecedario.abecedario.get('p'));
        botones[4] = new JButton(Abecedario.abecedario.get('u'));
        
        setLayout( new FlowLayout());

        for(JButton boton: botones){
            add(boton);
        }
    }
}
