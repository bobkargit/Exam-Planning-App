package com.bob.examplanning__.Services.Impl;


import com.bob.examplanning__.Models.Session;
import com.bob.examplanning__.Repository.SessionRepository;
import com.bob.examplanning__.Services.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService implements ISessionService {
    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public void addSession(Session elementPedago) {

    }

    @Override
    public void updateSession(Session elementPedago) {

    }

    @Override
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    @Override
    public void deleteSession(Long id) {

    }

    @Override
    public Session getSessionById(Long id) {
        return null;
    }
}
