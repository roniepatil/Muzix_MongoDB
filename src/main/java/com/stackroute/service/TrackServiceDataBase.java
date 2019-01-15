package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceDataBase implements TrackService {
    @Autowired
    private TrackRepository trackRepository;
    private TrackServiceDataBase trackServiceDataBase;

    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public TrackServiceDataBase(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getTrackID()))
        {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track trackOne = trackRepository.save(track);
        if (trackOne==null)
        {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return trackOne;
    }

    @Override
    public List<Track> showAllTracks() {
        List <Track> trackOne = (List<Track>) trackRepository.findAll();
        return trackOne;
    }

    @Override
    public Track updateComment(Track track) throws TrackNotFoundException {
        if (trackRepository.existsById(track.getTrackID()))
        {
            Track trackOne = trackRepository.findById(track.getTrackID()).get();
            trackOne.setComments(track.getComments());
            trackRepository.save(trackOne);
            return trackOne;
        }
        else
        {
            throw new TrackNotFoundException("Track not found exception");
            //return null;
        }
    }

    @Override
    public boolean deleteTrack(Track track) throws TrackNotFoundException{
        //boolean answer = false;
        if (trackRepository.existsById(track.getTrackID()))
        {
            trackRepository.deleteById(track.getTrackID());
            return true;
        }
        else
        {
            throw new TrackNotFoundException("Track not found exception");
        }
        //return answer;
    }

//    @Override
//    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException{
//
//        List<Track> listOfTracks = null;
//        listOfTracks = trackRepository.getTrackByName(trackName);
//        if (listOfTracks.equals(null))
//        {
//            throw new TrackNotFoundException("Track not found exception");
//        }
//        return listOfTracks;
//    }
}
