//import java.util.Random;

public class Tablero {
    private int[] tablero = new int[100];
  //  private Random random;


    /*
    public Tablero(int z){
        //tablero = new int[100];
        random = new Random();
        generarTablero();
    } 
    */

    public Tablero(){
        // 1 monos       ||   salidas 
        tablero[19] = 1; //     66
        tablero[32] = 1; //     52    
        tablero[73] = 1; //     91
        tablero[67] = 1; //     98
        // 2 lianas
        tablero[25] = 2; //     6
        tablero[46] = 2; //     12
        tablero[74] = 2; //     52
        tablero[88] = 2; //     76
        // 3 comodines
        tablero[18] = 3;     
        tablero[42] = 3; 
        tablero[59] = 3; 
        tablero[84] = 3; 
        // 4 preguntas
        tablero[14] = 4; 
        tablero[68] = 4; 
        tablero[54] = 4; 
        tablero[77] = 4;  

    }
    /*

    private void generarTablero(){
        //1 Monos
        //2 lianas
        //3 Comodines
        //4 Preguntas
        int tipoCelda = 1;
        int celda;
        while(tipoCelda < 5){
            for(int i = 0; i < 4; i++){
                celda = random.nextInt(99);
                if(tablero[celda] == 0){
                    tablero[celda] = tipoCelda;
                }else{
                    i--;
                }
            }
            tipoCelda++;
        }
    }
*/
    public int getCelda(int i){
        return tablero[i];
    }

    

}