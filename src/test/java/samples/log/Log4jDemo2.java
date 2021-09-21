package samples.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo2 {
    private static Logger logger = LogManager.getLogger(Log4jDemo2.class.getName());

    public static void main (String[] args){
        logger.trace("Log4jDemo2 - Tracing log");
        logger.debug("Log4jDemo2 - I am debugging");
        logger.info("Log4jDemo2 - Good test step");
        logger.error("Log4jDemo2 - Error step happens");
        logger.fatal("Log4jDemo2 - Fatal step happens");
    }
}
