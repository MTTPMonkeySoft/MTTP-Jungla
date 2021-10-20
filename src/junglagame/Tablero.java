package junglagame;

public class Tablero {
    private int[] tablero = new int[100];

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

        tablero[6] = 3;
        tablero[12] = 3;
        tablero[54] = 3;
        tablero[76] = 3;    
        // 4 preguntas
        tablero[14] = 4; 
        tablero[68] = 4; 
        tablero[54] = 4; 
        tablero[77] = 4;  

    }
    //constructor solo para tests
    public Tablero(int paraTestear){
        tablero[1] = paraTestear;
        tablero[2] = paraTestear;
        tablero[3] = paraTestear;
        tablero[4] = paraTestear;
        tablero[5] = paraTestear;
        tablero[6] = paraTestear;
        tablero[7] = paraTestear;
        tablero[8] = paraTestear;
        tablero[9] = paraTestear;
        tablero[10] = paraTestear;
        tablero[11] = paraTestear;
        tablero[12] = paraTestear;
        tablero[13] = paraTestear;
        tablero[14] = paraTestear;
        tablero[15] = paraTestear;
    }
    
    public int getCelda(int i){
        return tablero[i];
    }
    public int getsize(){
        return tablero.length;
    }
    

}