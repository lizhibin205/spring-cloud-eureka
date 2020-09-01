import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

def defaultLogLevel = INFO
def appenderList = []

context.name = "eureka-server"

appender("ROLLING", RollingFileAppender) {
    file = "/apps/logs/log_receiver/eureka-server/application.log"
    encoder(PatternLayoutEncoder) {
        pattern = "[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%level] [%thread] [%logger{50}] >>> %msg%n"
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "/apps/logs/log_receiver/eureka-server/application.%d{yyyy-MM-dd}.log"
        maxHistory = 7
    }
}
appender("ROLLING-ASYNC", AsyncAppender) {
    discardingThreshold = 2
    queueSize = 1024
    neverBlock = true
    appenderRef("ROLLING")
}

appenderList.add("ROLLING-ASYNC");

logger("com.bytrees", defaultLogLevel, appenderList, false)