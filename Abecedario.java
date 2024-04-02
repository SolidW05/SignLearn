import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Abecedario {

    public static HashMap<Character, ImageIcon> abecedario = new HashMap<>();

    private final static Character[] abc = {'a','b','c','d','e',
            'f','g','h','i', 'j', 'k',
            'l','m','n','ñ','o', 'p',
            'q', 'r', 's', 't', 'u',
            'v', 'x', 'y', 'z'};


    // se le agregan los valores al hashmap abecedario
    static{

        for (int i = 0; i < abc.length; i++ ){

            abecedario.put(abc[i], new ImageIcon (new ImageIcon
                    (Abecedario.class.getResource("Imagenes/"+abc[i]+".jpg"))
                    .getImage().
                    getScaledInstance(200,100, Image.SCALE_SMOOTH)));

        }

    }

}
