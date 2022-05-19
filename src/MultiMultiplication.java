public class MultiMultiplication extends MultiOperation{

    public MultiMultiplication(Expression... expressions){
        super(expressions);
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("(");
        for(int i = 0; i<expressions.length-1; i++){
            result.append(expressions[i].toString()).append(" * ");
        }
        return result.toString() + expressions[expressions.length-1].toString()+")";
    }

    @Override
    public double evaluate() {
        double result = 0;
        for (Expression expression : expressions) {
            result *= expression.evaluate();
        }
        return result;
    }
}
