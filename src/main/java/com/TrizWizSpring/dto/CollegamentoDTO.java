package com.TrizWizSpring.dto;

public class CollegamentoDTO {
	private long idCollegamento;
	private String commento;
	private FaseDTO fase;
	private ToolDTO tool;

   public CollegamentoDTO() {
	
  }

public CollegamentoDTO(long idCollegamento, String commento, FaseDTO fase, ToolDTO tool) {
	super();
	this.idCollegamento = idCollegamento;
	this.commento = commento;
	this.fase = fase;
	this.tool = tool;
}

public long getIdCollegamento() {
	return idCollegamento;
}

public void setIdCollegamento(long idCollegamento) {
	this.idCollegamento = idCollegamento;
}

public String getCommento() {
	return commento;
}

public void setCommento(String commento) {
	this.commento = commento;
}

public FaseDTO getFase() {
	return fase;
}

public void setFase(FaseDTO fase) {
	this.fase = fase;
}

public ToolDTO getTool() {
	return tool;
}

public void setTool(ToolDTO tool) {
	this.tool = tool;
}

@Override
public String toString() {
	return "CollegamentoDTO [idCollegamento=" + idCollegamento + ", commento=" + commento + ", fase=" + fase + ", tool="
			+ tool + "]";
}
}
