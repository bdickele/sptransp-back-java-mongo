package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.RequestDTO;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.List;

/**
 * Created by bdickele
 */
public class RequestRepository extends AbstractRepository {//extends PagingAndSortingRepository<Request, Long> {

    private static final String COLLECTION = "requests";

    private MongoCollection getCollection() {
        return getCollection(COLLECTION);
    }

    public List<RequestDTO> findAll() {
        MongoCursor<RequestDTO> cursor = getCollection().find()
                .as(RequestDTO.class);
        return getList(cursor);
    }

    /**
     * @param reference
     * @return Request for passed reference
     */
    public RequestDTO findByReference(String reference) {
        return getCollection().findOne("{reference: #}", reference).as(RequestDTO.class);
    }

    /*
    Page<RequestDTO> findByAgreementStatusIn(@Param("agreementStatus") Collection<RequestAgreementStatus> agreementStatus,
                                          Pageable pageRequest);

    Page<Request> findByCustomerUidAndAgreementStatusInOrderByCreationDate(
            @Param("customerUid") String customerUid,
            @Param("agreementStatus") Collection<RequestAgreementStatus> agreementStatus,
            Pageable pageRequest);
            */

    /*
    Collection<RequestDTO> findByAgreementStatusIn(Collection<RequestAgreementStatus> agreementStatus);

    Collection<RequestDTO> findByCustomerUidAndAgreementStatusInOrderByCreationDate(
            String customerUid,
            Collection<RequestAgreementStatus> agreementStatus);
            */
}
