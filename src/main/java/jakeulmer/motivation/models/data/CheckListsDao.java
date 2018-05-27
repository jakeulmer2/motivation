package jakeulmer.motivation.models.data;

import jakeulmer.motivation.models.forms.CheckLists;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CheckListsDao extends CrudRepository<CheckLists, Integer>{
}
