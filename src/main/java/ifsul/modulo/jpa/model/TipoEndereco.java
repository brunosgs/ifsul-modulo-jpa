package ifsul.modulo.jpa.model;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_tipo_endereco")
public class TipoEndereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_tipo_endereco", sequenceName = "seq_tipo_endereco_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_tipo_endereco", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "A descrição não pode ser nulo")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Length(max = 30, message = "A descrição não pode ter mais de {max} caracteres")
    @Column(name = "decricao", length = 30, nullable = false)
    private String descricao;

    public TipoEndereco() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
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
	TipoEndereco other = (TipoEndereco) obj;
	return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
	return "TipoEndereco [descricao=" + descricao + "]";
    }

}
