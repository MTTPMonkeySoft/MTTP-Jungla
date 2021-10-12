public class Respuesta {
    int respuesta,id;

    public Respuesta(int id, int respuesta){
        this.respuesta = respuesta;
        this.id = id;
    }

    public int getRespuesta(){
        return respuesta;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return "Opcion: " + id + " Respuesta: " + respuesta;
    }       
}