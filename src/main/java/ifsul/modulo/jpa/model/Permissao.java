package ifsul.modulo.jpa.model;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_permissao")
public class Permissao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "nome", length = 30, nullable = false)
    @NotBlank(message = "O nome não pode ser em branco")
    @NotNull(message = "O nome não pode ser nulo")
    @Length(max = 30, message = "O nome não pode ter mais de {max} caracteres")
    private String nome;

    @Column(name = "descricao", length = 40, nullable = false)
    @NotBlank(message = "A descricação não pode ser em branco")
    @NotNull(message = "A descricação não pode ser nulo")
    @Length(max = 40, message = "A descricação não pode ter mais de {max} caracteres")
    private String descricao;

    public Permissao() {
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    @Override
    public int hashCode() {
	return Objects.hash(nome);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Permissao other = (Permissao) obj;
	return Objects.equals(nome, other.nome);
    }

}
