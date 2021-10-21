package junglagame;

import java.util.Random;

public class IA{
    Random random = new Random();

    public int monos(int dificultad, int comodin){
        int mover = 20;
        int prob = dificultad;
        if(comodin > 0){
            prob += 1;
            System.out.println("IA usa un comodin.");
        }
        mover = simularRespuesta(prob, mover, 0);
        return mover;
    }
    
    public int preguntaSorpresa(int dificultad, int comodin){
        int mover = random.nextInt(3) + 1;
        int prob = dificultad;
        if(comodin > 0 && dificultad < 3){
            prob += 1;
            System.out.println("IA usa un comodin.");
        }
        mover = simularRespuesta(prob, mover, 1);
        return mover;
    }

    private int simularRespuesta(int prob, int mover, int control){
        int valor = mover;
        if(random.nextInt(4) < prob){
            System.out.println("Respuesta correcta, avanzas " + valor + " celdas.");
        }else{
            if(control == 0){
                valor = 0;
                System.out.println("Respuesta incorrecta, permaneces en tu lugar.");
            }else{
                valor = -valor;
                System.out.println("Respuesta incorrecta, retrocedes " + valor + " celdas.");    
            }
        }
        return valor;  
    }
}
