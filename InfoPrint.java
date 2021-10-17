import java.util.Scanner;

public class InfoPrint {
    Scanner scanner = new Scanner(System.in);

    public void jugador(int turno, int posicion, int comodin){
        if(turno == 0){
            System.out.println("---------- Turno Jugador ---------- \n");
        }else{
            System.out.println("---------- Turno IA ---------- \n");
        }  
        System.out.println("Estas en la celda Nº " + (posicion + 1) + ".");
        System.out.println("Tienes: " + comodin + " comodines.\n");
        System.out.println("----------------------------------- \n");
        if(turno == 0){
            System.out.print("Presiona 'Enter' para lanzar el dado... ");
            scanner.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }else{
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){}
            System.out.print("\033[H\033[2J");
            System.out.flush();    
        }     
    }
    
    public boolean comodin(){
        boolean respuesta = false;
        System.out.println("¿Deseas usar un comodin para la siguiente pregunta?\n1. Si\n2. No");
        System.out.print("Respuesta: ");
        int resp = scanner.nextInt();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if(resp == 1){    
            respuesta = true;   
        }
        return respuesta;    
    }
}
