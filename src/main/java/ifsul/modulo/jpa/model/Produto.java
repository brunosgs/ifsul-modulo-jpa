package ifsul.modulo.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nome", length = 50, nullable = false)
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não pode ter mais de {max} caracteres")
    private String nome;

    @Column(name = "descricao", columnDefinition = "text")
    private String decricao;

    @NotNull(message = "O preço deve ser informado")
    @Column(name = "preco", nullable = false, precision = 12, scale = 2)
    private BigDecimal preco;

    @Min(message = "O estoque não pode ser negativo", value = 0)
    @NotNull(message = "A quantidade em estoque deve ser informada")
    @Column(name = "quantidade_estoque", nullable = false, precision = 12, scale = 2)
    private BigDecimal quantidadeEstoque;

    @NotNull(message = "A categoria deve ser informada")
    @ManyToOne
    @JoinColumn(
	    name = "categoria",
	    referencedColumnName = "id",
	    nullable = false,
	    foreignKey = @ForeignKey(name = "fk_categoria"))
    private Categoria categoria;

    @NotNull(message = "A marca deve ser informada")
    @ManyToOne
    @JoinColumn(
	    name = "marca",
	    referencedColumnName = "id",
	    nullable = false,
	    foreignKey = @ForeignKey(name = "fk_marca"))
    private Marca marca;

    @ManyToMany
    @JoinTable(
	    name = "tb_desejos",
	    joinColumns = @JoinColumn(
		    name = "produto_id",
		    referencedColumnName = "id",
		    nullable = false,
		    foreignKey = @ForeignKey(name = "fk_produto_pessoa_fisica_id")),
	    inverseJoinColumns = @JoinColumn(
		    name = "pessoa_fisica_id",
		    referencedColumnName = "pessoa_fisica_id",
		    nullable = false,
		    foreignKey = @ForeignKey(name = "fk_pessoa_fisica_produto_id")),
	    uniqueConstraints = { @UniqueConstraint(
		    name = "uk_desejos_pessoa_fisica_produto",
		    columnNames = { "pessoa_fisica_id", "produto_id" }) })
    private List<PessoaFisica> desejam = new ArrayList<>();

    public Produto() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getDecricao() {
	return decricao;
    }

    public void setDecricao(String decricao) {
	this.decricao = decricao;
    }

    public BigDecimal getPreco() {
	return preco;
    }

    public void setPreco(BigDecimal preco) {
	this.preco = preco;
    }

    public BigDecimal getQuantidadeEstoque() {
	return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(BigDecimal quantidadeEstoque) {
	this.quantidadeEstoque = quantidadeEstoque;
    }

    public Categoria getCategoria() {
	return categoria;
    }

    public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
    }

    public Marca getMarca() {
	return marca;
    }

    public void setMarca(Marca marca) {
	this.marca = marca;
    }

    public List<PessoaFisica> getDesejam() {
	return desejam;
    }

    public void setDesejam(List<PessoaFisica> desejam) {
	this.desejam = desejam;
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
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
	return Objects.equals(id, other.id);
    }

}
