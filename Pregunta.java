import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pregunta{
    boolean respuesta = false; //guarda la respuesta a la pregunta
    int sumX,sumY,resultado,opcion,bandera,mezclador,randAux,lower,upper;
    //sumX y sumY son variables del problema planteado
    //resultado es el resultado de la suma sumX+sumY
    //opcion es el numero de la opcion escogida por el usuario
    //bandera es una variable para controlar el formato de la pregunta.
    //mezclador es una variable auxiliar para dar formato a las opciones de respuesta a la pregunta.
    //randAux es una variable auxiliar aleatoria.
    //lower y upper son los topes respectivamente para la generacion de numeros aleatorios upper excluido.
    Random r = new Random();
    Scanner sc = new Scanner(System.in);

    public boolean generadorPregunta(){
        upper = 5;
        lower = 1;
        sumX= r.nextInt(11);
        sumY= r.nextInt(11);
        bandera = r.nextInt(2)+1;
        resultado = sumX + sumY;
        mezclador = r.nextInt(upper-lower) + lower;
        ArrayList<Respuesta> arrayRespuesta = new ArrayList<Respuesta>();

        if(bandera == 1){
            for(int i = 1; i <= 4; i++){
                if(i == mezclador){
                    arrayRespuesta.add(new Respuesta(i, sumX));
                }else{
                    randAux = r.nextInt(10);
                    arrayRespuesta.add(new Respuesta(i, randAux));
                }
            }
            System.out.println("Elije la opcion correcta");
            System.out.println("? + " + sumY + " = " + resultado);
        } else if(bandera == 2){
            for(int i = 1; i <= 4; i++){
                if(i == mezclador){
                    arrayRespuesta.add(new Respuesta(i, sumY));
                }else{
                    randAux = r.nextInt(10);
                    arrayRespuesta.add(new Respuesta(i, randAux));
                }
            }
            System.out.println("Elije la opcion correcta");
            System.out.println(sumX + " + ?" + " = " + resultado);
        }

        for(int i = 0; i < arrayRespuesta.size(); i++){
            System.out.println(arrayRespuesta.get(i).toString());
        }
        System.out.println("Ingrese una opcion");
        opcion = sc.nextInt();
        if(opcion == mezclador){
            respuesta = true;
            System.out.println("Respuesta correcta felicidades :D");
        }else{
            System.out.println("Respuesta incorrecta sigue intentando :(");
        }
        return respuesta;
    }
}