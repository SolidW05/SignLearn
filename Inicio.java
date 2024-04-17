import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {

    JLabel titulo;
    JPanel inicio, aprenderPanelInferior, aprenderPanelSuperior, aprenderPanelTotal, inferior;
    JButton aprender, desafio, regresar;
    Juego juego;
    JRadioButton aE, fK, lP, qU, vZ;
    ButtonGroup grupo;

    Inicio(){
        setSize(1200,800);
        setResizable(false);

        inicio = new JPanel(null);
        inferior = new JPanel(new FlowLayout());

        aprender = new JButton("Aprender");
        aprender.setBounds(500,200, 180, 50);
        aprender.setFont(new Font("MV Boli",Font.PLAIN,25));
        aprender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //-------------- Creacion del panel de aprender y seleccion------------------------\\

                aprenderPanelTotal = new JPanel(new BorderLayout());

                aE = new JRadioButton("A -- E", Abecedario.abecedario.get('a'));
                fK = new JRadioButton("F -- K", Abecedario.abecedario.get('f'));
                lP = new JRadioButton("L -- P", Abecedario.abecedario.get('l'));
                qU = new JRadioButton("Q -- U", Abecedario.abecedario.get('u'));
                vZ = new JRadioButton("V -- Z", Abecedario.abecedario.get('v'));

                grupo = new ButtonGroup();
                grupo.add(aE);
                grupo.add(fK);
                grupo.add(lP);
                grupo.add(qU);
                grupo.add(vZ);

                aprenderPanelSuperior = new JPanel(new FlowLayout());
                aprenderPanelSuperior.add(aE);
                aprenderPanelSuperior.add(fK);
                aprenderPanelSuperior.add(lP);
                aprenderPanelSuperior.add(qU);
                aprenderPanelSuperior.add(vZ);

                aprenderPanelTotal.add(aprenderPanelSuperior, BorderLayout.NORTH);

                aprenderPanelInferior = new JPanel(null);
                aprenderPanelInferior.setSize(1200,400);

                JButton jugar = new JButton("Jugar");
                jugar.setBounds(550,150,100,100);
                jugar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (aE.isSelected()){
                            juego = new Juego(Abecedario.abecedario.get('a'), Abecedario.abecedario.get('b'),
                                    Abecedario.abecedario.get('c'), Abecedario.abecedario.get('d'),
                                    Abecedario.abecedario.get('e'));
                            aprenderPanelTotal.setVisible(false);
                            add(juego);
                            juego.setVisible(true);
                        } else if (fK.isSelected()) {
                            juego = new Juego(Abecedario.abecedario.get('f'), Abecedario.abecedario.get('g'),
                                    Abecedario.abecedario.get('h'), Abecedario.abecedario.get('i'),
                                    Abecedario.abecedario.get('j'), Abecedario.abecedario.get('k'));
                            aprenderPanelTotal.setVisible(false);
                            add(juego);
                            juego.setVisible(true);
                        }else if (lP.isSelected()) {
                            juego = new Juego(Abecedario.abecedario.get('l'), Abecedario.abecedario.get('m'),
                                    Abecedario.abecedario.get('n'), Abecedario.abecedario.get('ñ'),
                                    Abecedario.abecedario.get('o'), Abecedario.abecedario.get('p'));
                            aprenderPanelTotal.setVisible(false);
                            add(juego);
                            juego.setVisible(true);
                        }else if (qU.isSelected()) {
                            juego = new Juego(Abecedario.abecedario.get('q'), Abecedario.abecedario.get('r'),
                                    Abecedario.abecedario.get('s'), Abecedario.abecedario.get('t'),
                                    Abecedario.abecedario.get('u'));
                            aprenderPanelTotal.setVisible(false);
                            add(juego);
                            juego.setVisible(true);
                        }else if (vZ.isSelected()) {
                            juego = new Juego(Abecedario.abecedario.get('v'), Abecedario.abecedario.get('w'),
                                    Abecedario.abecedario.get('x'), Abecedario.abecedario.get('y'),
                                    Abecedario.abecedario.get('z'));
                            aprenderPanelTotal.setVisible(false);
                            add(juego);
                            juego.setVisible(true);
                        }
                    }
                });

                aprenderPanelInferior.add(jugar);

                aprenderPanelTotal.add(aprenderPanelInferior, BorderLayout.CENTER);

                add(aprenderPanelTotal);
                aprenderPanelTotal.setVisible(true);
                inicio.setVisible(false);

            }
        });

        desafio = new JButton("Desafio");

        regresar = new JButton("<--");

        titulo = new JLabel("SignLearn");
        titulo.setBounds(500,50,180,50);
        titulo.setFont(new Font("MV Boli",Font.PLAIN,35));




        inicio.setSize(1200, 600);
        inicio.add(aprender);
        inicio.add(titulo);



        inferior.add(regresar);


        add(inicio, BorderLayout.CENTER);
        add(inferior, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Inicio();
    }
}
