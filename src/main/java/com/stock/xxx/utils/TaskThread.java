package com.stock.xxx.utils;

/**
 * Created by JiYanLong on 2017/4/12.
 */
public abstract class TaskThread extends Thread{

    private boolean live = true;
    private long time = 0;

    public TaskThread(long time){
        this.time = time;
    }

    private TaskThread(){}

    @Override
    public void run() {
        while (live){
            task();
            try {
                if(time > 0){
                    Thread.sleep(time);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void kill(){
        this.live = false;
    }

    protected abstract void task();



    public static void main(String args[]) throws InterruptedException {

        TaskThread t1 = new TaskThread(2000) {

            @Override
            protected void task() {
                System.out.println("xxx");
            }
        };

        t1.start();
        Thread.sleep(1000);
        t1.kill();
    }
}


