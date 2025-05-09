package denuncia.model;

import java.util.ArrayList;

import denuncia.dao.DenunciaDao;

public class Denuncia {

	private int idDenuncia;
	private String pais;
	private int qtdDenuncias;
	private String tipo;
	private String gravidade;
	private int casosConfirmados;
	
	public Denuncia(){
	}
	
	public Denuncia(int idDenuncia, String pais, String tipo, int qtdDenuncia, int casosConfirmados, String gravidade) {
		this.idDenuncia= idDenuncia;
		this.pais= pais;
		this.tipo = tipo;
		this.qtdDenuncias= qtdDenuncia;
		this.gravidade = gravidade;
		this.casosConfirmados = casosConfirmados;
		
	}
	
	public Denuncia(String pais, String tipo, int qtdDenuncia, int casosConfirmados, String gravidade) {
		this.pais= pais;
		this.tipo = tipo;
		this.qtdDenuncias= qtdDenuncia;
		this.casosConfirmados = casosConfirmados;
		this.gravidade = gravidade;
	}
	
	public int getIdDenuncia() {
		return this.idDenuncia;
	}
	
	public void setIdDenuncia(int idDenuncia) {
		this.idDenuncia = idDenuncia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getQtdDenuncia() {
		return qtdDenuncias;
	}

	public void setQtdDenuncia(int quantidade) {
		this.qtdDenuncias = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getGravidade() {
		return gravidade;
	}

	public void setGravidade(String gravidade) {
		this.gravidade = gravidade;
	}

	public int getCasosConfirmados() {
		return casosConfirmados;
	}

	public void setCasosConfirmados(int casosConfirmados) {
		this.casosConfirmados = casosConfirmados;
	}
	
	public void salvar() {
		new DenunciaDao().cadastrarDenuncia(this);
	}
	
	public ArrayList<Denuncia> buscarDenunciaPorPais(String pais) {
		return new DenunciaDao().BuscarDenunciaPorPais(pais);
	}
}
