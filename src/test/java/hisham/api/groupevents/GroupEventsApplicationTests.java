package hisham.api.groupevents;

import hisham.api.groupevents.model.GroupEvent;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
class GroupEventsApplicationTests {
	@Test
	void create_new_record_group_event() {
		GroupEvent event = new GroupEvent(
				UUID.randomUUID().toString(),
				"Demo Event",
				"Hey this is just for testing",
				LocalDateTime.of(2022,4,23,11,30),
				LocalDateTime.of(2022,4,23,12,30));

		assertNotNull(event);
		assertEquals("Demo Event", event.title(), "Wrong title");
	}
}
