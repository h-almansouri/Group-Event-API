package hisham.api.groupevents.controller;

import hisham.api.groupevents.model.GroupEvent;
import hisham.api.groupevents.repository.GroupEventRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/events")
public class GroupEventsController {

    private final GroupEventRepository repository;

    public GroupEventsController(GroupEventRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<GroupEvent> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public GroupEvent findById(@PathVariable String id) throws Exception {
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public GroupEvent create(@Valid @RequestBody GroupEvent event) {
        return repository.create(event);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody GroupEvent event, @PathVariable String id) {
        repository.update(event, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }
}
