package com.gusrubin.lab.springgenerallab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.internal.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Gustavo Rubin
 */

@ExtendWith(MockitoExtension.class)
class SpringGeneralLabApplicationTests {

    final Logger log = LoggerFactory.getLogger(SpringGeneralLabApplicationTests.class);

    @Test
    void getDetailMessageOfAnExceptionTest1() {
	log.info("getDetailMessageOfAnExceptionTest");

	int number = 10;
	int divisionResult;

	try {
	    divisionResult = number / 0;
	    log.info("Division result = {}", divisionResult);

	} catch (Exception e) {
	    log.error("Error on division. getMessage={}", e.getMessage());
	    log.error("Error on division. getLocalizedMessage={}", e.getLocalizedMessage());
	}

	Assert.isTrue(true);
    }

    class ExceptionTest1 extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String message;

	/**
	 * @param message
	 */
	public ExceptionTest1(String message) {
	    super(message);
	    this.message = message;
	}
    }

    class TestClass {
	private final String msg;

	public TestClass(String msg) {
	    this.msg = msg;
	}

	public String getMsg(boolean withException) {
	    if (withException) {
		throw new ExceptionTest1("error");
	    }

	    return this.msg;
	}

    }

    @Test
    void getDetailMessageOfAnExceptionTest2() {
	log.info("getDetailMessageOfAnExceptionTest");

	try {
	    TestClass test = new TestClass("bla");
	    test.getMsg(true);

	} catch (Exception e) {
	    log.error("getMessage={}", e.getMessage());
	}

	Assert.isTrue(true);
    }

}
