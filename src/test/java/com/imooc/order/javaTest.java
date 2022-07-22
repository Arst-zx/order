package com.imooc.order;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;


/**
 * @Author: 章鑫
 * @Project_name：java_project
 * @Name: javaTest
 * @Create: 2019-01-14 14:54
 * @Description:
 **/

class demo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("zhangx511");
        arrayList.add("22");
        System.out.println(arrayList);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("章鑫");
        linkedList.add("年龄");
        System.out.println(linkedList);

        Map<String,String> map = new HashMap<>();
        map.put("姓名","章鑫");
        map.put("年龄","28");
        map.put("123","123");
        System.out.println(map);

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("姓名","章鑫");
            jsonObject.put("年龄","24");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject.toString());

        JSONArray jsonArray = new JSONArray();
        jsonArray.put("章鑫");
        jsonArray.put("28");
        jsonArray.put(jsonObject);
        System.out.println(jsonArray.toString());

    }
}

interface ReadWriteLock{
    /**
     * Returns the lock used for reading
     * @return the lock used for reading
     */
    Lock readLock();

    /**
     * Returns the lock used fro writing
     * @return the lock used for writing
     */
    Lock writeLock();
}

class ReentrantReadWriteLockTest {
    public static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        newCachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                // readFile(Thread.currentThread());
                writeFile(Thread.currentThread());
            }
        });

        newCachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                writeFile(Thread.currentThread());
                // readFile(Thread.currentThread());
            }
        });

    }

    public static void readFile (Thread thread) {
        reentrantReadWriteLock.readLock().lock();
        boolean writeLock = reentrantReadWriteLock.isWriteLocked();
        if (!writeLock) {
            System.out.println("线程：" + thread.getName() + " 当前为读锁！");
        }

        try {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                System.out.println("线程：" + thread.getName() + "正在进行读操作！");
            }
            System.out.println("线程：" + thread.getName() + "读操作结束！");
        } finally {
            System.out.println("线程：" + thread.getName() + "释放读锁！");
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    public static void writeFile (Thread thread) {
        reentrantReadWriteLock.writeLock().lock();
        boolean writeLock = reentrantReadWriteLock.isWriteLocked();
        if (writeLock) {
            System.out.println("线程：" + thread.getName() + "当前为写锁！");
        }

        try {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                System.out.println("线程：" + thread.getName() + "正在进行写操作！");
            }
            System.out.println("线程：" + thread.getName() + "写操作结束！");
        } finally {
            System.out.println("线程：" + thread.getName() + "释放写锁！");
            reentrantReadWriteLock.writeLock().unlock();
        }
    }




    /*public static void get (Thread thread) {
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间：" + startTime);
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantReadWriteLock.readLock().lock();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.out.println(thread.getName() + ":正在进行读操作!");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("结束时间：" + endTime);
        System.out.println("总共用时：" + (endTime - startTime));
    }

    public static void main(String[] args) throws InterruptedException{
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                get(Thread.currentThread());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                get(Thread.currentThread());
            }
        });

        thread1.start();
        thread2.start();
    }*/
    /*public synchronized static void get(Thread thread) {
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间：" + startTime);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.out.println(thread.getName() + ":正在进行读操作!");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("结束时间：" + endTime);
        System.out.println(endTime - startTime);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                get(Thread.currentThread());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                get(Thread.currentThread());
            }
        });

        thread1.start();
        thread2.start();

        *//*final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantReadWriteLock.writeLock().lock();
        System.out.println("获取写锁！");
        reentrantReadWriteLock.readLock().lock();
        System.out.println("获取读锁！");*//*

        *//*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantReadWriteLock.writeLock().lock();
                System.out.println("线程1启动！");
                reentrantReadWriteLock.writeLock().unlock();
            }
        });

        reentrantReadWriteLock.writeLock().lock();
        reentrantReadWriteLock.writeLock().lock();
        thread.start();
        Thread.sleep(200);

        System.out.println("线程跑一次！");
        reentrantReadWriteLock.writeLock().unlock();
        reentrantReadWriteLock.writeLock().unlock();*//*
    }*/
}



public class javaTest {
    private String name;
    public javaTest(String name){
        this.name = name;
    }

    public static void main(String[] args) {

        javaTest a = new javaTest("aaa");
        javaTest b = new javaTest("aaa");
        javaTest c = a;
        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println(a.name.equals(b.name));
        System.out.println(a.equals(c));
        System.out.println(a.name.equals(c.name));

        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add(" World");
        list.add("!");
        System.out.println(list);

        Iterator iterator = list.iterator();
        System.out.println(iterator);

        while (iterator.hasNext()){
            String string = (String) iterator.next();
            System.out.println(string);
        }

        ListIterator<String> listIterator = list.listIterator();

        System.out.println(listIterator);

        while (listIterator.hasPrevious()){
            String string2 = listIterator.previous();
            System.out.println("111111111111111" + string2);
        }

        for (String str:list) {
            System.out.println(str);
        }

        Collections.addAll(list,"Hello zhangx511!");
        System.out.println(list);

        int[] arrays = {3,7,1,9,2,4};
        javaTest.quickSort(arrays,0,5);
        /*for (int num:arrays) {
            System.out.println(num);
        }*/
    }

    public static boolean checkEmail(String email) {
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        return Pattern.matches(regex, email);
    }

    public static void insertSort(int[] array){
        int arrayLenth = array.length;
        for(int i = 1; i < arrayLenth; i++){
            int temp = array[i];
            while(i >= 1 && array[i-1] > temp){
                array[i] = array[i-1];
                i--;
            }
            array[i] = temp;
        }
    }


    static void quickSort(int a[], int left, int right) {
        int i, j, t, temp;
        if(left >= right)
            return;
        temp = a[left]; //temp中存的就是基准数
        i = left;
        j = right;

        while(i < j) { //顺序很重要，要先从右边开始找 {3,7,1,9,2,4} i=0,j=5
            while(a[j] >= temp && i < j){
                j--;
            }
            System.out.println("j = " + j);
            while(a[i] <= temp && i < j){
                i++;
            }//再找右边的
            System.out.println("i = " + i);
            System.out.print("a[i] = " + a[i]);
            System.out.println(",a[j] = " + a[j]);
            if(i < j)//交换两个数在数组中的位置 {4,7,1,9,2,3} i=1,j=4,{4,7,9,1,2,3}i=2,j=3
            {
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
            System.out.print(a[0]);
            System.out.print(a[1]);
            System.out.print(a[2]);
            System.out.print(a[3]);
            System.out.print(a[4]);
            System.out.println(a[5]);
        }
        //最终将基准数归位
        a[left] = a[i];
        a[i] = temp;
        quickSort(a,left, i-1);//继续处理左边的，这里是一个递归的过程
        quickSort(a,i+1, right);//继续处理右边的 ，这里是一个递归的过程
    }
}

