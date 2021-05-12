package ir.iman.spring.kafka

import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class ProducerService (
        val kafkaTemplate : KafkaTemplate<String, String>
){

    private val logger = LoggerFactory.getLogger(javaClass.simpleName)
    private val topic1 = "topic1"
    private val topic2 = "topic2"

    fun sendMessageToTopic1(message: String ){
        this.kafkaTemplate.send(topic1, message)
        logger.info("$$$ -> Producing message --> $message")
    }

    fun sendMessageToTopic2(message: String ){
        this.kafkaTemplate.send(topic2, message)
        logger.info("$$$ -> Producing message --> $message")
    }
}