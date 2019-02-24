package stack;

public class MainStack {

    public static final int MAX_LENGTH_STRING = 30;
    public static final String STRING_ORIGIN = "qwerty";

    public static void main(String[] args) {

        System.out.println("Строка в оригинале: " + "\n" + STRING_ORIGIN);
        System.out.println("Строка после прочтения из стека: " + "\n" + reverce(STRING_ORIGIN));

    }

    public static String reverce (String str){
        char[] chars = str.toCharArray();
        if (chars.length > MAX_LENGTH_STRING){
            System.out.println("Error: На вход подали строку содержащую > " + MAX_LENGTH_STRING + " символов.");
        }
        Stack<Character> origin = new StackImpl<>(MAX_LENGTH_STRING);


        for (int i = 0; i < chars.length; i++) {
            origin.push(chars[i]);
        }
        System.out.println("Строка размером " + origin.size() + " записана в стэк");


        StringBuilder sb = new StringBuilder();
        while ( !origin.isEmpty()){
            sb.append(origin.pop());
        }
        System.out.println("Строка прочитана из стэка и его емкость = " + origin.size());

        return String.valueOf(sb);
    }
}
