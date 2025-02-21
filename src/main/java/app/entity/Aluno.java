package app.entity;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Pattern (regexp = "^\\S+\\s+\\S+.*$")
	@NotBlank(message = "O nome nao pode estar em branco")
	private String nome;
	
	@CPF(message = "CPF invalido")
	private String cpf;
	
	private String telefone;
	
	@ManyToOne
	private Turma turma;
	
	private boolean cadastroCompleto;
	
}
