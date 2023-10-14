/**
 * 
 */
package com.gusrubin.lab.springgenerallab.domain.freezingprotection;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Gustavo Rubin
 *
 */
public class TimeOutTask extends TimerTask {

    private Thread thread;
    private Timer timer;

    public TimeOutTask(Thread thread, Timer timer) {
	this.thread = thread;
	this.timer = timer;
    }

    @Override
    public void run() {
	if (thread != null && thread.isAlive()) {
	    thread.interrupt();
	    timer.cancel();
	}
    }

}
