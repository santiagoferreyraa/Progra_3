package models;

public class Cliente {
    private int id;
    private String nombre;
    private int scoring;

    public Cliente(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }
    
    public int getIdCliente() {
    	return id;
    }
    
    public String getNombreCliente() {
    	return nombre;
    }
    
    public int getScoringCliente() {
    	return scoring;
    }
    
    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + "}";
    }

}
