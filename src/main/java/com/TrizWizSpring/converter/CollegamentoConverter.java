package com.TrizWizSpring.converter;

import com.TrizWizSpring.dto.CollegamentoDTO;
import com.TrizWizSpring.dto.ToolDTO;
import com.TrizWizSpring.model.Collegamento;
import com.TrizWizSpring.model.Tool;

public class CollegamentoConverter {

	public static CollegamentoDTO convertToDto(Collegamento t) {

		CollegamentoDTO collegamentoDTO= new CollegamentoDTO();
		collegamentoDTO.setIdCollegamento(t.getIdCollegamento());
		collegamentoDTO.setCommento(t.getCommento());
		collegamentoDTO.setFase(FaseConverter.convertToDto(t.getFase()));
		collegamentoDTO.setTool(ToolConverter.convertToDto(t.getTool()));
		return collegamentoDTO;
			}
	
	public static Collegamento convertToCollegamento(CollegamentoDTO t) {
		Collegamento collegamento= new Collegamento();
		collegamento.setIdCollegamento(t.getIdCollegamento());
		collegamento.setCommento(t.getCommento());
		collegamento.setFase(FaseConverter.convertToFase(t.getFase()));
		collegamento.setTool(ToolConverter.convertToTool(t.getTool()));
		return collegamento;
	}
}
