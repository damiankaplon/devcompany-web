package pl.damiankaplon.devcompanyweb.service.exception;

import org.hibernate.Session;

public class PeselAlreadyInDb extends Throwable {
    public PeselAlreadyInDb(Session session) {
        session.close();
    }
}
