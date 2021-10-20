package junglagame;

import java.util.Random;

public class Partida{
    private Tablero tablero;
    private Jugador[] jugadores;
    private Random random;
    private boolean hayGanador;
    private int dado;
    private int turno;
    private int dificultad;
    private Pregunta pregunta;
    private InfoPrint info;
    private IA ia;
    
    public Partida(int dificultad){
        tablero = new Tablero();
        jugadores = new Jugador[2];
        jugadores[0] = new Jugador();
        jugadores[1] = new Jugador();
        random = new Random();
        turno = 0;
        hayGanador = false;
        pregunta = new Pregunta();
        info = new InfoPrint();
        ia = new IA();
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
        info.jugador(turno, jugadores[turno].getPosicion(), jugadores[turno].getComodin());                                        
        jugadores[turno].mover(dado);
        if(jugadores[turno].getPosicion() < 99){
            System.out.println("\nSacaste un " + dado + ", avanzas a la celda Nº " + (jugadores[turno].getPosicion() + 1) + ".");
            evaluarCelda();
        }else{
            System.out.println("\nSacaste un " + dado + ", avanzas a la celda Nº 100... ¡Felicidades Ganaste!");
        }            
    }

    private void evaluarCelda(){
        int tipoCelda = tablero.getCelda(jugadores[turno].getPosicion());
        if(tipoCelda == 1){ // Monos
            System.out.println("Llegaste a una celda con monos...");
            if(turno == 0){
                lanzarPregunta(tipoCelda);
            }else{
                int mover = ia.monos(dificultad, jugadores[turno].getComodin());
                jugadores[turno].mover(mover);
                if(jugadores[turno].getComodin() > 0){
                    jugadores[turno].usarComodin();
                }
            }     
        }else if(tipoCelda == 2){ // Liana
            System.out.println("Mala suerte... llegaste a una liana retrocedes 20 celdas");
            jugadores[turno].mover(-20);//Valor por definir en base al tablero final.
        }else if(tipoCelda == 3){ // Comodin
            System.out.println("¡Felicidades, recibiste un comodin!");
            jugadores[turno].darComodin();
        }else if(tipoCelda == 4){ // Evento
            System.out.println("En esta casilla hay un pregunta sorpresa...");
            if(turno == 0){
                lanzarPregunta(tipoCelda);
            }else{
                int mover = ia.preguntaSorpresa(dificultad, jugadores[turno].getComodin());
                jugadores[turno].mover(mover);
                if(jugadores[turno].getComodin() > 0 && (dificultad == 1 || dificultad == 2)){
                    jugadores[turno].usarComodin();
                }
            }        
        }
        limpiarConsola(2500);      
    }

    private void lanzarPregunta(int tipoCelda){
        int movimiento;
        boolean respuesta;
        if(tipoCelda == 1){
            movimiento = 20; //Valor por definir en base al tablero final.
        }else{
            movimiento = random.nextInt(3) + 1;    
        }
        if(jugadores[turno].getComodin() > 0){
            respuesta = pregunta.generadorPregunta(dificultad, info.comodin()); 
        }else{
            respuesta = pregunta.generadorPregunta(dificultad, false);
        }
        if(respuesta){
            jugadores[turno].mover(movimiento);
            System.out.println("Respuesta correcta, avanzas " + movimiento + " celdas.");
        }else{
            if(tipoCelda == 1){
                System.out.println("Respuesta incorrecta, permaneces en tu lugar.");
            }else{
                jugadores[turno].mover(-movimiento);
                System.out.println("Respuesta incorrecta, retrocedes " + movimiento + " celdas.");
            }          
        }    
    }

    private void limpiarConsola(int retraso){
        try{
            Thread.sleep(retraso);
        }catch(InterruptedException e){}
        System.out.print("\033[H\033[2J");
        System.out.flush();    
    }
}
