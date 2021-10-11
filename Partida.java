import java.util.Scanner;
import java.util.Random;

public class Partida{
    private Scanner scanner;
    private Tablero tablero;
    private Jugador[] jugadores;
    private Random random;
    private boolean hayGanador;
    private int dado;
    private int turno;
    private int dificultad;
    private Pregunta pregunta;
    
    public Partida(int dificultad){
        scanner = new Scanner(System.in);
        tablero = new Tablero();
        jugadores = new Jugador[2];
        jugadores[0] = new Jugador();
        jugadores[1] = new Jugador();
        random = new Random();
        turno = 0;
        hayGanador = false;
        pregunta = new Pregunta();
        this.dificultad = dificultad;      
    }

    public void jugar(){
        while(!hayGanador){          
            ejecutarTurno();                     
            if(jugadores[turno].getGanador()){
                hayGanador = true;
            }else if( turno == 0){
                turno = 1;
            }else{
                turno = 0;
            }                                 
        }    
    }

    private void ejecutarTurno(){
        dado = 1 + random.nextInt(6);
        if(turno == 0){  
            menuJugador(turno);
            lanzarDado();
            jugadores[turno].mover(dado);
            if(jugadores[turno].getPosicion() < 99){
                evaluarCelda(jugadores[turno].getPosicion(), turno);
            }                                        
        }else{
            jugadores[turno].mover(dado);
        }           
    }

    private void menuJugador(int turno){
        System.out.println("---------- Turno Jugador ---------- \n");
        System.out.println("Estas en la celda Nº " + (jugadores[turno].getPosicion()+1) + ".");
        System.out.println("Tienes: " + jugadores[turno].getComodin() + " comodines.");
        System.out.println("----------------------------------- \n");
        System.out.println("Presiona 'Enter' para lanzar el dado...");
        scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();  
    }

    private void lanzarDado(){
        System.out.println("\nSacaste un " + dado + ", avanzas a la celda Nº " + (jugadores[turno].getPosicion()+dado) + ".");
        System.out.println("Presiona 'Enter' para continuar...");
        scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void evaluarCelda(int i, int turno){
        int tipoCelda = tablero.getCelda(i);
        boolean respuesta;
        if(tipoCelda == 1){ // Monos
            System.out.println("En esta casilla hay unos monos...");
            //
            //
            respuesta = pregunta.generadorPregunta();  //generadorPregunta(dificultad +1); 
            if(respuesta){
                jugadores[turno].mover(20);
            }
        }else if(tipoCelda == 2){ // Liana
            System.out.println("En esta casilla hay unas lianas...");
            respuesta = pregunta.generadorPregunta(); 
            if(!respuesta){
                jugadores[turno].mover(-20);
            }   
        }else if(tipoCelda == 3){ // Comodin
            System.out.println("¡Encontraste un comodin!");
            jugadores[turno].darComodin();  
        }else if(tipoCelda == 4){ // Evento
            System.out.println("En esta casilla hay un pregunta sorpresa...");
            respuesta = pregunta.generadorPregunta();
            if(respuesta){
                jugadores[turno].mover(3); 
            }else{
                jugadores[turno].mover(-3);   
            }        
        }    
    }
}