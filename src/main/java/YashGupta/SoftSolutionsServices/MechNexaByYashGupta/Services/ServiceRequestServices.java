package YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Services;


import YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Entity.ServiceRequest;
import YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Repositories.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRequestServices {

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;



    public void saveServiceRequest(ServiceRequest servicerequest){

        serviceRequestRepository.save(servicerequest);
    }



}
