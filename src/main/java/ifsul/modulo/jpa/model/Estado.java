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
@Table(name = "tb_estado")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_estado", strategy = GenerationType.SEQUENCE)
	Integer id;

	@Column(name = "nome", length = 50, nullable = false)
	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome deve ser informado")
	@Length(max = 50, message = "O nome não pode ter mais de {max} caracteres")
	String nome;

	@Column(name = "uf", length = 2, nullable = false)
	@NotNull(message = "A UF não pode ser nulo")
	@NotBlank(message = "A UF deve ser informado")
	@Length(max = 2, message = "A UF não pode ter mais de {max} caracteres")
	String uf;

	@ManyToOne
	@JoinColumn(name = "pais", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_pais"))
	@NotNull(message = "O Pais deve ser informado")
	Pais pais;

	public Estado() {
		super();
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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
		Estado other = (Estado) obj;
		return Objects.equals(id, other.id);
	}

}
