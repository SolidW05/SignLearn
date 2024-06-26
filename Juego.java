import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Juego extends JPanel implements ActionListener {

    JButton[] botones, botonesAMostrar;
    JPanel botonesSuperiores, botonesInferiores;
    ImageIcon[] respuestas;
    Random random;
    byte ponerImagenes = 0;
    byte respuestasIncorrectas = 0;
    byte respuestasCorrectas = 0;
    Juego(ImageIcon img1, ImageIcon img2,ImageIcon img3,ImageIcon img4,ImageIcon img5){
        random = new Random();
        respuestas = new ImageIcon[20];

        // estas son las respuestas correctas
        respuestas[0] = img1;
        respuestas[1] = img2;
        respuestas[2] = img3;
        respuestas[3] = img4;
        respuestas[4] = img5;

        //--------------------------------------- esto es para añadir letras aleatorias sin repetirse----------------
        int i = 5;
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

        //----------------se crea el panel superior
        botonesSuperiores = new JPanel();
        botonesSuperiores.setBackground(Color.lightGray);
        botonesSuperiores.setLayout(new FlowLayout());

        botonesAMostrar = new JButton[5];
        botonesAMostrar[0] = new JButton(img1);
        botonesAMostrar[1]= new JButton(img2);
        botonesAMostrar[2]= new JButton(img3);
        botonesAMostrar[3]= new JButton(img4);
        botonesAMostrar[4]= new JButton(img5);


        for (JButton boton: botonesAMostrar){
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ponerImagenes++;
                    JButton boton = (JButton) e.getSource();

                    Abecedario.sonidoletra((ImageIcon) boton.getIcon());

                    JOptionPane.showMessageDialog(Juego.this, "Esto es " +
                                    Abecedario.abecedarioInvertido.get(boton.getIcon()),
                            "Letra", JOptionPane.ERROR_MESSAGE, boton.getIcon());
                    boton.setVisible(false);

                    if (ponerImagenes == botonesAMostrar.length)
                        cambiarImagenes(botones);

                }
            });
            botonesSuperiores.add(boton);
        }

        botonesInferiores = new JPanel();
        botonesInferiores.setBackground(Color.lightGray);
        botonesInferiores.setLayout(new GridLayout(4,5,8,8));

        botones =  new JButton[respuestas.length];

        for (int j = 0 ; j < respuestas.length; j++) {
            botones[j] = new JButton();
            botones[j].setEnabled(false);
            botones[j].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JButton boton = (JButton) e.getSource();

                    if (boton.getIcon().equals(respuestas[0]) || boton.getIcon().equals(respuestas[1]) ||
                            boton.getIcon().equals(respuestas[2]) || boton.getIcon().equals(respuestas[3]) ||
                            boton.getIcon().equals(respuestas[4]))
                    {
                        boton.setEnabled(false);
                        boton.setBackground(Color.GREEN);
                        respuestasCorrectas++;
                        if (respuestasCorrectas == botonesAMostrar.length){
                            JOptionPane.showMessageDialog(Juego.this, "Bien hecho, lo has completado!!!\nPresiona el" +
                                            " boton de volver para seguir aprendiendo",
                            "Felicidades", JOptionPane.PLAIN_MESSAGE);

                            for (JButton botonInter: botones){
                                botonInter.setEnabled(false);
                            }
                        }
                    }
                    else
                    {
                    boton.setEnabled(false);
                    boton.setBackground(Color.RED);
                    respuestasIncorrectas++;
                    if (respuestasIncorrectas > botonesAMostrar.length) {
                        respuestasCorrectas = 0;
                        respuestasIncorrectas = 0;
                        cambiarImagenes(botones);
                    }
                    }

                }
            });
            botonesInferiores.add(botones[j]);
        }

        setLayout(new BorderLayout());
        add(botonesInferiores, BorderLayout.CENTER);
        add(botonesSuperiores, BorderLayout.NORTH);

    }

    Juego(ImageIcon img1, ImageIcon img2,ImageIcon img3,ImageIcon img4,ImageIcon img5, ImageIcon img6){
        random = new Random();
        respuestas = new ImageIcon[20];

        // estas son las respuestas correctas
        respuestas[0] = img1;
        respuestas[1] = img2;
        respuestas[2] = img3;
        respuestas[3] = img4;
        respuestas[4] = img5;
        respuestas[5] = img6;

        //--------------------------------------- esto es para añadir letras aleatorias sin repetirse----------------
        int i = 6;
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

        //----------------se crea el panel superior
        botonesSuperiores = new JPanel();
        botonesSuperiores.setBackground(Color.lightGray);
        botonesSuperiores.setLayout(new FlowLayout());

        botonesAMostrar = new JButton[6];
        botonesAMostrar[0] = new JButton(img1);
        botonesAMostrar[1]= new JButton(img2);
        botonesAMostrar[2]= new JButton(img3);
        botonesAMostrar[3]= new JButton(img4);
        botonesAMostrar[4]= new JButton(img5);
        botonesAMostrar[5]= new JButton(img6);



        for (JButton boton: botonesAMostrar){
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ponerImagenes++;
                    JButton boton = (JButton) e.getSource();

                    Abecedario.sonidoletra((ImageIcon) boton.getIcon());
                    JOptionPane.showMessageDialog(Juego.this, "Esto es " +
                                    Abecedario.abecedarioInvertido.get(boton.getIcon()),
                            "Letra", JOptionPane.ERROR_MESSAGE, boton.getIcon());
                    boton.setVisible(false);

                    if (ponerImagenes == botonesAMostrar.length)
                        cambiarImagenes(botones);
                }
            });
            botonesSuperiores.add(boton);
        }

        botonesInferiores = new JPanel();
        botonesInferiores.setBackground(Color.lightGray);
        botonesInferiores.setLayout(new GridLayout(4,5,8,8));

        botones =  new JButton[respuestas.length];

        for (int j = 0 ; j < respuestas.length; j++) {
            botones[j] = new JButton();
            botones[j].setEnabled(false);
            botones[j].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JButton boton = (JButton) e.getSource();

                    if (boton.getIcon().equals(respuestas[0]) || boton.getIcon().equals(respuestas[1]) ||
                            boton.getIcon().equals(respuestas[2]) || boton.getIcon().equals(respuestas[3]) ||
                            boton.getIcon().equals(respuestas[4]) || boton.getIcon().equals(respuestas[5]))
                    {
                        Abecedario.sonidoletra((ImageIcon) boton.getIcon());
                        boton.setEnabled(false);
                        boton.setBackground(Color.GREEN);
                        respuestasCorrectas++;
                        if (respuestasCorrectas == botonesAMostrar.length){
                            JOptionPane.showMessageDialog(Juego.this, "Bien hecho, lo has completado!!!\nPresiona el" +
                                            " boton de volver para seguir aprendiendo",
                                    "Felicidades", JOptionPane.PLAIN_MESSAGE);

                            for (JButton botonInter: botones){
                                botonInter.setEnabled(false);
                            }
                        }
                    }
                    else
                    {
                        Abecedario.sonidoletra((ImageIcon) boton.getIcon());
                        boton.setEnabled(false);
                        boton.setBackground(Color.RED);
                        respuestasIncorrectas++;
                        if (respuestasIncorrectas > botonesAMostrar.length) {
                            respuestasCorrectas = 0;
                            respuestasIncorrectas = 0;
                            cambiarImagenes(botones);
                        }
                    }

                }
            });
            botonesInferiores.add(botones[j]);
        }

        setLayout(new BorderLayout());
        add(botonesInferiores, BorderLayout.CENTER);
        add(botonesSuperiores, BorderLayout.NORTH);

    }


    public void cambiarImagenes(JButton[] botones){

        ArrayList<ImageIcon> imagenes = new ArrayList<>(Arrays.asList(respuestas));

        for (int i = 0; i < botones.length; i++) {

            ImageIcon nuevaImagen = imagenes.get(random.nextInt(imagenes.size()));
            imagenes.remove(nuevaImagen);
            botones[i].setIcon(nuevaImagen);
            botones[i].setBackground(Color.GRAY);
            botones[i].setEnabled(true);
        }

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        Juego juego = new Juego(Abecedario.abecedario.get('a'),Abecedario.abecedario.get('b'),
                Abecedario.abecedario.get('c'),Abecedario.abecedario.get('d'),Abecedario.abecedario.get('e'));

        frame.setSize(1300,800);
        frame.add(juego);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
