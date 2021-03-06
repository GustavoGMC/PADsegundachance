package financas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "tb_categoria")
@Entity
@NamedQueries({
	@NamedQuery(name = "Categoria.listarTodos", 
			    query = "select c from Categoria c"),
	@NamedQuery(name = "Categoria.consultarPorId",
				query = "select c from Categoria c where c.id=?1")
})
public class Categoria extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_nome", length = 60)
    private String nome;
    
    public Categoria(){
        
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
