package org.example.dao;

import org.example.model.Movie;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDAOImpl implements MovieDAO {
    @Override
    public synchronized List<Movie> allMovies() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Movie> movies = (List<Movie>)session.createQuery("from Movie").list();
        session.close();
        return movies;
    }

    @Override
    public synchronized void add(Movie movie) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(movie);
        transaction.commit();
        session.close();
    }

    @Override
    public synchronized void delete(Movie movie) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(movie);
        transaction.commit();
        session.close();
    }

    @Override
    public synchronized void update(Movie movie) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(movie);
        transaction.commit();
        session.close();
    }

    @Override
    public synchronized Movie getById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Movie movie = session.get(Movie.class, id);
        session.close();
        return movie;
    }
}
