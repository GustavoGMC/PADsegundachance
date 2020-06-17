package financas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "tb_usuario")
@Entity
@NamedQueries({
	@NamedQuery(name = "Usuario.listarTodos", 
			    query = "select u from Usuario u order by u.nome")
})
public class Usuario extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Column(name = "nm_nome", length = 60)
	private String nome;
	@Column(name = "nm_email", length = 60, unique = true)
	private String email;
	@Column(name = "nm_senha", length = 255)
	private String senha;
	@Column(name = "nm_ativo", length = 1)
    public boolean ativo;
    
    public Usuario(){
        
    }
    
    public Usuario(long id){
        
    }

    public Usuario(String nome, String email, String senha, boolean ativo) {
    	this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (ativo != other.ativo)
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
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", email=" + email + ", senha=" + senha + ", ativo=" + ativo + '}';
    }
}
