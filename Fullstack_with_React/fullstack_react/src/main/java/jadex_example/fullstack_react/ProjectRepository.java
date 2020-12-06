package jadex_example.fullstack_react;
import org.springframework.data.repository.CrudRepository;

import domain.Project;


public interface ProjectRepository extends CrudRepository<Project, Long>{

}
