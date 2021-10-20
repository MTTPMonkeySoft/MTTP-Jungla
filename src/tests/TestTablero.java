package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import junglagame.Tablero;
public class TestTablero {
    Tablero t = new Tablero(3);
    @Test
    public void settingMonosTest(){
        Tablero tmonos = new Tablero(1);
        assertEquals(1, tmonos.getCelda(4));
    }

    @Test
    public void settingLianasTest(){
        Tablero tLianas = new Tablero(2);
        assertEquals(2, tLianas.getCelda(10));
    }

    @Test
    public void settingPregTest(){
        Tablero tPreg = new Tablero(3);
        assertEquals(3, tPreg.getCelda(5));
    }

    @Test
    public void lengthTest() {
        assertEquals(100, t.getsize());

        // Descomentar para mostrar logs
        /*
        System.out.println("celdas:");
        for (int i = 0; i < t.getsize()/2; i++) {
            System.out.println(t.getCelda(i));

        }
        */
    }

    @Test
    public void constructorPrincipalTest() {
        Tablero tmain = new Tablero();
        assertEquals(0, tmain.getCelda(82));//blanco
        assertEquals(1, tmain.getCelda(32));//mono
        assertEquals(2, tmain.getCelda(46));//liana
        assertEquals(3, tmain.getCelda(59));//comodin
        assertEquals(4, tmain.getCelda(77));//pregunta
        
        System.out.println("tablero:");
        for (int i = 99; i >= 0 ; i--){
            if(i % 10 == 0){
                System.out.println( "|" + i + "|");
                if(tmain.getCelda(i) != 0){
                    System.out.print("-" + tmain.getCelda(i));
                }
            } else {
                System.out.print("|" + i);
                if(tmain.getCelda(i) != 0){
                    System.out.print("-(" + tmain.getCelda(i) +")");
                }
            }
            
        }
    }
}
