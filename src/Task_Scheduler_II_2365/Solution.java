package Task_Scheduler_II_2365;

import java.util.HashMap;

public class Solution {




    public static void main(String[] args) {


        System.out.println(taskSchedulerII(new int[]{5,8,8,5},2));

    }


    public static long taskSchedulerII(int[] tasks, int space) {

        HashMap<Integer,Cooldown> cooldowns = new HashMap<>();

        long time = 0;
        for (int i = 0; i < tasks.length; i++) {

            time++;
            if(!cooldowns.containsKey(tasks[i])){
                cooldowns.put(tasks[i],new Cooldown(space,time));
            }else{
                Cooldown cd = cooldowns.get(tasks[i]);
                int rt = cd.remainderTime(time);
                if(rt>=0){
                    time+=(1+rt);
                }
                cd.reset(space,time);
            }

        }

        return time;
    }


    private static class Cooldown{

        public int waitTime;
        public long lastUpdateTime;

        public Cooldown(int waitTime, long lastUpdateTime) {
            this.waitTime = waitTime;
            this.lastUpdateTime = lastUpdateTime;
        }

        public int remainderTime(long currentTime){
            long elapsedTime = currentTime-lastUpdateTime;
            waitTime-=elapsedTime;
            lastUpdateTime = currentTime;
            return waitTime;
        }

        public void reset(int waitTime,long lastUpdateTime){
            this.waitTime = waitTime;
            this.lastUpdateTime = lastUpdateTime;
        }

    }


}
