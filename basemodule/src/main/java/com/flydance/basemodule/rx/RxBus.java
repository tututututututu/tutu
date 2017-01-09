package com.flydance.basemodule.rx;


import android.util.Log;

import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

public final class RxBus {
    private static final String TAG = RxBus.class.getSimpleName();
    private static final String suffix = "_sticky";
    private static ConcurrentHashMap<String, Subject> subjectMapper = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Object> eventStickyMapper = new ConcurrentHashMap<>();

    private RxBus() {
    }

	/**
     *注册事件
     * @param clazz 事件类型
     * @param <T>
     * @return 被观察者
     */
    public static <T> Observable<T> obtainEvent(Class<T> clazz) {
        Subject<T, T> subject = subjectMapper.get(clazz.getName());
        if (subject == null) {
            subject = PublishSubject.create();
            subjectMapper.put(clazz.getName(), subject);
        }
        return subject;
    }


	/**
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Observable<T> obtainStickyEvent(Class<T> clazz) {
        Subject subject = subjectMapper.get(clazz.getName() + suffix);
        if(subject == null) {
            subject = BehaviorSubject.create();
            subjectMapper.put(clazz.getName() + suffix,subject);
        }
        return subject;
    }

    public static <T> T obtainStickyObject(Class<T> clazz) {
        Object o = eventStickyMapper.get(clazz.getName());
        if(o == null) {
            try {
                o = clazz.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(clazz.getName() + "--没有默认的构造函数");
            }
            eventStickyMapper.put(clazz.getName(),new SoftReference<Object>(o));
        }
        return (T) o;
    }

    public static void recycleEvent(Class<?> clazz) {
        subjectMapper.remove(clazz.getName());
    }

    public static void recycleStickyEvent(Class<?> clazz) {
        if(subjectMapper.remove(clazz.getName()+suffix) != null) {
            eventStickyMapper.remove(clazz.getName() + suffix);
        }
    }

    public static <T> void postEvent(T o,Class<? super T> clazz) {
//        L.i("--postEvent", clazz.getName(), new Throwable());
        Subject subject = subjectMapper.get(clazz.getName());
        if(subject != null) {
            Log.i("rx","onnext");
            subject.onNext(o);
        }
    }

    public static <T> void postStickyEvent(T o,Class<? super T> clazz) {
//        L.i("--postStickyEvent:", clazz.getName(), new Throwable());
        String name = clazz.getName();
        eventStickyMapper.put(name,o);
        Subject subject = subjectMapper.get(name + suffix);
        if(subject == null) {
            subject = BehaviorSubject.create();
            subjectMapper.put(clazz.getName() + suffix,subject);
        }
        subject.onNext(o);
    }
}


