package YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Repositories;

import YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Entity.Receipt;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReceiptRepository extends MongoRepository<Receipt, ObjectId> {

      Receipt findReceiptByrequestnumber(String requestnumber);
}
