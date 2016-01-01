package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.domain.RequestAgreementStatus;
import org.bdickele.sptransp.dto.RequestDTO;

import java.util.Collection;

/**
 * Created by bdickele
 */
public interface RequestRepository {//extends PagingAndSortingRepository<Request, Long> {

    /**
     * @param reference
     * @return Request for passed reference
     */
    RequestDTO findByReference(String reference);

    /*
    Page<RequestDTO> findByAgreementStatusIn(@Param("agreementStatus") Collection<RequestAgreementStatus> agreementStatus,
                                          Pageable pageRequest);

    Page<Request> findByCustomerUidAndAgreementStatusInOrderByCreationDate(
            @Param("customerUid") String customerUid,
            @Param("agreementStatus") Collection<RequestAgreementStatus> agreementStatus,
            Pageable pageRequest);
            */
    Collection<RequestDTO> findByAgreementStatusIn(Collection<RequestAgreementStatus> agreementStatus);

    Collection<RequestDTO> findByCustomerUidAndAgreementStatusInOrderByCreationDate(
            String customerUid,
            Collection<RequestAgreementStatus> agreementStatus);
}
