package samples.log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4jDemo {

    private static Logger logger = LogManager.getLogger(Log4jDemo.class.getName());

    public static void main (String[] args){
        logger.trace("Log4jDemo - Tracing log");
        logger.debug("Log4jDemo - I am debugging");
        logger.info("Log4jDemo - Good test step");
        logger.error("Log4jDemo - Error step happens");
        logger.fatal("Log4jDemo - Fatal step happens");
    }
}
