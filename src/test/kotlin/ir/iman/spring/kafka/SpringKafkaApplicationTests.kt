package ir.iman.spring.kafka

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

@SpringBootTest
@AutoConfigureMockMvc
class SpringKafkaApplicationTests(@Autowired private val mockMvc: MockMvc) {

	@Test
	@Throws(Exception::class)
	fun publishSingleTopic() {
		for (i in 0..999) mockMvc.perform(MockMvcRequestBuilders.post("/kafka/publish/topic1")
				.contentType(MediaType.APPLICATION_JSON).param("message", "message $i"))
	}

	@Test
	@Throws(java.lang.Exception::class)
	fun publishIn2TopicConcurrently() {
		val t1 = Thread(Runnable {
			for (i in 0..999) {
				mockMvc.perform(MockMvcRequestBuilders.post("/kafka/publish/topic1")
						.contentType(MediaType.APPLICATION_JSON).param("message", "message $i"))
			}
		})
		val t2 = Thread(Runnable {
			for (i in 0..999) {
				mockMvc.perform(MockMvcRequestBuilders.post("/kafka/publish/topic2")
						.contentType(MediaType.APPLICATION_JSON).param("message", "message $i"))
			}
		})
		t1.start()
		t2.start()
		t1.join()
		t2.join()
	}

}
