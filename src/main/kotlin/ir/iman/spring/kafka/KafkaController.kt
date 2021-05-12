package ir.iman.spring.kafka

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kafka")
class KafkaController (
    private val producerService : ProducerService
){

    @PostMapping("/publish/topic1")
    fun sendMessageToKafkaTopic1(@RequestParam message :String ){
        this.producerService.sendMessageToTopic1(message)
    }

    @PostMapping("/publish/topic2")
    fun sendMessageToKafkaTopic2(@RequestParam message :String ){
        this.producerService.sendMessageToTopic2(message)
    }


}