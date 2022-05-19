public abstract class BinaryOperation extends Expression{
    protected final Expression expression1;
    protected final Expression expression2;

    public BinaryOperation(Expression expression1, Expression expression2){
        this.expression1 = expression1;
        this.expression2 = expression2;
    }
}
