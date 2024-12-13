package Espr;

public enum Functions {
    COS, SIN, TAN, SQRT, LOG, LN, ACOS, ASIN, ATAN, ABS, ROUND, EXP, COSH, SINH, TANH;

    // Metodo per valutare le funzioni
    public double Eval(double arg) {
        switch (this) {
            case COS: return Math.cos(arg); 
            case SIN: return Math.sin(arg); 
            case TAN: return Math.tan(arg); 
            case SQRT: 
                
                if (arg < 0) throw new ArithmeticException("Radice quadrata di un numero negativo non supportata");
                return Math.sqrt(arg); 
            case LOG: 
                
                if (arg <= 0) throw new ArithmeticException("Logaritmo in base 10 di un numero negativo o zero non supportato");
                return Math.log10(arg); 
            case LN: 
                
                if (arg <= 0) throw new ArithmeticException("Logaritmo naturale di un numero negativo o zero non supportato");
                return Math.log(arg); 
            case ACOS: 
                
                if (arg < -1 || arg > 1) throw new ArithmeticException("ACOS richiede un argomento tra -1 e 1");
                return Math.acos(arg); 
            case ASIN: 
               
                if (arg < -1 || arg > 1) throw new ArithmeticException("ASIN richiede un argomento tra -1 e 1");
                return Math.asin(arg); 
            case ATAN: return Math.atan(arg); 
            case ABS: return Math.abs(arg); 
            case ROUND: return Math.round(arg); 
            case EXP: return Math.exp(arg); 
            case COSH: return Math.cosh(arg); 
            case SINH: return Math.sinh(arg); 
            case TANH: return Math.tanh(arg); 
            default: 
                
                throw new UnsupportedOperationException("Funzione non supportata: " + this);
        }
    }
}
