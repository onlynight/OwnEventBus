package com.github.onlynight.rxjavademo.event;

import com.github.onlynight.rxjavademo.LogUtils;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wyndam on 2017/12/27.
 * simple event bus demo
 */

public class EventBus {

    /**
     * subscribers
     */
    private List<WeakReference<Object>> subscribers;

    private static EventBus instance;

    public static EventBus getInstance() {
        if (instance == null) {
            instance = new EventBus();
        }
        return instance;
    }

    private EventBus() {
        this.subscribers = new ArrayList<>();
    }

    /**
     * register subscriber to event bus
     * @param subscriber event listener
     */
    public void registerSubscriber(Object subscriber) {
        if (subscriber != null) {
            subscribers.add(new WeakReference<>(subscriber));
        }
    }

    /**
     * unregister subscriber from event bus
     * @param subscriber event listener
     */
    public void unregisterSubscriber(Object subscriber) {
        if (subscriber != null) {
            Iterator<WeakReference<Object>> iterator = subscribers.iterator();
            Object obj = null;
            while (iterator.hasNext()) {
                obj = iterator.next();
                if (obj == subscriber) {
                    subscribers.remove(obj);
                    obj = null;
                    break;
                }
            }
        }
    }

    /**
     * post event from other component
     * @param event event data object
     */
    public void post(Object event) {
        if (event instanceof String) {
            LogUtils.D(event);
        }
        dispatchEvent(event);
    }

    /**
     * dispatch event inner
     * @param event event data object
     */
    private void dispatchEvent(Object event) {
        Iterator<WeakReference<Object>> iterator = subscribers.iterator();
        WeakReference<Object> obj;
        while (iterator.hasNext()) {
            obj = iterator.next();

            try {
                Method method = obj.get().getClass().getMethod("onEvent", Object.class);
                method.invoke(obj.get(), event);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
