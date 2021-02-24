package tavluy.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tavluy.model.User;
@Repository
public interface CreateUserRepo extends CrudRepository<User, Integer> {
    User findById(int id);
}
