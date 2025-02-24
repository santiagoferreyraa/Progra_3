package src;

public class Empresa {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empresa(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmpresaDto [id=" + id + "]";
    }
    
    
}