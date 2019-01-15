package com.stackroute.config;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.jboss.logging.Logger;


@Component
public class ApplicationListenerStartup implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logs = Logger.getLogger(ApplicationListenerStartup.class);
    private TrackRepository trackRepository;

    @Autowired
    public ApplicationListenerStartup(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        logs.info("Inserting data on start");

        Track trackOne = new Track(5,"When the night is over","Singer : Lord Huron");
        trackRepository.save(trackOne);
        Track trackTwo = new Track(6,"High on life","Singer : Bonn");
        trackRepository.save(trackTwo);

        logs.info("data successfully inserted");
    }
}
