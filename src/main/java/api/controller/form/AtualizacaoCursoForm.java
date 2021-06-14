package api.controller.form;

import api.model.Curso;
import api.repository.CursoRepository;

public class AtualizacaoCursoForm {
	
	private String nome;
	private String descricao;
	private String ementa;
	private float valor;
	
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
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public Curso atualizar(Integer id, CursoRepository cursoRepository) {
		
		Curso curso = cursoRepository.getById(id);
		
		curso.setNome(this.nome);
		curso.setDescricao(this.descricao);
		curso.setEmenta(this.ementa);
		curso.setValor(this.valor);
		
		return curso;
		
	}

}
