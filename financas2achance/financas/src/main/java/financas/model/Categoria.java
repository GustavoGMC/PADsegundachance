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
    public String nome;
    
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
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Categoria{" + "nome=" + nome + '}';
    }
}
