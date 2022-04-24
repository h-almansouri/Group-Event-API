package hisham.api.groupevents.model;

import java.time.LocalDateTime;

public record GroupEvent(String id, String title, String description, LocalDateTime startDate, LocalDateTime endDate) {
}
