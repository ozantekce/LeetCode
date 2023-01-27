package Apply_Discount_to_Prices_2288;

public class Solution {


    public static void main(String[] args) {

        System.out.println(discountPrices("favsijl39l3ur$czt6rz hz $68050 lz9 ny 59o $4 $ $",9));
    }

    public enum State{
        none,
        space,
        record
    }

    public static String discountPrices(String sentence, int discount) {


        char[] chars = sentence.toCharArray();

        State state = State.none;

        int recordStart = 0;
        int recordStop;


        StringBuilder resultString = new StringBuilder();

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
                    recordStart = i;
                }else {
                    state = State.none;
                }
                resultString.append(current);
            }else if(state == State.record){

                if(48<=current&&57>=current){
                    //number.append(current);
                }else if(current==' '){
                    recordStop = i;
                    // record number with discount
                    double v = createDoubleFromChars(chars,recordStart,recordStop);
                    if(v!=-1){
                        resultString.append(String.format("%.2f",v-(v*discount/100)));
                    }

                    state = State.space;
                    resultString.append(current);
                }else{
                    recordStop = i;
                    // record
                    double v = createDoubleFromChars(chars,recordStart,recordStop);
                    if(v!=-1)
                        resultString.append(((int)v));
                    state = State.none;

                    resultString.append(current);
                }

            }
        }

        if(state==State.record){
            double v = createDoubleFromChars(chars,recordStart,chars.length);
            if(v!=-1)
                resultString.append(String.format("%.2f",v-(v*discount/100)));
        }

        return resultString.toString();
    }


    private static double createDoubleFromChars(char[] chars,int f, int l){

        if(f+1>=l){
            return -1;
        }
        double num = 0;
        double m = 1;
        for (int i = l-1; i >=f+1 ; i--) {
            num += (chars[i]-48)*m;
            m*=10;
        }

        return num;
    }


}
