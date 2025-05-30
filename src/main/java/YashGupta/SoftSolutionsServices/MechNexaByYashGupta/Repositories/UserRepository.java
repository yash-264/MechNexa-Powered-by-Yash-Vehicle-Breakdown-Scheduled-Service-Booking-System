package YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Repositories;

import YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

      User findUserByusername(String username);

      User findUserByuserid(String userid);

      void deleteUserByuserid(String userid);
}
