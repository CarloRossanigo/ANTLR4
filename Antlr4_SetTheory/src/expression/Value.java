package expression;

import java.util.List;
//Classe astratta per i valori
public abstract class Value {
	// Metodo astratto che restituisce il valore associato all'oggetto Value
	public abstract List<Object> getValue();
}
