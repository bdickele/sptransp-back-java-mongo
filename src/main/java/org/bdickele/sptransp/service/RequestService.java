package org.bdickele.sptransp.service;

import org.bdickele.sptransp.domain.RequestAgreementVisaStatus;
import org.bdickele.sptransp.dto.*;
import org.bdickele.sptransp.exception.SpTranspBizError;
import org.bdickele.sptransp.repository.*;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by Bertrand DICKELE
 */
@Service
public class RequestService extends AbstractService {

    private static final String COLLECTION = "requests";

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private AgreementRuleRepository ruleRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SequenceRepository sequenceRepository;


    private MongoCollection getCollection() {
        return getCollection(COLLECTION);
    }

    public RequestDTO create(String goodsCode, String departureCode, String arrivalCode, String customerUid) {
        CustomerDTO customer = customerRepository.findByUid(customerUid);
        GoodsDTO goods = goodsRepository.findByCode(goodsCode);
        DestinationDTO departure = destinationRepository.findByCode(departureCode);
        DestinationDTO arrival = destinationRepository.findByCode(arrivalCode);
        return create(goods, departure, arrival, customer);
    }

    public RequestDTO create(GoodsDTO goods, DestinationDTO departure, DestinationDTO arrival, CustomerDTO customer) {
        // Version actuelle de la Agreement Rule
        AgreementRuleDTO agreementRule = ruleRepository.findByDestinationCodeAndGoodsCode(arrival.getCode(), goods.getCode());
        AgreementRuleHistoryDTO ruleVersion = AgreementRuleHistoryDTO.build(agreementRule);

        Long id = sequenceRepository.getNextSequenceValueForRequest();
        RequestDTO request = RequestDTO.build(id, generateRequestReference(), customer, goods, departure, arrival, ruleVersion);

        getCollection().insert(request);

        return request;
    }

    public RequestDTO update(String requestReference, String employeeUid, RequestAgreementVisaStatus visaStatus, String comment) {
        RequestDTO request = requestRepository.findByReference(requestReference);
        if (request==null) throw SpTranspBizError.REQUEST_NOT_FOUND_FOR_REFERENCE.exception(requestReference);

        EmployeeDTO employee = employeeRepository.findByUid(employeeUid);
        if (employee==null) throw SpTranspBizError.EMPLOYEE_NOT_FOUND.exception(employeeUid);

        return update(request, employee, visaStatus, comment);
    }

    public RequestDTO update(RequestDTO request, EmployeeDTO employee, RequestAgreementVisaStatus visaStatus, String comment) {
        request.applyAgreementVisa(employee, visaStatus, comment);
        request.setVersion(request.getVersion() + 1);

        getCollection().update("{id: #}", request.getId()).upsert().with(request);

        return request;
    }

    public static String generateRequestReference() {
        Random random = new Random();
        StringBuilder word = new StringBuilder(10);
        IntStream.range(0, 6).forEach(i -> word.append((char)('a' + random.nextInt(26))));
        IntStream.range(0, 4).forEach(i -> word.append(random.nextInt(10)));
        return word.toString().toUpperCase();
    }
}
