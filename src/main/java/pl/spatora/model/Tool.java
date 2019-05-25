package pl.spatora.model;

import java.io.Serializable;

public class Tool implements Serializable {

    private Long id;
    private String name;
    private ToolType type;
    private boolean available;
    private Long idUser;


    public Tool() {
    }

    public Tool(Long id, String name, ToolType type, boolean available, Long idUser) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.available = available;
        this.idUser = idUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToolType getType() {
        return type;
    }

    public void setType(ToolType type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
