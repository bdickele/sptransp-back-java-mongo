package org.bdickele.sptransp.controller;

import org.bdickele.sptransp.domain.RequestAgreementStatus;
import org.bdickele.sptransp.domain.RequestAgreementVisaStatus;
import org.bdickele.sptransp.dto.RequestAgreementVisaDTO;
import org.bdickele.sptransp.dto.RequestDTO;
import org.bdickele.sptransp.dto.RequestWrapperDTO;
import org.bdickele.sptransp.exception.SpTranspBizError;
import org.bdickele.sptransp.repository.Pagination;
import org.bdickele.sptransp.repository.RequestRepository;
import org.bdickele.sptransp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.bdickele.sptransp.domain.RequestAgreementStatus.*;

/**
 * Created by Bertrand DICKELE
 */
@RestController
@RequestMapping("/requests")
public class RequestController extends AbstractController {

    private static final String DEFAULT_PAGE = "0";

    private static final String DEFAULT_SIZE = "20";

    @Autowired
    private RequestService service;

    @Autowired
    private RequestRepository repository;


    @RequestMapping(
            value="/{requestReference}",
            method= RequestMethod.GET,
            produces="application/json")
    public RequestDTO request(@PathVariable String requestReference) {
        RequestDTO request = repository.findByReference(requestReference);

        if (request==null) {
            throw SpTranspBizError.REQUEST_NOT_FOUND.exception(requestReference);
        }

        return request;
    }

    @RequestMapping(
            value="/beingValidated",
            method= RequestMethod.GET,
            produces="application/json")
    public RequestWrapperDTO requestsBeingValidated(
            @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size) {
        return getRequestsPerStatus(createPagination(page, size), PENDING);
    }

    @RequestMapping(
            value="/beingValidated/{customerUid}",
            method= RequestMethod.GET,
            produces="application/json")
    public RequestWrapperDTO requestsBeingValidated(@PathVariable String customerUid,
                                                   @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                                                   @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size) {
        return getRequestsPerCustomerAndStatus(createPagination(page, size), customerUid, PENDING);
    }

    @RequestMapping(
            value="/grantedOrRefused",
            method= RequestMethod.GET,
            produces="application/json")
    public RequestWrapperDTO requestsGrantedOrRefused(
            @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size) {
        return getRequestsPerStatus(createPagination(page, size), GRANTED, REFUSED);
    }

    @RequestMapping(
            value="/grantedOrRefused/{customerUid}",
            method= RequestMethod.GET,
            produces="application/json")
    public RequestWrapperDTO requestsGrantedOrRefused(@PathVariable String customerUid,
                                                     @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                                                     @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size) {
        return getRequestsPerCustomerAndStatus(createPagination(page, size), customerUid, GRANTED, REFUSED);
    }

    private RequestWrapperDTO getRequestsPerStatus(Pagination pagination, RequestAgreementStatus... agreementStatus) {
        List<RequestAgreementStatus> statusList = Arrays.asList(agreementStatus);
        int total = repository.getNumberOfRequestsByAgreementStatus(statusList);
        List<RequestDTO> requests = repository.findByAgreementStatus(statusList, pagination);
        return new RequestWrapperDTO(requests, pagination.pageIndex, pagination.pageSize, total);
    }

    private RequestWrapperDTO getRequestsPerCustomerAndStatus(Pagination pagination, String customerUid, RequestAgreementStatus... agreementStatus) {
        List<RequestAgreementStatus> statusList = Arrays.asList(agreementStatus);
        int total = repository.getNumberOfRequestsByCustomerUidAndAgreementStatus(customerUid, statusList);
        List<RequestDTO> requests = repository.findByCustomerUidAndAgreementStatus(customerUid, statusList, pagination);
        return new RequestWrapperDTO(requests, pagination.pageIndex, pagination.pageSize, total);
    }

    private Pagination createPagination(int page, int size) {
        return new Pagination(page, size, "creationDate", 1);
    }

    @RequestMapping(
            method= RequestMethod.POST,
            consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public RequestDTO create(@RequestBody RequestDTO dto) {
        RequestDTO request = service.create(dto.getGoodsCode(), dto.getDepartureCode(), dto.getArrivalCode(), dto.getCustomerUid());
        return request;
    }

    @RequestMapping(
            value = "/{requestReference}",
            method= RequestMethod.PUT,
            consumes="application/json")
    @ResponseStatus(HttpStatus.OK)
    public RequestDTO applyVisa(@PathVariable String requestReference, @RequestBody RequestAgreementVisaDTO dto) {
        RequestDTO request = service.update(requestReference, dto.getEmployeeUid(),
                RequestAgreementVisaStatus.getByCode(dto.getStatusCode()), dto.getComment());
        return request;
    }
}
