package Apply_Discount_to_Prices_2288;

public class Solution {


    public static void main(String[] args) {
        System.out.println(discountPrices("$7383692 5q $5870426",100));
    }

    public enum State{
        none,
        space,
        record
    }

    public static String discountPrices(String sentence, int discount) {


        char[] chars = sentence.toCharArray();

        State state = State.none;

        StringBuilder resultString = new StringBuilder();
        StringBuilder number = new StringBuilder();
        resultString.append(chars[0]);
        if(chars[0] == '$'){
            state = State.record;
        }

        for (int i = 1; i < chars.length; i++) {

            char current = chars[i];

            if(state==State.none){

                if(current == ' '){
                    state = State.space;
                }
                resultString.append(current);
            }else if(state == State.space){

                if(current=='$'){
                    state = State.record;
                }else {
                    state = State.none;
                }
                resultString.append(current);
            }else if(state == State.record){

                if(48<=current&&57>=current){
                    number.append(current);
                }else if(current==' '){
                    // record number with discount
                    if(!number.isEmpty()){
                        double v = Double.parseDouble(number.toString());
                        resultString.append(String.format("%.2f",v-(v*discount/100)));
                        number.setLength(0);
                        state = State.space;
                    }
                    resultString.append(current);
                }else{
                    // record
                    resultString.append(number);
                    state = State.none;

                    resultString.append(current);
                    number.setLength(0);
                }

            }
        }

        if(state==State.record && !number.isEmpty()){
            double v = Double.parseDouble(number.toString());
            resultString.append(String.format("%.2f",v-(v*discount/100)));
        }

        return resultString.toString();
    }


}
