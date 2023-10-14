/**
 * 
 */
package com.gusrubin.lab.springgenerallab.domain.freezingprotection;

/**
 * @author Gustavo Rubin
 *
 */
public class LongRunningTask implements Runnable {

    @Override
    public void run() {
	for (int i = 0; i < Long.MAX_VALUE; i++) {
//	    System.out.println(i);

	    if (Thread.interrupted()) {
		return;
	    }
	}
    }

}
