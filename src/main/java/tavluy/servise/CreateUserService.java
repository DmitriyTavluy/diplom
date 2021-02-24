package tavluy.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tavluy.model.User;
import tavluy.repo.CreateUserRepo;

@Service
public class CreateUserService  {
    @Autowired
    private CreateUserRepo createUserRepo;

    @Transactional
    public Iterable<User> loadAllUsers(){
        return createUserRepo.findAll();
    }

    @Transactional
    public User saveUsers(User user){
        return createUserRepo.save(user);
    }

    @Transactional
    public void deleteUser(User user){
        createUserRepo.delete(user);
    }

    @Transactional
    public User loadUser(int id){
        return createUserRepo.findById(id);
    }
}
