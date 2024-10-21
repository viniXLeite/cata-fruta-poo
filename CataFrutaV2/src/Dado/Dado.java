package Dado;
import java.util.Random;

public class Dado {
    public static int rolar() {
        Random random = new Random();

        int resultadoDado = random.nextInt(6)+1;
        return resultadoDado;
    }
}