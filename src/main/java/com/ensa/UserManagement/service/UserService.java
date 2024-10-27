package com.ensa.UserManagement.service;

import com.ensa.UserManagement.model.User;
import com.ensa.UserManagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

@AllArgsConstructor
public class UserService {
    private final UserRepository userrepository ;
    public User create(User user){
        return userrepository.save(user) ;
    }
    public User modifier(Long id, User user) {
        return userrepository.findById(id)
                .map(p -> {
                    p.setNom(user.getNom());
                    p.setEmail(user.getEmail());
                    p.setPassword(user.getPassword());
                    // Ajouter d'autres champs si nécessaire
                    return userrepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("User non trouvé avec l'ID : " + id));
    }
    public List<User> lire(){
        return userrepository.findAll() ;
    }
    public String delete(Long id ){
        userrepository.deleteById(id);
        return "user supprimé" ;
    }

}
