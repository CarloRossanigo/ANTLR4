package expression;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SetExpression extends Expression {
    private Expression left; 
    private Expression right;
    private String operator;
//Costruttore per le espressioni con due operandi e un operatore logico
    public SetExpression(Expression left, Expression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }
//Costruttore per le operazioni unarie(Complemento)
    public SetExpression(Expression argument, String operator) {
        this(argument, null, operator);
    }
//Evaluation dell'operazione
    @Override
    public Value evaluate(Environment env) {
        Value leftValue = left.evaluate(env);
        Value rightValue = right != null ? right.evaluate(env) : null;
        if (leftValue instanceof ValueSet) {
            List<Object> leftList = leftValue.getValue();
            List<Object> rightList = rightValue != null ? rightValue.getValue() : null;

            List<Object> result = evaluateSetOperation(leftList, rightList, env);
            return new ValueSet(result);
        } else {
            throw new UnsupportedOperationException("Operatore non supportato: " + leftValue.getClass().getName());
        }
    }
    private List<Object> evaluateSetOperation(List<Object> leftList, List<Object> rightList, Environment env) {
        List<Object> result;
        switch (operator) {
            case "+":
                result = unione(leftList, rightList);
                break;
            case "^":
                result = intersezione(leftList, rightList);
                break;
            case "/":
                result = differenza(leftList, rightList);
                break;
            case "∆":
                result = differenzaSimmetrica(leftList, rightList);
                break;
            case "!":
                result = complemento(leftList, env);
                break;
            case "MIN":
                result = min(leftList);
                break;
            case "MAX":
                result = max(leftList);
                break;
            default:
                throw new UnsupportedOperationException("Operatore non supportato: " + operator);
        }
        return result;
    }
//Unione di due insiemi
    private List<Object> unione(List<Object> left, List<Object> right) {
        List<Object> result = new ArrayList<>(left);
        if (right != null) {
            for (Object elem : right) {
                if (!left.contains(elem)) {
                    result.add(elem);
                }
            }
        }
        return result;
    }
//Intersezione di due insiemi
    private List<Object> intersezione(List<Object> left, List<Object> right) {
        List<Object> result = new ArrayList<>();
        if (right != null) {
            for (Object elem : left) {
                if (right.contains(elem)) {
                    result.add(elem);
                }
            }
        }
        return result;
    }
// Differenza insiemistica fra due insiemi
    private List<Object> differenza(List<Object> left, List<Object> right) {
        List<Object> result = new ArrayList<>(left);
        if (right != null) {
            result.removeAll(right);
        }
        return result;
    }
// Differenza simmetrica fra due insiemi
    private List<Object> differenzaSimmetrica(List<Object> left, List<Object> right) {
        List<Object> result = new ArrayList<>(left);
        if (right != null) {
            for (Object elem : right) {
                if (!left.contains(elem)) {
                    result.add(elem);
                } else {
                    result.remove(elem);
                }
            }
        }
        return result;
    }
// Complemento di un insieme
    private List<Object> complemento(List<Object> set, Environment env) {
        List<Object> result = new ArrayList<>();
        Collection<Value> allSets = env.values().values();
        for (Value currSetValue : allSets) {
            List<Object> currSet = currSetValue.getValue();
            for (Object elem : currSet) {
                if (!set.contains(elem) && !result.contains(elem)) {
                    result.add(elem);
                }
            }
        }
        return result;
    }
//Minimo di un insieme
    private List<Object> min(List<Object> set) {
        if (set.isEmpty()) {
            throw new IllegalArgumentException("Non trovo minimo insieme.");
        }

        Object minEl = set.get(0);
        float minS = getLunghezza(minEl);

        for (Object elem : set) {
            float lun = getLunghezza(elem);
            if (lun < minS) {
                minEl = elem;
                minS = lun;
            }
        }

        return List.of(minEl);
    }
//Massimo di un insieme
    private List<Object> max(List<Object> set) {
        if (set.isEmpty()) {
            throw new IllegalArgumentException("Non trovo massimo insieme.");
        }

        Object maxEl = set.get(0);
        float maxS = getLunghezza(maxEl);

        for (Object elem : set) {
            float lun = getLunghezza(elem);
            if (lun > maxS) {
                maxEl = elem;
                maxS = lun;
            }
        }

        return List.of(maxEl);
    }
//Lunghezza di una stringa: per calcolare max e min, trasformo una stringa in un numero, che corrisponde alla sua lunghezza
    private float getLunghezza(Object elem) {
        if (elem instanceof Integer || elem instanceof Float) {
            return (float) elem;
        } else if (elem instanceof String) {
            return ((String) elem).length();
        } else {
            throw new UnsupportedOperationException("Tipo non supportato.");
        }
    }

    @Override
    public String toString() {
        if (right != null) {
            return "(" + left.toString() + " " + operator + " " + right.toString() + ")";
        } else {
            return "(" + operator + " " + left.toString() + ")";
        }
    }
}
