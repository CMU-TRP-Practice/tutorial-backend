package se331.lab.rest.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.EventDTO;
import se331.lab.rest.service.EventService;

@Component
public class QueryQL implements GraphQLQueryResolver {
    String helloWorld() {
        return "Hello World";
    }

    @Autowired
    EventService eventService;

    EventDTO getEvent() {
        Event event = eventService.getEvent(1l);
        return EventDTO.builder()
                .id(event.getId())
                .category(event.getCategory())
                .time(event.getTime()).title(event.getTitle())
                .description(event.getDescription())
                .build();
    }
}
