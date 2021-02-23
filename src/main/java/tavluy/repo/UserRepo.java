package tavluy.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tavluy.model.User;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
   List<User> findByActive(boolean active);
    User findById(int id);
}
