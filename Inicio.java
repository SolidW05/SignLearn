import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {

    JLabel titulo;
    JPanel inicio, aprenderPanelInferior, aprenderPanelSuperior, aprenderPanelTotal, inferior, desafioPanel;
    JButton aprender, desafio, regresar;
    Juego juego;
    Desafio challenge;
    JRadioButton aE, fK, lP, qU, vZ;
    ButtonGroup grupo;

    Inicio(){
        setSize(1200,800);
        setResizable(false);

        inicio = new JPanel(null);
        inicio.setBackground(Color.lightGray);

        inferior = new JPanel(new FlowLayout());
        inferior.setBackground(Color.darkGray);

        aprender = new JButton("Aprender");
        aprender.setBounds(462,300, 280, 90);
        aprender.setFont(new Font("Ink Free", Font.BOLD, 60));
        aprender.setBackground(Color.orange);
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
                aprenderPanelSuperior.setBackground(Color.lightGray);
                aprenderPanelSuperior.add(aE);
                aprenderPanelSuperior.add(fK);
                aprenderPanelSuperior.add(lP);
                aprenderPanelSuperior.add(qU);
                aprenderPanelSuperior.add(vZ);

                aprenderPanelTotal.add(aprenderPanelSuperior, BorderLayout.NORTH);

                aprenderPanelInferior = new JPanel(null);
                aprenderPanelInferior.setBackground(Color.lightGray);
                aprenderPanelInferior.setSize(1200,400);

                JButton jugar = new JButton("Jugar");
                jugar.setBounds(515,150,180,100);
                jugar.setBackground(Color.orange);
                jugar.setFont(new Font("Ink Free", Font.BOLD, 50));
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
        desafio.setFont(new Font("Ink Free", Font.BOLD, 60));
        desafio.setBounds(462,410, 280, 90);
        desafio.setBackground(Color.ORANGE);
        desafio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desafioPanel= new JPanel(null);
                desafioPanel.setBackground(Color.lightGray);
                desafioPanel.setSize(1200, 600);

                JButton facil = new JButton("Facil");
                facil.setBounds(460,220,250,100);
                facil.setFont(new Font("Ink Free", Font.BOLD, 60));
                facil.setBackground(Color.orange);
                facil.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       challenge = new Desafio(2);
                       desafioPanel.setVisible(false);
                       add(challenge);
                    }
                });

                JButton normal = new JButton("Normal");
                normal.setBounds(460,340,250,100);
                normal.setFont(new Font("Ink Free", Font.BOLD, 60));
                normal.setBackground(Color.orange);
                normal.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        challenge = new Desafio(3);
                        desafioPanel.setVisible(false);
                        add(challenge);
                    }
                });

                JButton dificil = new JButton("Dificil");
                dificil.setFont(new Font("Ink Free", Font.BOLD, 60));
                dificil.setBounds(460,460,250,100);
                dificil.setBackground(Color.orange);
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

        titulo = new JLabel("SignLearn");
        titulo.setBounds(395,120,500,120);
        titulo.setFont(new Font("Ink Free", Font.BOLD, 90));




        inicio.setSize(1200, 600);
        inicio.add(aprender);
        inicio.add(titulo);
        inicio.add(desafio);

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
