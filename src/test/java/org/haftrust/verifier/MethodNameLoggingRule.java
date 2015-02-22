package org.haftrust.verifier;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodNameLoggingRule extends TestWatcher {

    private static final Logger LOG = LoggerFactory.getLogger(MethodNameLoggingRule.class);

    @Override
    protected void starting(final Description description) {
        LOG.info("Starting test {}", description.getMethodName());
    }
}
