package com.example.Second_homework.event;



import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class EventHolderListener {

    @EventListener
    public void listen(EventHolder eventHolder){

        Logger logger = Logger.getLogger(EventHolderListener.class.getName());

        logger.info(eventHolder.getEvent().getPayload());

    }

}
