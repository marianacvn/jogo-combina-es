package model;

import java.util.ArrayList;

public class TiposSanguineos {
	private static ArrayList<String> combinacoes = new ArrayList<>();
	
	public static ArrayList<String> verificarCombinacao(String primeiro, String segundo) {
		
		if(primeiro.equals("A+") && segundo.equals("A+")) {
			combinacoes.add("A+");
			combinacoes.add("O+");
			return combinacoes;
		} else if (primeiro.equals("A-") && segundo.equals("A-")){
			combinacoes.add("A-");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("A+") && segundo.equals("A-")){
			combinacoes.add("A+");
			combinacoes.add("A-");
			combinacoes.add("O+");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("A-") && segundo.equals("A+")){
			combinacoes.add("A+");
			combinacoes.add("A-");
			combinacoes.add("O+");
			combinacoes.add("O-");
			return combinacoes;
		}else if (primeiro.equals("A+") && segundo.equals("O+")){
			combinacoes.add("A+");
			combinacoes.add("O+");
			return combinacoes;
		} else if (primeiro.equals("A-") && segundo.equals("O+")){
			combinacoes.add("A+");
			combinacoes.add("A-");
			combinacoes.add("O+");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("A+") && segundo.equals("O-")){
			combinacoes.add("A+");
			combinacoes.add("A-");
			combinacoes.add("O+");
			combinacoes.add("O-");
			return combinacoes;
		}else if (primeiro.equals("A-") && segundo.equals("O-")){
			combinacoes.add("A-");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("A+") && segundo.equals("B+")){
			combinacoes.add("A+");
			combinacoes.add("B+");
			combinacoes.add("O+");
			combinacoes.add("AB+");			
			return combinacoes;
		} else if (primeiro.equals("A-") && segundo.equals("B+")){
			combinacoes.add("A+");
			combinacoes.add("B+");
			combinacoes.add("A-");
			combinacoes.add("B-");
			combinacoes.add("O-");
			combinacoes.add("O+");
			combinacoes.add("AB+");
			combinacoes.add("AB-");		
			return combinacoes;
		} else if (primeiro.equals("A-") && segundo.equals("B-")){
			combinacoes.add("A-");
			combinacoes.add("B-");
			combinacoes.add("O-");
			combinacoes.add("AB-");		
			return combinacoes;
		} else if (primeiro.equals("A+") && segundo.equals("B-")){
			combinacoes.add("A+");
			combinacoes.add("B+");
			combinacoes.add("A-");
			combinacoes.add("B-");
			combinacoes.add("O-");
			combinacoes.add("O+");
			combinacoes.add("AB+");
			combinacoes.add("AB-");		
			return combinacoes;
		} else if (primeiro.equals("A+") && segundo.equals("AB+")){
			combinacoes.add("A+");
			combinacoes.add("B+");
			combinacoes.add("AB+");
			return combinacoes;
		} else if (primeiro.equals("A-") && segundo.equals("AB+")){
			combinacoes.add("A+");
			combinacoes.add("B+");
			combinacoes.add("A-");
			combinacoes.add("B-");
			combinacoes.add("AB+");
			combinacoes.add("AB-");		
			return combinacoes;
		} else if (primeiro.equals("A-") && segundo.equals("AB-")){
			combinacoes.add("A-");
			combinacoes.add("B-");
			combinacoes.add("AB-");		
			return combinacoes;
		} else if (primeiro.equals("A+") && segundo.equals("AB-")){
			combinacoes.add("A+");
			combinacoes.add("B+");
			combinacoes.add("A-");
			combinacoes.add("B-");
			combinacoes.add("AB+");
			combinacoes.add("AB-");
			return combinacoes;
		} else if (primeiro.equals("B+") && segundo.equals("B+")){
			combinacoes.add("B+");
			combinacoes.add("O+");
			return combinacoes;
		} else if (primeiro.equals("B-") && segundo.equals("B-")){
			combinacoes.add("B-");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("B-") && segundo.equals("B+")){
			combinacoes.add("B+");
			combinacoes.add("O+");
			combinacoes.add("B-");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("B+") && segundo.equals("B-")){
			combinacoes.add("B+");
			combinacoes.add("O+");
			combinacoes.add("B-");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("B+") && segundo.equals("O+")){
			combinacoes.add("B+");
			combinacoes.add("O+");
			return combinacoes;
		} else if (primeiro.equals("B+") && segundo.equals("O-")){
			combinacoes.add("B+");
			combinacoes.add("O+");
			combinacoes.add("B-");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("B-") && segundo.equals("O+")){
			combinacoes.add("B+");
			combinacoes.add("O+");
			combinacoes.add("B-");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("B-") && segundo.equals("O-")){
			combinacoes.add("B-");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("B+") && segundo.equals("A+")){
			combinacoes.add("B+");
			combinacoes.add("O+");
			combinacoes.add("AB+");
			return combinacoes;
		} else if (primeiro.equals("B+") && segundo.equals("A-")){
			combinacoes.add("B+");
			combinacoes.add("A-");
			combinacoes.add("A+");
			combinacoes.add("O+");
			combinacoes.add("AB+");
			combinacoes.add("B-");
			combinacoes.add("O-");
			combinacoes.add("AB-");
			return combinacoes;
		} else if (primeiro.equals("B-") && segundo.equals("A-")){
			combinacoes.add("A-");
			combinacoes.add("B-");
			combinacoes.add("O-");
			combinacoes.add("AB-"); 
			return combinacoes;
		} else if (primeiro.equals("B-") && segundo.equals("A+")){
			combinacoes.add("B+");
			combinacoes.add("A-");
			combinacoes.add("A+");
			combinacoes.add("O+");
			combinacoes.add("AB+");
			combinacoes.add("B-");
			combinacoes.add("O-");
			combinacoes.add("AB-");
			return combinacoes;
		} else if (primeiro.equals("B+") && segundo.equals("AB+")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			combinacoes.add("AB+");
			return combinacoes;
		} else if (primeiro.equals("B+") && segundo.equals("AB-")){
			combinacoes.add("B+");
			combinacoes.add("A-");
			combinacoes.add("A+");
			combinacoes.add("AB+");
			combinacoes.add("B-");
			combinacoes.add("AB-");
			return combinacoes;
		} else if (primeiro.equals("B-") && segundo.equals("AB-")){
			combinacoes.add("A-");
			combinacoes.add("B-");
			combinacoes.add("AB-");
			return combinacoes;
		} else if (primeiro.equals("B-") && segundo.equals("AB+")){
			combinacoes.add("B+");
			combinacoes.add("A-");
			combinacoes.add("A+");
			combinacoes.add("AB+");
			combinacoes.add("B-");
			combinacoes.add("AB-");
			return combinacoes;

		} else if (primeiro.equals("O+") && segundo.equals("O+")){
			combinacoes.add("O+");
			return combinacoes;
		} else if (primeiro.equals("O+") && segundo.equals("O-")){
			combinacoes.add("O+");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("O-") && segundo.equals("O-")){
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("O-") && segundo.equals("O+")){
			combinacoes.add("O+");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("O+") && segundo.equals("A+")){
			combinacoes.add("A+");
			combinacoes.add("O+");
			return combinacoes;
		} else if (primeiro.equals("O+") && segundo.equals("A-")){
			combinacoes.add("A+");
			combinacoes.add("A-");
			combinacoes.add("O+");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("O-") && segundo.equals("A-")){
			combinacoes.add("A-");
			combinacoes.add("O-");
			return combinacoes;
		}else if (primeiro.equals("O-") && segundo.equals("A+")){
			combinacoes.add("A-");
			combinacoes.add("O-");
			combinacoes.add("A+");
			combinacoes.add("O+");
			return combinacoes;
		} else if (primeiro.equals("O+") && segundo.equals("B+")){
			combinacoes.add("B+");
			combinacoes.add("O+");
			return combinacoes;
		} else if (primeiro.equals("O+") && segundo.equals("B-")){
			combinacoes.add("B+");
			combinacoes.add("O+");
			combinacoes.add("B-");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("O-") && segundo.equals("A-")){
			combinacoes.add("B-");
			combinacoes.add("O-");
			return combinacoes;
		} else if (primeiro.equals("O-") && segundo.equals("B+")){
			combinacoes.add("B-");
			combinacoes.add("O-");
			combinacoes.add("B+");
			combinacoes.add("O+");
			return combinacoes;
		} else if (primeiro.equals("O+") && segundo.equals("AB+")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			return combinacoes;
		}  else if (primeiro.equals("O+") && segundo.equals("AB-")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			combinacoes.add("B-");
			combinacoes.add("A-");
			return combinacoes;
		} else if (primeiro.equals("O-") && segundo.equals("AB-")){
			combinacoes.add("B-");
			combinacoes.add("A-");
			return combinacoes;
		} else if (primeiro.equals("O-") && segundo.equals("AB+")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			combinacoes.add("B-");
			combinacoes.add("A-");
			return combinacoes;
		} else if (primeiro.equals("AB+") && segundo.equals("A+")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			combinacoes.add("AB+");
			return combinacoes;
		} else if (primeiro.equals("AB+") && segundo.equals("A-")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			combinacoes.add("AB+");
			combinacoes.add("B-");
			combinacoes.add("A-");
			combinacoes.add("AB-");
			return combinacoes;
		} else if (primeiro.equals("AB-") && segundo.equals("A-")){
			combinacoes.add("B-");
			combinacoes.add("A-");
			combinacoes.add("AB-");
			return combinacoes;
		} else if (primeiro.equals("AB-") && segundo.equals("A+")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			combinacoes.add("AB+");
			combinacoes.add("B-");
			combinacoes.add("A-");
			combinacoes.add("AB-");
			return combinacoes;
		}  else if (primeiro.equals("AB+") && segundo.equals("B+")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			combinacoes.add("AB+");
			return combinacoes;
		} else if (primeiro.equals("AB+") && segundo.equals("B-")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			combinacoes.add("AB+");
			combinacoes.add("B-");
			combinacoes.add("A-");
			combinacoes.add("AB-");
			return combinacoes;
		} else if (primeiro.equals("AB-") && segundo.equals("B-")){
			combinacoes.add("B-");
			combinacoes.add("A-");
			combinacoes.add("AB-");
			return combinacoes;
		} else if (primeiro.equals("AB-") && segundo.equals("B+")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			combinacoes.add("AB+");
			combinacoes.add("B-");
			combinacoes.add("A-");
			combinacoes.add("AB-");
			return combinacoes;
		} else if (primeiro.equals("AB+") && segundo.equals("O+")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			return combinacoes;
		}  else if (primeiro.equals("AB+") && segundo.equals("O-")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			combinacoes.add("B-");
			combinacoes.add("A-");
			return combinacoes;
		} else if (primeiro.equals("AB-") && segundo.equals("O-")){
			combinacoes.add("B-");
			combinacoes.add("A-"); 
			return combinacoes;
		} else if (primeiro.equals("AB-") && segundo.equals("O+")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			combinacoes.add("B-");
			combinacoes.add("A-");
			return combinacoes;
		} else if (primeiro.equals("AB+") && segundo.equals("AB+")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			combinacoes.add("AB+");
			return combinacoes;
		} else if (primeiro.equals("AB+") && segundo.equals("AB-")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			combinacoes.add("AB+");
			combinacoes.add("B-");
			combinacoes.add("A-");
			combinacoes.add("AB-");
			return combinacoes;
		} else if (primeiro.equals("AB-") && segundo.equals("AB-")){
			combinacoes.add("B-");
			combinacoes.add("A-");
			combinacoes.add("AB-");
			return combinacoes;
		} else if (primeiro.equals("AB-") && segundo.equals("AB+")){
			combinacoes.add("B+");
			combinacoes.add("A+");
			combinacoes.add("AB+");
			combinacoes.add("B-");
			combinacoes.add("A-");
			combinacoes.add("AB-");
			return combinacoes;
		} else {
			return combinacoes;
		}
	}

	public static void setCombinacoes(ArrayList<String> combinacoes) {
		TiposSanguineos.combinacoes = combinacoes;
	}
	
}
