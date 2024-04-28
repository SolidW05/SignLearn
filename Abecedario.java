import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import javax.sound.sampled.*;
import java.io.*;

public class Abecedario {

    public static HashMap<Character, ImageIcon> abecedario = new HashMap<>();
    public static HashMap<ImageIcon, Character> abecedarioInvertido = new HashMap<>();

    private final static Character[] abc = {'a','b','c','d','e',
            'f','g','h','i', 'j', 'k',
            'l','m','n','ñ','o', 'p',
            'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'};


    // se le agregan los valores al hashmap abecedario
    static{

        for (int i = 0; i < abc.length; i++ ){

            abecedario.put(abc[i], new ImageIcon (new ImageIcon
                    (Abecedario.class.getResource("Imagenes/"+abc[i]+".jpg"))
                    .getImage().
                    getScaledInstance(150,130, Image.SCALE_SMOOTH)));

        }

        for (Character valor : abecedario.keySet()){

            ImageIcon llave = abecedario.get(valor);
            abecedarioInvertido.put(llave, valor);
        }

    }

    public static Character getIndexAbc(int index){
        return abc[index];
    }

    public static void sonidoletra(ImageIcon sign){

        Character letra = Abecedario.abecedarioInvertido.get(sign);
        try {
            // Open an audio input stream.
            BufferedInputStream bis=new
                    //OJO los audios los buscara en la subcarpeta sounds, puedes cambiar el nombre de la carpeta
                    BufferedInputStream(Abecedario.class.getResourceAsStream("/Sonidos/"+letra+".wav"));
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(bis);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Audio NO soportado");
        } catch (IOException e) {
            System.out.println("Error de E/S");
        } catch (LineUnavailableException e) {
            System.out.println("Linea No disponible");
        }
    }
    }


