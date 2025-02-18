package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	

	public String save(Aluno aluno) {
		this.alunoRepository.save(aluno);
		return "A aluno "+aluno.getNome()+" foi salvo com sucesso!";
	}


	public Aluno findById(long id) {
		return this.alunoRepository.findById(id).get();
	}


	public List<Aluno> findAll(){
		return this.alunoRepository.findAll();
	}

	public String update(Aluno aluno, long id) {
		aluno.setId(id);
		this.alunoRepository.save(aluno); 
		return "Aluno foi atualizado com sucesso!";
	}



	public String delete(long id) {

		this.alunoRepository.deleteById(id);

		return "A aluno foi deletado com sucesso!";
	}
	
	
	
	
}
