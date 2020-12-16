package com.revature.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.QueryException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Patient;
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
	public void save(Trainer trainer) {
		sf.getCurrentSession().save(trainer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean loginTrainer(String username, String password) {
		try {
			crit = sf.getCurrentSession().createCriteria(Trainer.class);
			crit.add(Restrictions.ilike("username", username, MatchMode.EXACT));
			crit.add(Restrictions.like("password", password, MatchMode.EXACT));

			List<Trainer> trainer = crit.list();
			System.out.println(trainer);

			if (trainer.get(0) != null) {
				return true;
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println("FAIL 1");
			return false;
		} catch (QueryException e) {
			System.out.println("FAIL 3");
			return false;
		}
		return false;
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
		crit = sf.getCurrentSession().createCriteria(Trainer.class);
		crit.add(Restrictions.idEq(trainer.getTrainerId()));
		List<Trainer> t = crit.list();
		return t.get(0);
	}

	@Override
	public Trainer updateProfile(Trainer trainer) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().evict(trainer);

		sf.getCurrentSession().update(trainer);
		return trainer;
	}
}
