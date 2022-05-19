public class PolishNotationParser extends ExpressionParser{
    public PolishNotationParser(){
        super(1, 0);
    }

    @Override
    protected Expression newNumber(String number){
        return new DoubleLiteral(Double.parseDouble(number));
    }

}
