package com.jv.streamReactive;

import java.util.concurrent.Flow;

/**
 * Example of streamReactive found on
 * http://www.loicmathieu.fr/wordpress/informatique/les-nouveautes-de-java-9-pour-les-developeurs/
 */
public class MySubscriber<T> implements Flow.Subscriber<T> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1); //a value of Long.MAX_VALUE may be considered as effectively unbounded
    }

    @Override
    public void onNext(T item) {
        System.out.println("Got : " + item);
        subscription.request(1); //a value of Long.MAX_VALUE may be considered as effectively unbounded
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}