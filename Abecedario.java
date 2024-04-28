import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

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

}
