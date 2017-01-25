package com.invest.core.web;

import com.invest.core.util.Util_Logger;
import org.openqa.selenium.TimeoutException;

/**
 * Created by Tester3 on 30.09.2015.
 */
public class Wait<T extends Component<T>> {
    public static final int DEFAULT_TIMEOUT = 40000;
    public static final int DEFAULT_RETRY_DELAY = 10000;
    private T component;

    public Wait() {

    }

    public Wait<T> forComponent(T component) {
        this.component = component;
        Util_Logger.info("component wait and find  for class " + component.getClass().getName());
        return this;
    }

    public T toBeAvailable() {
        int timePassed = 0;
        while (timePassed < DEFAULT_TIMEOUT) {
            Util_Logger.info("Trying to get element isAvailable in while loop ");
            if (this.component.isAvailable()) {
                Util_Logger.info("ALL COMPONENTS ARE AVAILABLE FOR:" + this.component.getClass().getSimpleName());
                return this.component;
            }
            timePassed = timePassed + delay();
            Util_Logger.info("Time passed for waiting elements: " + timePassed);
        }
        if (!this.component.isAvailable()) {
            Util_Logger.error("ALL COMPONENT ARE NOT AVAILABLE FOR:" + this.component.getClass().getSimpleName());
            throw new TimeoutException("Timed out after " + DEFAULT_TIMEOUT + " waiting for component " + this.component.getClass().getSimpleName());
        }
        return this.component;
    }

    private int delay() {
        try {
            Util_Logger.info("Sleep " + DEFAULT_RETRY_DELAY + " time for wait elements");
            Thread.sleep(DEFAULT_RETRY_DELAY);
            return DEFAULT_RETRY_DELAY;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

    }
}
