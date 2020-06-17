package financas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "tb_produtor")
@Entity
@NamedQueries({
	@NamedQuery(name = "Produtor.listarTodos", 
			    query = "select p from Produtor p order by p.nome")
})
public class Produtor extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_nome", length = 60)
    public String nome;
	@Column(name = "nm_cpf", length = 60)
    public String cpf;
	@Column(name = "nm_email", length = 60)
    public String email;
    @Column(name = "nm_telefone", length = 60)
    public String telefone;
    @OneToMany
    public List <Produto> produtos;
    
    public Produtor(){
        
    }
    
    public Produtor(long id){
        
    }

    public Produtor(String nome, String cpf, String email, String telefone, List<Produto> produtos) {
    	this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.produtos = produtos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Produtor other = (Produtor) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Produtor{" + "nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone + ", produtos=" + produtos + '}';
    }
}
