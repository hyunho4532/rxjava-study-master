package com.example.mvvmproject.ch02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class _L06_CounterSample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 순차적으로 값을 증가시키는 Count 객체
        final Counter counter = new Counter();

        // 10000번 계산하는 비동기 처리 작업
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };

        // 비동기 처리 작업 생성을 준비한다.
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 새로운 스레드로 시작한다.
        Future<Boolean> future1 = executorService.submit(task, true);
        Future<Boolean> future2 = executorService.submit(task, true);

        // 결과가 반환될 때까지 기다린다.
        if (future1.get() && future2.get()) {
            System.out.println(counter.get());
        } else {
            System.out.println("실패");
        }

        // 비동기 처리 작업 종료
        executorService.shutdown();
    }
}
