package app.entity;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Pattern (regexp = "^\\S+\\s+\\S+.*$")
	@NotBlank(message = "O nome nao pode estar em branco")
	private String nome;
	
	@CPF(message = "CPF invalido")
	private String cpf;
	
	@Email(message = "Email invalido")
	private String email;
	
	@Pattern (regexp = "^\\S+\\s+\\S+.*$")
	private String especialidade;
	
	@ManyToMany
	@JoinTable(name="turma_professor")
	private List<Turma> turmas;
	
}

