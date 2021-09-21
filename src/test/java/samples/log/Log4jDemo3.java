package samples.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo3 {
    private static Logger logger = LogManager.getLogger(Log4jDemo3.class.getName());

    public static void main (String[] args){
        logger.trace("Log4jDemo3 - Tracing log");
        logger.debug("Log4jDemo3 - I am debugging");
        logger.info("Log4jDemo3 - Good test step");
        logger.error("Log4jDemo3 - Error step happens");
        logger.fatal("Log4jDemo3 - Fatal step happens");
    }
}
