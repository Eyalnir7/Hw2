public class Addition extends BinaryOperation{

    public Addition(Expression expression1, Expression expression2){
        super(expression1, expression2);
    }

    @Override
    public String toString() {
        return "("+expression1.toString()+" + "+expression2.toString()+")";
    }

    @Override
    public double evaluate() {
        return expression1.evaluate()+expression2.evaluate();
    }
}
