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
    private String nome;
	@ManyToOne
    private Categoria categoria;
    @Column(name = "nm_unidade", length = 60)
    private String unidade;
    @Column(name = "nm_preco")
    private float preco;
    @Column(name = "nm_precoMercado")
    private float precoMercado;
    @Column(name = "nm_precoLojinha")
    private float precoLojinha;
    
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
    
}
