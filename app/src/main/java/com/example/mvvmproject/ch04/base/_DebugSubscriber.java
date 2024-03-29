package com.example.mvvmproject.ch04.base;

import io.reactivex.rxjava3.subscribers.DisposableSubscriber;

public class _DebugSubscriber<T> extends DisposableSubscriber<T> {
    private String label;

    public _DebugSubscriber() {
        super();
    }

    public _DebugSubscriber(String label) {
        super();
        this.label = label;
    }

    @Override
    public void onNext(T data) {
        String threadName = Thread.currentThread().getName();

        if (label == null) {
            System.out.println(threadName + ":" + data);
        } else {
            System.out.println(threadName + ":" + label + ":" + data);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        String threadName = Thread.currentThread().getName();

        if (label == null) {
            System.out.println(threadName + ": 에러=" + throwable);
        } else {
            System.out.println(threadName + ":" + label + ": 에러=" + throwable);
        }
    }

    @Override
    public void onComplete() {
        String threadName = Thread.currentThread().getName();

        if (label == null) {
            System.out.println(threadName + " : 완료");
        } else {
            System.out.println(threadName + ": " + label + ": 완료");
        }
    }
}