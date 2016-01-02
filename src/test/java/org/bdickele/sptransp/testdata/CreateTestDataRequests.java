package org.bdickele.sptransp.testdata;

import org.apache.commons.lang3.tuple.Pair;
import org.bdickele.sptransp.domain.RequestAgreementVisaStatus;
import org.bdickele.sptransp.dto.*;
import org.bdickele.sptransp.repository.CustomerRepository;
import org.bdickele.sptransp.repository.DestinationRepository;
import org.bdickele.sptransp.repository.EmployeeRepository;
import org.bdickele.sptransp.repository.GoodsRepository;
import org.bdickele.sptransp.service.RequestService;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Bertrand DICKELE
 */
public class CreateTestDataRequests extends AbstractCreateTestData {

    private static final int NB_REQUESTS = 50;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private RequestService requestService;

    private CustomerGenerator customerGenerator;

    private EmployeeGenerator employeeGenerator;

    private GoodsGenerator goodsGenerator;

    private DestinationGenerator destinationGenerator;


    @Ignore
    public void createTestData() {
        deleteAllRequests();
        createRequests();
    }

    private void deleteAllRequests() {
        getCollection("requests").remove();
    }

    private void createRequests() {
        customerGenerator = new CustomerGenerator(customerRepository.findAll());
        employeeGenerator = new EmployeeGenerator(employeeRepository.findAll());
        goodsGenerator = new GoodsGenerator(goodsRepository.findAll());
        destinationGenerator = new DestinationGenerator(destinationRepository.findAll());

        Random random = new Random();

        for (int i=0; i<NB_REQUESTS; i++) {
            // On cree la requete
            RequestDTO request = createRequest();
            //String reference = request.getReference();

            // Je suppose que toutes les regles sont composees selon le schema
            // law compliance > shuttle compliance > goods inspection > journey supervision

            // On va donner entre 0 et 4 visas pour chaque requete
            int nbVisas = random.nextInt(5);
            // Les nbVisas-1 premiers visas seront accordes
            // Pour le dernier visa on tire au sort si il est accorde ou refuse

            if (nbVisas > 0) {
                for (int j=0; j<nbVisas; j++) {
                    AgreementRuleVisaDTO nextVisa = request.getNextExpectedAgreementVisa().get();
                    EmployeeDTO employee = employeeGenerator.get(nextVisa);
                    //System.out.println("Application du visa " + nextVisa.toString() + " par " + employee.toString());
                    RequestAgreementVisaStatus visaStatus = RequestAgreementVisaStatus.GRANTED;

                    // Le dernier visa sera-t-il accorde ou pas ?
                    if (j == (nbVisas-1)) {
                        if (random.nextInt(5)==4) visaStatus = RequestAgreementVisaStatus.DENIED;
                    }

                    // Re-assigner pour avoir un objet mis a jour
                    request = requestService.update(request.getReference(), employee.getUid(), visaStatus, "this is a test data and thus a test comment");
                }
            }
        }
    }

    private RequestDTO createRequest() {
        CustomerDTO customer = customerGenerator.get();
        Pair<DestinationDTO, DestinationDTO> destinations = destinationGenerator.get();
        GoodsDTO goods = goodsGenerator.get();
        return requestService.create(goods, destinations.getLeft(), destinations.getRight(), customer);
    }

    private static class CustomerGenerator {

        List<CustomerDTO> customers;
        int size;
        Random random = new Random();

        private CustomerGenerator(List<CustomerDTO> customers) {
            this.customers = customers;
            size = customers.size();
        }

        private CustomerDTO get() {
            return customers.get(random.nextInt(size));
        }
    }

    private static class EmployeeGenerator {

        List<EmployeeDTO> employees;

        private EmployeeGenerator(List<EmployeeDTO> employees) {
            this.employees = employees;
        }

        private EmployeeDTO get(AgreementRuleVisaDTO visa) {
            return employees.stream()
                    .filter(e -> visa.getDepartmentCode().equals(e.getDepartmentCode())
                                    && e.getSeniority().ge(visa.getSeniority()))
                    .findAny()
                    .get();
        }
    }

    private static class GoodsGenerator {

        List<GoodsDTO> goodsList;
        int size;
        Random random = new Random();

        private GoodsGenerator(List<GoodsDTO> goodsList) {
            this.goodsList = goodsList.stream()
                    .filter(g -> !"WEAPON".equals(g.getCode()))
                    .collect(Collectors.toList());
            this.size = this.goodsList.size();
        }

        private GoodsDTO get() {
            return goodsList.get(random.nextInt(size));
        }
    }

    private static class DestinationGenerator {

        List<DestinationDTO> destinations;
        int size;
        Random random = new Random();

        private DestinationGenerator(List<DestinationDTO> destinations) {
            this.destinations = destinations;
            this.size = destinations.size();
        }

        private Pair<DestinationDTO, DestinationDTO> get() {
            int firstIndex = random.nextInt(size);
            int secondIndex = random.nextInt(size);
            while (secondIndex==firstIndex) {
                secondIndex = random.nextInt(size);
            }
            return Pair.of(destinations.get(firstIndex), destinations.get(secondIndex));
        }
    }
}
