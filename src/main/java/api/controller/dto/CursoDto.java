package api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import api.model.Curso;
import api.controller.dto.CursoDto;

public class CursoDto {
	
	private String nome;
	private String descricao;
	private String ementa;
	private float valor;
	
	
	public CursoDto(Curso cursos) {

		this.nome = cursos.getNome();
		this.descricao = cursos.getDescricao();
		this.ementa = cursos.getEmenta();
		this.valor = cursos.getValor();
	}


	public String getNome() {
		return nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public String getEmenta() {
		return ementa;
	}


	public float getValor() {
		return valor;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((ementa == null) ? 0 : ementa.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Float.floatToIntBits(valor);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoDto other = (CursoDto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (ementa == null) {
			if (other.ementa != null)
				return false;
		} else if (!ementa.equals(other.ementa))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}


	public static List<CursoDto> converter(List<Curso> cursos) {
		return cursos.stream().map(CursoDto::new).collect(Collectors.toList());
	}
	
}
