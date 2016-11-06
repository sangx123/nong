package com.taixia.nong.http.retrofit;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/8/30.
 */
public class IsUnsubScribedOperator<T extends ResponseResult> implements Observable.Operator<T,T> {

    @Override
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>() {
            @Override
            public void onCompleted() {
                if(!subscriber.isUnsubscribed()){
                    subscriber.onCompleted();
                }
            }

            @Override
            public void onError(Throwable e) {
                if(!subscriber.isUnsubscribed()){
                    subscriber.onError(e);
                }
            }

            @Override
            public void onNext(T t) {
                if(!subscriber.isUnsubscribed()){
                    if(t.getStatus()==1){
                        subscriber.onNext(t);
                        subscriber.onCompleted();
                        return;
                    }
                    subscriber.onError(new BaseValueInvalidException(t));
                }
            }
        };
    }
}
