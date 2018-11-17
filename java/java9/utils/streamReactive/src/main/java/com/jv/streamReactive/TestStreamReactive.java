package com.jv.streamReactive;

import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;


/**
 * Example of streamReactive found on
 * http://www.loicmathieu.fr/wordpress/informatique/les-nouveautes-de-java-9-pour-les-developeurs/
 */
public class TestStreamReactive {

    private static void publish(SubmissionPublisher<String> publisher){
        //Publish items
        System.out.println("Publishing Items...");
        String[] items = {"1", "x", "2", "x", "3", "x"};
        Arrays.asList(items).forEach(publisher::submit);
        publisher.close();
    }

    public static void main(String args[]) throws InterruptedException {

        //Create Publisher
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        //Register Subscriber
        MySubscriber<String> subscriber = new MySubscriber<>();
        MySubscriber<String> subscriber2 = new MySubscriber<>();
        MySubscriber<String> subscriber3 = new MySubscriber<>();

        publisher.subscribe(subscriber);
        publisher.subscribe(subscriber2);
        publisher.subscribe(subscriber3);

        publish(publisher);

        Thread.sleep(1000);

        //Rmq : we wan't put the same subscriber in a publisher -> throws IllegalArgumentException.
    }
}
