package jakeulmer.motivation.models.data;

import jakeulmer.motivation.models.forms.Tracker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TrackerDao extends CrudRepository<Tracker, Integer> {
}
