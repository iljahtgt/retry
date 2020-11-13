package model;
// Generated 2020�~11��4�� �U��2:58:13 by Hibernate Tools 5.4.21.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;


import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Coffees.
 * @see model.Coffees
 * @author Hibernate Tools
 */
public class CoffeesHome {

	private static final Logger logger = Logger.getLogger(CoffeesHome.class.getName());

	private final static SessionFactory sessionFactory = getSessionFactory();

	protected static SessionFactory getSessionFactory() {
		try {
			return  new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Error Open Config:"+e.getMessage());
			return null;
		}
	}

	public void persist(Coffees transientInstance) {
		logger.log(Level.INFO, "persisting Coffees instance");
		Session  ss=  sessionFactory.openSession();
		try {
			Transaction tx=ss.beginTransaction();
			ss.persist(transientInstance);
			tx.commit();
			logger.log(Level.INFO, "persist successful");
		} catch (Exception re) {
			logger.log(Level.SEVERE, "persist failed", re);			
		}finally {
			ss.close();
		}
	}

	public void attachDirty(Coffees instance) {
		logger.log(Level.INFO, "attaching dirty Coffees instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(Coffees instance) {
		logger.log(Level.INFO, "attaching clean Coffees instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(Coffees persistentInstance) {
		logger.log(Level.INFO, "deleting Coffees instance");
		Session ss=sessionFactory.openSession();
		try {
			Transaction tx=ss.beginTransaction();
			ss.delete(persistentInstance);
			tx.commit();
			//sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}finally {
			ss.close();
		}
	}

	public Coffees merge(Coffees detachedInstance) {
		logger.log(Level.INFO, "merging Coffees instance");
		Session  ss=  sessionFactory.openSession();
		try {
			//Coffees result = (Coffees) sessionFactory.getCurrentSession().merge(detachedInstance);
			Transaction tx=ss.beginTransaction();
			Coffees result = (Coffees)ss.merge(detachedInstance);
			tx.commit();
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}finally {
			ss.close();
		}
		
	}

	public Coffees findById(java.lang.String cofName) {
		logger.log(Level.INFO, "getting Coffees instance with cofName: " + cofName);
		Session ss=sessionFactory.openSession();
		try {
			Transaction tx=ss.beginTransaction();
			Coffees instance = (Coffees) ss.get("model.Coffees", cofName);
			tx.commit();
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}finally {
			ss.close();
		}
	}

	public List findByExample(Coffees instance) {
		logger.log(Level.INFO, "finding Coffees instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("model.Coffees")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
