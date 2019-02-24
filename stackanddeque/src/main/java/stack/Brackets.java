package stack;

import java.util.ArrayList;
import java.util.List;

public class Brackets {

    private final String text;
    private final List<String> errors = new ArrayList<String>();

    public Brackets(String text) {
        this.text = text;
    }

    public List<String> check() {
        Stack<Character> stack = new StackImpl<Character>(text.length());

        for (int index = 0; index < text.length(); index++) {
            char currentChar = text.charAt(index);
            switch (currentChar) {
                case '[':
                case '{':
                case '(':
                    stack.push(currentChar);
                    break;
                case ']':
                case '}':
                case ')':
                    if (stack.isEmpty()){
                        displayError(index, currentChar);
                    }
                    else {
                        Character top = stack.pop();
                        if (top == '[' && currentChar != ']' ||
                                top == '{' && currentChar != '}' ||
                                top == '(' && currentChar != ')'){
                            displayError(index, currentChar);
                        }
                    }
                    break;
                    default:
                        break;
            }
        }

        if ( !stack.isEmpty()){
            errors.add("Error: missing right delimiter");
        }
        return errors;
    }

    private void displayError(int index, char currentChar) {
        errors.add("Error: " + currentChar + "at" + index);
    }
}
