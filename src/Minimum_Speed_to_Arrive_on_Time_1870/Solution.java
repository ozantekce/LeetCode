package Minimum_Speed_to_Arrive_on_Time_1870;

public class Solution {


    public static void main(String[] args) {
//[5,3,4,6,2,2,7]
//10.92
        int [] dist = {5,3,4,6,2,2,7};
        double h = 10.92;

        System.out.println(minSpeedOnTime(dist,h));

    }


    public static int minSpeedOnTime(int[] dist, double hour) {

        if(hour<dist.length-1)
            return -1;

        int maxSpeed = maxSpeed(dist,hour);
        //System.out.println(maxSpeed);
        if(maxSpeed<=0){
            return -1;
        }

        int f = 1;
        int l = maxSpeed;
        int c = f;
        int best = maxSpeed;
        while (true){

            int rst = isValid(dist,hour,c);
            if(rst==0){
                return c;
            }else if(rst>0){
                best = c;
                l = c-1;
                c = ((l+f)/2);
                //System.out.println("best : "+best);
            }else{
                f=c+1;
                c = ((f+l)/2);
            }
            //System.out.println(c);
            if(l<f){
                break;
            }
        }


        return best;
    }

    public static int maxSpeed(int []dist,double hour){

        double maxSpeed;

        int maxDistance=dist[0];
        for (int i = 1; i < dist.length; i++) {
            if(maxDistance<dist[i])
                maxDistance = dist[i];
        }

        maxSpeed = maxDistance;

        if(isValid(dist,hour, (long) maxSpeed)>=0){
            return (int) maxSpeed;
        }else{

            hour -= (dist.length-1);
            if(hour<=0)
                return -1;
            maxSpeed =  Math.max(dist[dist.length-1],(dist[dist.length-1]*1l/hour));


            return (int) Math.ceil(maxSpeed);
        }


    }


    // 0 : valid, 1 : valid but high, -1 : low
    public static int isValid(int[] dist, double hour,long speed){

        double time=0;
        //System.out.println("   " +speed);
        for (int i = 0; i < dist.length-1; i++) {
            double delta = Math.ceil(dist[i]*1d/speed);
            if(delta<1)
                delta=1;

            //System.out.println(delta);
            time += delta;
        }
        time += dist[dist.length-1]*1d/speed;
        //System.out.println(time);
        if(time>hour){
            return -1;
        }else if(time<hour){
            return 1;
        }else{
            return 0;
        }

    }



}
