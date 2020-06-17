package financas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "tb_produto")
@Entity
@NamedQueries({
	@NamedQuery(name = "Produto.listarTodos", 
			    query = "select p from Produto p order by p.nome"),
	@NamedQuery(name = "Produto.consultarPorId",
				query = "select c from Categoria c where c.id=?1")
})
public class Produto extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_nome", length = 60)
    public String nome;
	@ManyToOne
    public Categoria categoria;
    @Column(name = "nm_unidade", length = 60)
    public String unidade;
    @Column(name = "nm_preco")
    public float preco;
    @Column(name = "nm_precoMercado")
    public float precoMercado;
    @Column(name = "nm_precoLojinha")
    public float precoLojinha;
    
    public Produto(){
        
    }
    
    public Produto(long id){
        
    }

    public Produto(String nome, Categoria categoria, String unidade, float preco, float precoMercado, float precoLojinha) {
    	this.nome = nome;
        this.categoria = categoria;
        this.unidade = unidade;
        this.preco = preco;
        this.precoMercado = precoMercado;
        this.precoLojinha = precoLojinha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPrecoMercado() {
        return precoMercado;
    }

    public void setPrecoMercado(float precoMercado) {
        this.precoMercado = precoMercado;
    }

    public float getPrecoLojinha() {
        return precoLojinha;
    }

    public void setPrecoLojinha(float precoLojinha) {
        this.precoLojinha = precoLojinha;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Float.floatToIntBits(preco);
		result = prime * result + Float.floatToIntBits(precoLojinha);
		result = prime * result + Float.floatToIntBits(precoMercado);
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
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
		Produto other = (Produto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		if (Float.floatToIntBits(precoLojinha) != Float.floatToIntBits(other.precoLojinha))
			return false;
		if (Float.floatToIntBits(precoMercado) != Float.floatToIntBits(other.precoMercado))
			return false;
		if (unidade == null) {
			if (other.unidade != null)
				return false;
		} else if (!unidade.equals(other.unidade))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", categoria=" + categoria + ", unidade=" + unidade + ", preco=" + preco + ", precoMercado=" + precoMercado + ", precoLojinha=" + precoLojinha + '}';
    }
}
