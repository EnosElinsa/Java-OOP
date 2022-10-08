package oop.homework.arithope;

import java.util.ArrayList;
import java.util.Stack;

/**整数算术表达式分析程序 <br/>
 * 1. 从键盘输入一个表示整数四则运算的字符串，例如：32 + 5 * ( 30 - 40 ) / 3 - 12 <br/>
 * 2. 四则运算的字符串中符号说明：<br/>
 * +代表整数加法、<br/>
 * -代表整数减法、<br/>
 * *代表整数乘法、<br/>
 * /代表整数除法（结果为整数）、<br/>
 * () 括号<br/>
 * 运算数全部为正整数<br/>
 * 假设输入的字符串一定是符合运算规则的整数四则运算的表达式。<br/>
 * 为方便输入和处理数据，运算数和运算符号之间有且仅有一个空格。<br/>
 * 3. 运算规则：整数四则运算符的优先级和结合性对表达式进行分析并产生输出结果。<br/>
 */

public class IntegerArithmeticExpression {
    static final String ADDITION = "+";
    static final String SUBSTRACTION = "-";
    static final String MULTIPLICATION = "*";
    static final String DIVISION = "/";
    static final String OPENING_PARENTHESES = "(";
    static final String CLOSING_PARENTHESES = ")";
    private String[] infixExpression;
    private ArrayList<String> postfixExpression;
    private int result = 0;

    public IntegerArithmeticExpression(String input) {
        this.infixExpression = input.split(" ");
        this.postfixExpression = this.infix2Postfix(infixExpression);
        this.result = this.evaluate(this.postfixExpression);
    }

    public ArrayList<String> infix2Postfix(String[] infixExpression) {
        ArrayList<String> postfixExpression = new ArrayList<>();
        Stack<String> operators = new Stack<>();
        for (String token : infixExpression) {
            if (isOperand(token)) {
                postfixExpression.add(token);
            }
            else if (isOperator(token)){
                while (!operators.isEmpty() && !hasHigherPrecedence(token, operators.peek()) 
                    && !isOpeningParentheses(operators.peek())) {
                        postfixExpression.add(operators.peek());
                        operators.pop();
                }
                operators.push(token);
            }
            else if (isOpeningParentheses(token)) {
                operators.push(token);
            }
            else if (isClosingParentheses(token)) {
                while (!operators.isEmpty() && !isOpeningParentheses(operators.peek())) {
                    postfixExpression.add(operators.peek());
                    operators.pop();
                }
                operators.pop();
            }
            else {
                System.out.println("输入的表达式不规范");
                System.exit(0);
            }
        }
        while (!operators.isEmpty()) {
            postfixExpression.add(operators.peek());
            operators.pop();
        }
        return postfixExpression;
    }

    private int evaluate(ArrayList<String> postfixExpression) {
        Stack<Integer> operands = new Stack<>();
        for (String token : postfixExpression) {
            if (isOperand(token)) {
                operands.push(Integer.parseInt(token));
            }
            else {
                int operandB = operands.peek();
                operands.pop();
                int operandA = operands.peek();
                operands.pop();
                operands.push(perform(token, operandA, operandB));
            }
        }
        return operands.peek();
    }

    private int perform(String operator, int operandA, int operandB) {
        int result = 0;
        switch (operator) {
            case ADDITION: result = operandA + operandB; break;
            case SUBSTRACTION: result = operandA - operandB; break;
            case MULTIPLICATION: result = operandA * operandB; break;
            case DIVISION: result = operandA / operandB; break;
        }
        return result;
    }

    private boolean isOperand(String token) {
        int ch = (int)token.charAt(0);
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }

    private boolean isOperator(String token) {
        if (token.equals(ADDITION) || token.equals(SUBSTRACTION) 
            || token.equals(MULTIPLICATION) || token.equals(DIVISION)) {
                return true;
        }
        return false;
    }

    private boolean isOpeningParentheses(String token) {
        if (token.equals(OPENING_PARENTHESES)) {
            return true;
        }
        return false;
    }

    private boolean isClosingParentheses(String token) {
        if (token.equals(CLOSING_PARENTHESES)) {
            return true;
        }
        return false;
    }

    private boolean hasHigherPrecedence(String tokenA, String tokenB) {
        if ((tokenA.equals(MULTIPLICATION) || tokenA.equals(DIVISION)) 
            && (tokenB.equals(ADDITION) || tokenB.equals(SUBSTRACTION))) {
                return true;
        }
        return false;
    }

    public int getResult() {
        return result;
    }

    public String[] getInfixExpression() {
        return infixExpression;
    }

    public ArrayList<String> getPostfixExpression() {
        return postfixExpression;
    }
}
