import java.util.Scanner;
 
public class TimedScanner implements Runnable{
	private Scanner scanner;
	private boolean lectura;
	private Thread hilo;
    private int valor;

	public TimedScanner(){
		scanner = new Scanner(System.in);
		valor = 0;
		lectura = false;
		hilo = new Thread(this);
		hilo.setDaemon(true);
		hilo.start();
	}
 
	public int nextInt(long tiempo){
		lectura = true;
		long tiempoInicial = System.currentTimeMillis();
		while (System.currentTimeMillis() - tiempoInicial < tiempo && valor == 0){
			try{
				Thread.sleep(50);
			}catch(InterruptedException e){}
		}
		lectura = false;
		return valor;
	}
 
	@Override
	public void run(){
		while (scanner.hasNextInt()){
			if(lectura){
				valor = scanner.nextInt();
			}			
		}
	}
}
