import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Desafio extends JPanel {

    JButton[] botones;
    ImageIcon[] respuestas;
    JPanel botonesInferiores, panelAciertos;
    JTextField numeroAciertos;
    Random random;
    short aciertos;
    byte botonesPresionados;
    Desafio(int largo){
        final int ancho = 5;
        random = new Random();
        respuestas = new ImageIcon[largo * ancho];

        botonesInferiores = new JPanel();
        botonesInferiores.setLayout(new GridLayout(largo,ancho,8,8));

        panelAciertos = new JPanel(new FlowLayout());

        numeroAciertos = new JTextField("El numero de aciertos es: " + aciertos);
        numeroAciertos.setFont(new Font("Ink Free", Font.BOLD, 30));
        numeroAciertos.setBorder(BorderFactory.createBevelBorder(1));
        numeroAciertos.setHorizontalAlignment(JTextField.CENTER);
        numeroAciertos.setEditable(false);

        panelAciertos.add(numeroAciertos);

        botones =  new JButton[respuestas.length];
        for (int j = 0 ; j < respuestas.length; j++) {
            botones[j] = new JButton();
            botones[j].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JButton boton = (JButton) e.getSource();

                    try {
                        String opcionElegida = JOptionPane.showInputDialog("Que letra es esta");

                        Character letra = opcionElegida.toLowerCase().charAt(0);

                        if (letra.equals(Abecedario.abecedarioInvertido.get(boton.getIcon())))
                        {
                            aciertos++;
                            numeroAciertos.setText("El numero de aciertos es: " + aciertos);
                            boton.setBackground(Color.GREEN);
                            boton.setEnabled(false);
                        }
                        else {
                            boton.setBackground(Color.red);
                            boton.setEnabled(false);
                        }
                    }catch (NullPointerException ignore){

                    }catch (StringIndexOutOfBoundsException ignore){
                        boton.setEnabled(false);
                        boton.setBackground(Color.RED);
                    }

                    botonesPresionados++;

                    if (botonesPresionados == respuestas.length){

                        int confirmacion = JOptionPane.showConfirmDialog(Desafio.this, "¿Quieres " +
                                "continuar con mas?", "Confirmacion", JOptionPane.YES_NO_OPTION);

                        if (confirmacion == JOptionPane.YES_OPTION){
                            botonesPresionados = 0;
                            cambiarRespuestas();
                        }
                    }
                }
            });
            botonesInferiores.add(botones[j]);
        }

        setLayout(new BorderLayout());
        add(panelAciertos, BorderLayout.NORTH);
        add(botonesInferiores, BorderLayout.CENTER);
        cambiarRespuestas();

    }
    public void cambiarImagenes(JButton[] botones, ImageIcon[] respuestas){

        ArrayList<ImageIcon> imagenes = new ArrayList<>(Arrays.asList(respuestas));

        for (int i = 0; i < botones.length; i++) {

            ImageIcon nuevaImagen = imagenes.get(random.nextInt(imagenes.size()));
            imagenes.remove(nuevaImagen);
            botones[i].setIcon(nuevaImagen);
            botones[i].setBackground(Color.GRAY);
            botones[i].setEnabled(true);
        }
    }

    private void cambiarRespuestas(){

        //--------------------------------------- esto es para añadir letras aleatorias sin repetirse----------------
        int i = 0;
        while (i < respuestas.length){

            ImageIcon nuevaImagen = Abecedario.abecedario.get(Abecedario.getIndexAbc(random.nextInt(27)));
            boolean imagenEnArreglo = false;

            for (ImageIcon imagen: respuestas){
                if (imagen != null && imagen.equals(nuevaImagen))
                    imagenEnArreglo = true;
            }

            if (!imagenEnArreglo) {
                respuestas[i] = nuevaImagen;
                i++;
            }
        }
        cambiarImagenes(botones, respuestas);
    }
}
