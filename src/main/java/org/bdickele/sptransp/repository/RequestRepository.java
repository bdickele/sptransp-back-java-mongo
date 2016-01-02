package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.domain.RequestAgreementStatus;
import org.bdickele.sptransp.dto.RequestDTO;
import org.jongo.Find;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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


    public List<RequestDTO> findByAgreementStatus(List<RequestAgreementStatus> agreementStatuses, Pagination pagination) {
        List<String> statusCodes = agreementStatuses.stream().map(RequestAgreementStatus::getCode).collect(Collectors.toList());
        Find find = getCollection().find("{agreementStatus: {$in: #}}", statusCodes)
                .skip(pagination.computeNbElementsToSkip())
                .limit(pagination.pageSize);

        Optional<String> sort = pagination.getSortQuery();
        if (sort.isPresent()) {
            find.sort(sort.get());
        }

        MongoCursor<RequestDTO> mongoCursor = find.as(RequestDTO.class);
        return getList(mongoCursor);
    }

    public List<RequestDTO> findByCustomerUidAndAgreementStatus(String customerUid,
            List<RequestAgreementStatus> agreementStatuses, Pagination pagination) {
        List<String> statusCodes = agreementStatuses.stream().map(RequestAgreementStatus::getCode).collect(Collectors.toList());
        Find find = getCollection().find("{customerUid: {$eq: #}, agreementStatus: {$in: #}}", customerUid, statusCodes)
                .skip(pagination.computeNbElementsToSkip())
                .limit(pagination.pageSize);

        Optional<String> sort = pagination.getSortQuery();
        if (sort.isPresent()) {
            find.sort(sort.get());
        }

        MongoCursor<RequestDTO> mongoCursor = find.as(RequestDTO.class);
        return getList(mongoCursor);
    }


}
