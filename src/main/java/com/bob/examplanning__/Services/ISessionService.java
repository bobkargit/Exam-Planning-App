package com.bob.examplanning__.Services;

import com.bob.examplanning__.Models.ElementPedago;
import com.bob.examplanning__.Models.Session;

import java.util.List;

public interface ISessionService {
    public void addSession(Session elementPedago);

    public void updateSession(Session elementPedago);

    public List<Session> getAllSessions();

    public void deleteSession(Long id);

    public Session getSessionById(Long id);
}

