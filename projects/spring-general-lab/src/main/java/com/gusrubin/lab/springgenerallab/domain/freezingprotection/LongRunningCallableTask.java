/**
 * 
 */
package com.gusrubin.lab.springgenerallab.domain.freezingprotection;

import java.util.concurrent.Callable;

/**
 * @author Gustavo Rubin
 *
 */
public class LongRunningCallableTask implements Callable<String> {

    @Override
    public String call() throws Exception {

//	for (int i = 0; i < Long.MAX_VALUE; i++) {
	for (long i = 0; i < 0x00000f0000000L; i++) {

	    if (Thread.interrupted()) {
		System.out.println("thread interrupted");
	    }
	}

	return "completou";
    }

}
