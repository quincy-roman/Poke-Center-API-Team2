package com.revature.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Patient;
import com.revature.model.Pokemon;
import com.revature.model.StatusCondition;
import com.revature.model.Trainer;
import com.revature.repository.TrainerRepo;

@Repository("trainerRepo")
@Transactional
public class TrainerRepoImpl implements TrainerRepo {

//	private static Logger log = Logger.getLogger(TrainerRepoImpl.class);

	@Autowired
	private SessionFactory sf;

	Criteria crit;

	@Override

	public void save(Trainer trainer) throws PSQLException {
		try {
			sf.getCurrentSession().save(trainer);
		} catch (DataIntegrityViolationException e) {
			System.out.println("history already exist 1");
		} catch (ConstraintViolationException e) {
			System.out.println("history already exist 2");
		}

	}

	@Override
	public void save(Patient patient) {
		sf.getCurrentSession().save(patient);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Trainer getTrainerId(int trainer) {
		try {
			crit = sf.getCurrentSession().createCriteria(Trainer.class);
			crit.add(Restrictions.idEq(trainer));
			List<Trainer> t = crit.list();
			return t.get(0);
		} catch (IndexOutOfBoundsException e) {
		return null;

		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public StatusCondition getStatus(int statusId) {
		try {
			crit = sf.getCurrentSession().createCriteria(StatusCondition.class);
			crit.add(Restrictions.idEq(statusId));
			List<StatusCondition> status = crit.list();
			return status.get(0);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Pokemon getPokemon(String Pokemon) {
		try {
			crit = sf.getCurrentSession().createCriteria(Pokemon.class);
			crit.add(Restrictions.ilike("name", Pokemon, MatchMode.EXACT));
			List<Pokemon> p = crit.list();
			return p.get(0);
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public StatusCondition problem(String string) {
		try {
			crit = sf.getCurrentSession().createCriteria(StatusCondition.class);
			crit.add(Restrictions.ilike("statusName", string));
			List<StatusCondition> status = crit.list();
			return status.get(0);
		} catch (IndexOutOfBoundsException e) {

		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getPatient(Trainer trainer) { // Changed fetch to eager to work
		crit = sf.getCurrentSession().createCriteria(Patient.class);
		crit.add(Restrictions.eq("trainer", trainer));
		List<Patient> p = crit.list();
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Trainer getProfile(Trainer trainer) {
		try {
			crit = sf.getCurrentSession().createCriteria(Trainer.class);
			crit.add(Restrictions.idEq(trainer.getTrainerId()));
			List<Trainer> t = crit.list();
			return t.get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public Trainer updateProfile(Trainer trainer) {
		sf.getCurrentSession().evict(trainer);

		sf.getCurrentSession().update(trainer);
		return trainer;
	}

}
