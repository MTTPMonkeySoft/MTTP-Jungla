import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pregunta{
    Random random = new Random();

    public boolean generadorPregunta(int dificultad, boolean comodin){
        boolean respuesta = false;
        int tiempo;
        if(dificultad == 1){
            tiempo = 60000;
        }else if(dificultad == 2){
            tiempo = 45000;
        }else{
            tiempo = 30000;
        }
        System.out.println("Tienes " + (tiempo/1000) + " segundos para responder la siguiente pregunta...");
        String[] pregunta = leerPregunta(dificultad);
        int respCorrecta = mostrarPregunta(pregunta, comodin);
        TimedScanner scanner = new TimedScanner();
        System.out.print("Respuesta: ");
        int respUsuario = scanner.nextInt(tiempo);
        if(respCorrecta == respUsuario){
            respuesta = true;
        }  
        return respuesta;
    } 
    
    private String[] leerPregunta(int dificultad){
        String linea = "";
        String delimitante = ",";
        String[] aux = null;
        try{
            String filePath;
            String pregunta;        
            if(dificultad == 1){
                filePath = "E:\\Descargas\\Facil.txt";
                pregunta = "" + (random.nextInt(18) + 1);
            }else if(dificultad == 2){
                filePath = "E:\\Descargas\\Moderado.txt";
                pregunta = "" + (random.nextInt(40) + 1);
            }else{
                filePath = "E:\\Descargas\\Dificil.txt";
                pregunta = "" + (random.nextInt(33) + 1);
            }
            FileReader fileReader= new FileReader(filePath);
            BufferedReader reader= new BufferedReader(fileReader);
            while((linea = reader.readLine()) != null){
                String [] campo = linea.split((delimitante));           
                if(campo[0].equals(pregunta)){
                    aux = campo;
                }               
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return aux;
    }

    private int mostrarPregunta(String[] pregunta, boolean comodin){
        int resp;
        System.out.println(pregunta[1]);
        if(comodin){
            resp = random.nextInt(2) + 1;
            if(resp == 1){
                System.out.println("1. " + pregunta[2] + "\n2. " + pregunta[random.nextInt(2) + 3]);
            }else{
                System.out.println("1. " + pregunta[random.nextInt(2) + 3] + "\n2. " + pregunta[2]);
            }
        }else{
            resp = random.nextInt(3) + 1;
            if(resp == 1){
                System.out.println("1. " + pregunta[2] + "\n2. " + pregunta[3] + "\n3. " + pregunta[4]);    
            }else if(resp == 2){
                System.out.println("1. " + pregunta[4] + "\n2. " + pregunta[2] + "\n3. " + pregunta[3]);
            }else{
                System.out.println("1. " + pregunta[3] + "\n2. " + pregunta[4] + "\n3. " + pregunta[2]);
            }
        }
        return resp;
    }
}
