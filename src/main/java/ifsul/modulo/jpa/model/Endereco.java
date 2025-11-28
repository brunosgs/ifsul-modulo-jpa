package ifsul.modulo.jpa.model;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_endereco", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nickName", length = 20, nullable = false)
    @NotNull(message = "O apelido não pode ser nulo")
    @NotBlank(message = "O apelido não pode ser em branco")
    @Length(max = 20, message = "O apelido não pode ter mais de {max} caracteres")
    private String nickName;

    @Column(name = "endereco", length = 50, nullable = false)
    @NotNull(message = "O endereço não pode ser nulo")
    @NotBlank(message = "O endereço não pode ser em branco")
    @Length(max = 50, message = "O endereço não pode ter mais de {max} caracteres")
    private String endereco;

    @Column(name = "numero", length = 10, nullable = false)
    @NotNull(message = "O número não pode ser nulo")
    @NotBlank(message = "O número não pode ser em branco")
    @Length(max = 10, message = "O número não pode ter mais de {max} caracteres")
    private String numero;

    @Column(name = "complemento", length = 20)
    @NotNull(message = "O complemento não pode ser nulo")
    @NotBlank(message = "O complemento não pode ser em branco")
    @Length(max = 20, message = "O complemento não pode ter mais de {max} caracteres")
    private String complemento;

    @Column(name = "cep", length = 9, nullable = false)
    @NotNull(message = "O CEP não pode ser nulo")
    @NotBlank(message = "O CEP não pode ser em branco")
    @Length(max = 9, message = "O CEP não pode ter mais de {max} caracteres")
    private String cep;

    @Column(name = "bairro", length = 40, nullable = false)
    @NotNull(message = "O bairro não pode ser nulo")
    @NotBlank(message = "O bairro não pode ser em branco")
    @Length(max = 40, message = "O bairro não pode ter mais de {max} caracteres")
    private String bairro;

    @Column(name = "referencia", length = 30, nullable = false)
    @Length(max = 30, message = "A referência não pode ter mais de {max} caracteres")
    private String referencia;

    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(
	    name = "pessoa_id",
	    referencedColumnName = "id",
	    nullable = false,
	    foreignKey = @ForeignKey(name = "fk_pessoa"))
    private Pessoa pessoa;

    @NotNull(message = "O tipo de endereço deve ser informado")
    @ManyToOne
    @JoinColumn(
	    name = "tipo_endereco_id",
	    referencedColumnName = "id",
	    nullable = false,
	    foreignKey = @ForeignKey(name = "fk_endereco"))
    private TipoEndereco tipoEnderco;

    public Endereco() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNickName() {
	return nickName;
    }

    public void setNickName(String nickName) {
	this.nickName = nickName;
    }

    public String getEndereco() {
	return endereco;
    }

    public void setEndereco(String endereco) {
	this.endereco = endereco;
    }

    public String getNumero() {
	return numero;
    }

    public void setNumero(String numero) {
	this.numero = numero;
    }

    public String getComplemento() {
	return complemento;
    }

    public void setComplemento(String complemento) {
	this.complemento = complemento;
    }

    public String getCep() {
	return cep;
    }

    public void setCep(String cep) {
	this.cep = cep;
    }

    public String getBairro() {
	return bairro;
    }

    public void setBairro(String bairro) {
	this.bairro = bairro;
    }

    public String getReferencia() {
	return referencia;
    }

    public void setReferencia(String referencia) {
	this.referencia = referencia;
    }

    public Pessoa getPessoa() {
	return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
	this.pessoa = pessoa;
    }

    public TipoEndereco getTipoEnderco() {
	return tipoEnderco;
    }

    public void setTipoEnderco(TipoEndereco tipoEnderco) {
	this.tipoEnderco = tipoEnderco;
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
	Endereco other = (Endereco) obj;
	return Objects.equals(id, other.id);
    }

}
