import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {

    JLabel titulo;
<<<<<<< HEAD
    JPanel inicio, aprenderPanelInferior, aprenderPanelSuperior, aprenderPanelTotal, inferior, desafioPanel;
    JButton aprender, desafio, regresar;
    Juego juego;
    Desafio challenge;
=======
    JPanel inicio, aprenderPanelInferior, aprenderPanelSuperior, aprenderPanelTotal, inferior;
    JButton aprender, desafio, regresar;
    Juego juego;
>>>>>>> f7e31ac8de5798f9074d449c2e287cf498986c36
    JRadioButton aE, fK, lP, qU, vZ;
    ButtonGroup grupo;

    Inicio(){
        setSize(1200,800);
        setResizable(false);

        inicio = new JPanel(null);
        inferior = new JPanel(new FlowLayout());

<<<<<<< HEAD




=======
>>>>>>> f7e31ac8de5798f9074d449c2e287cf498986c36
        aprender = new JButton("Aprender");
        aprender.setBounds(500,200, 180, 50);
        aprender.setFont(new Font("MV Boli",Font.PLAIN,25));
        aprender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //-------------- Creacion del panel de aprender y seleccion------------------------\\
<<<<<<< HEAD
=======

>>>>>>> f7e31ac8de5798f9074d449c2e287cf498986c36
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
<<<<<<< HEAD
        desafio.setBounds(500,300, 180, 50);
        desafio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desafioPanel= new JPanel(null);
                desafioPanel.setSize(1200, 600);



                JButton facil = new JButton("Facil");
                facil.setBounds(500,250,180,50);
                facil.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       challenge = new Desafio(2);
                       desafioPanel.setVisible(false);
                       add(challenge);
                    }
                });
                JButton normal = new JButton("Normal");
                normal.setBounds(500,350,180,50);
                normal.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        challenge = new Desafio(3);
                        desafioPanel.setVisible(false);
                        add(challenge);
                    }
                });

                JButton dificil = new JButton("Dificil");
                dificil.setBounds(500,450,180,50);
                dificil.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        challenge = new Desafio(5);
                        desafioPanel.setVisible(false);
                        add(challenge);
                    }
                });

                desafioPanel.add(facil);
                desafioPanel.add(normal);
                desafioPanel.add(dificil);

                add(desafioPanel);
                desafioPanel.setVisible(true);
                inicio.setVisible(false);
            }
        });

        regresar = new JButton("<--");
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Idea por carlos");

                if (juego != null && juego.isVisible()) {
                    juego.setVisible(false);
                    aprenderPanelTotal.setVisible(true);
                } else if (challenge != null && challenge.isVisible()) {
                    challenge.setVisible(false);
                    desafioPanel.setVisible(true);
                } else if (aprenderPanelTotal != null && aprenderPanelTotal.isVisible()) {
                    aprenderPanelTotal.setVisible(false);
                    inicio.setVisible(true);
                } else if (desafioPanel != null && desafioPanel.isVisible()) {
                    desafioPanel.setVisible(false);
                    inicio.setVisible(true);
                }
            }

        });
=======

        regresar = new JButton("<--");
>>>>>>> f7e31ac8de5798f9074d449c2e287cf498986c36

        titulo = new JLabel("SignLearn");
        titulo.setBounds(500,50,180,50);
        titulo.setFont(new Font("MV Boli",Font.PLAIN,35));




        inicio.setSize(1200, 600);
        inicio.add(aprender);
        inicio.add(titulo);
<<<<<<< HEAD
        inicio.add(desafio);
=======


>>>>>>> f7e31ac8de5798f9074d449c2e287cf498986c36

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
