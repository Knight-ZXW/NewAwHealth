package com.think.awhealth.rxbus;


import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by XiuWuZhuo on 2016/2/13.
 * Emial:nimdanoob@163.com
 */
public class RxBus {
    private final Subject<Object,Object> _bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o){
        _bus.onNext(o);
    }
    public Observable<Object> toObserverable(){
        return _bus;
    }
}
