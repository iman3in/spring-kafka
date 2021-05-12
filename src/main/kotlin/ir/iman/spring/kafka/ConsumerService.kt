package ir.iman.spring.kafka

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ConsumerService {
    private val logger = LoggerFactory.getLogger(ConsumerService::class.java)

    @KafkaListener(topics = ["topic1"], groupId = "group")
    fun consumeTopic1(message: String?) {
        logger.info("$$$ -> Consumed Message in Topic1 -> $message")
    }

    @KafkaListener(topics = ["topic2"], groupId = "group")
    fun consumeTopic2(message: String?) {
        logger.info("$$$ -> Consumed Message in Topic2 -> $message")
    }
}