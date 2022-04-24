package hisham.api.groupevents.repository;

import hisham.api.groupevents.model.GroupEvent;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class GroupEventRepository {

    List<GroupEvent> events = new ArrayList<>();

    public GroupEventRepository() {
        events.add(new GroupEvent(
                UUID.randomUUID().toString(),
                "Demo Event",
                "Hey this is just for testing",
                LocalDateTime.of(2022,4,23,11,30),
                LocalDateTime.of(2022,4,23,12,30)
        ));
    }

    public List<GroupEvent> findAll() {
        return events;
    }

    public GroupEvent findById(String id) throws Exception {
        return events.stream().filter(event -> event.id().equals(id)).findFirst().orElseThrow(() -> new Exception("Event not found"));
    }

    public GroupEvent create(GroupEvent event) {
        events.add(event);
        return event;
    }

    public void update(GroupEvent event, String id) {
        GroupEvent existing = events.stream().filter(e -> e.id().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("Event not found"));
        int i = events.indexOf(existing);
        events.set(i, event);
    }

    public void delete(String id) {
        events.removeIf(event -> event.id().equals(id));
    }
}
