package tavluy.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tavluy.model.User;
import tavluy.repo.UserRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SendMail mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    @Transactional
    public Iterable<User> loadAllUsers(){
        return userRepo.findAll();
    }

    @Transactional
    public User saveUsers(User user){
        return userRepo.save(user);
    }

    @Transactional
    public void deleteUser(User user){
        userRepo.delete(user);
    }

    @Transactional
    public List<User> loadUserByActive(boolean active){
        return  userRepo.findByActive(active);
    }

    @Transactional
    public User loadUserById(int id){
        return userRepo.findById(id);
    }

    @Transactional
    public void leaveAnswer(User user){
        mailSender.send(user.getMail(), "Остатки", String.format("Ваш отчет!.", user.getUsername()));
    }
}
