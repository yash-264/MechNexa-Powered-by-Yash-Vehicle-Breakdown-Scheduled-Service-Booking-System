package YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Repositories;

import YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Entity.ServiceProvider;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceProviderRepository extends MongoRepository<ServiceProvider, ObjectId> {

     ServiceProvider findServiceProviderByserviceproviderid(String spId);


     void deleteServiceProvideByserviceproviderid(String serviceproviderid);
}
