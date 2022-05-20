/**
 * This class parses a string into an expression that we can work with
 */
public class ExpressionParser {
    private int location;
    private final int direction;
    private final int startingPointFlag;

    public ExpressionParser(int direction, int startingPointFlag){
        this.direction = direction;
        this.startingPointFlag = startingPointFlag;
        this.location = 0;
    }

    /**
     * Calculates an expression that represents the string according to the notation
     * @param stringToParse the string to parse
     * @return an Expression
     */
    public Expression parse(String stringToParse){
        String[] parts = stringToParse.split(" ");
        //sets the initial variables according to the notation
        if(startingPointFlag == 0)
            location = 0;
        else
            location = parts.length - 1;
        //calls the recursive function
        return parse(parts);
    }

    /**
     * Calculates an expression that represents the string according to the notation
     * @param expressionParts a string divided into parts
     * @return an Expression
     */
    private Expression parse(String[] expressionParts){
        Expression expression1, expression2 = null;
        //return null if out of bounds
        if(location >= expressionParts.length || location <= -1)
            return null;
        //saves the index of the operator and increases the current location
        int start = location;
        location += direction;
        //return the current expression if we reached a number
        if(isNumeric(expressionParts[location - direction]))
            return this.newNumber(expressionParts[location - direction]);
        expression1 = parse(expressionParts);
        //don't calculate the second expression for unary minus
        if(!expressionParts[start].equals("-u"))
            expression2 = parse(expressionParts);
        return createExpression(expressionParts[start], expression1, expression2);
    }

    /**
     * Creates an expression using two other expressions and an operator according to the notation
     * @param operator indicates the operator that needs to be used
     * @param expression1 the first expression
     * @param expression2 the first expression
     * @return an Expression
     */
    private Expression createExpression(String operator, Expression expression1, Expression expression2){
        switch(operator){
            case "+":
                if(startingPointFlag == 1)
                    return new Addition(expression2, expression1);
                return new Addition(expression1, expression2);
            case "-":
                return new Subtraction(expression1, expression2);
            case "/":
                return new Division(expression1, expression2);
            case "*":
                if(startingPointFlag == 1)
                    return new Multiplication(expression2, expression1);
                return new Multiplication(expression1, expression2);
            case "-u":
                return new UnaryMinus(expression1);
            default:
                return null;
        }
    }

    /**
     * Creates an expression that represents a given number
     * @param number the number to turn into an expression
     * @return an Expression
     */
    protected Expression newNumber(String number){
        try{
            return new IntegerLiteral(Integer.parseInt(number));
        }
        catch(NumberFormatException e){
            return new DoubleLiteral(Double.parseDouble(number));
        }
    }

    /**
     * Checks if a given string can be turned into an integer or a double
     * @param strToCheck
     * @return a boolean
     */
    private boolean isNumeric(String strToCheck){
        try{
            double number = Double.parseDouble(strToCheck);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}
