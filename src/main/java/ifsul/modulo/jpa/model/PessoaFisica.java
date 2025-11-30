package ifsul.modulo.jpa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(
	name = "tb_pessoa_fisica",
	uniqueConstraints = { @UniqueConstraint(name = "uk_pessoa_fisica", columnNames = "nome_usuario") })
@PrimaryKeyJoinColumn(name = "pessoa_fisica_id", foreignKey = @ForeignKey(name = "fk_pessoa_fisica_id"))
public class PessoaFisica extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "rg", length = 10, nullable = false)
    @NotNull(message = "O RG não pode ser nulo")
    @NotBlank(message = "O RG não pode ser em branco")
    @Length(max = 10, message = "O RG não pode ter mais de {max} caracteres")
    private String rg;

    @Column(name = "cpf", length = 14, nullable = false)
    @NotNull(message = "O CPF não pode ser nulo")
    @NotBlank(message = "O CPF não pode ser em branco")
    @Length(max = 14, message = "O CPF não pode ter mais de {max} caracteres")
    @CPF(message = "O CPF deve ser válido")
    private String cpf;

    @Column(name = "nascimento", nullable = false, columnDefinition = "DATE")
    @NotNull(message = "O nascimento não pode ser nulo")
    private LocalDate nascimento;

    @Column(name = "nome_usuario", length = 10, nullable = false, unique = true)
    @NotNull(message = "O nome do usuário não pode ser nulo")
    @NotBlank(message = "O nome do usuário não pode ser em branco")
    @Length(max = 10, message = "O nome do usuário não pode ter mais de {max} caracteres")
    private String nomeUsuario;

    @Column(name = "senha", length = 10, nullable = false)
    @NotNull(message = "A senha não pode ser nulo")
    @NotBlank(message = "A senha não pode ser em branco")
    @Length(max = 10, message = "A senha não pode ter mais de {max} caracteres")
    private String senha;

    @ManyToMany
    @JoinTable(
	    name = "tb_desejos",
	    joinColumns = @JoinColumn(
		    name = "pessoa_fisica_id",
		    referencedColumnName = "pessoa_fisica_id",
		    nullable = false,
		    foreignKey = @ForeignKey(name = "fk_pessoa_fisica_produto_id")),
	    inverseJoinColumns = @JoinColumn(
		    name = "produto_id",
		    referencedColumnName = "id",
		    nullable = false,
		    foreignKey = @ForeignKey(name = "fk_produto_pessoa_fisica_id")),
	    uniqueConstraints = { @UniqueConstraint(
		    name = "uk_desejos_pessoa_fisica_produto",
		    columnNames = { "pessoa_fisica_id", "produto_id" }) })
    private List<Produto> desejos = new ArrayList<>();

    @ManyToMany
    @JoinTable(
	    name = "tb_permissoes",
	    joinColumns = @JoinColumn(
		    name = "nome_usuario",
		    referencedColumnName = "nome_usuario",
		    nullable = false,
		    foreignKey = @ForeignKey(name = "fk_nome_usuario")),
	    inverseJoinColumns = @JoinColumn(
		    name = "permissao_nome",
		    referencedColumnName = "nome",
		    nullable = false,
		    foreignKey = @ForeignKey(name = "fk_permissao_nome")),
	    uniqueConstraints = { @UniqueConstraint(
		    name = "uk_permissoes_nome_usuario_permissao_nome",
		    columnNames = { "nome_usuario", "permissao_nome" }) })
    private List<Permissao> permissoes = new ArrayList<>();

    public PessoaFisica() {
    }

    public String getRg() {
	return rg;
    }

    public void setRg(String rg) {
	this.rg = rg;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public LocalDate getNascimento() {
	return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
	this.nascimento = nascimento;
    }

    public String getNomeUsuario() {
	return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
	this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    public List<Produto> getDesejos() {
	return desejos;
    }

    public void setDesejos(List<Produto> desejos) {
	this.desejos = desejos;
    }

    public List<Permissao> getPermissoes() {
	return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
	this.permissoes = permissoes;
    }

}
