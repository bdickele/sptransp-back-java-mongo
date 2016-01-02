package org.bdickele.sptransp.repository;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * Created by Bertrand DICKELE
 */
public class Pagination {

    public final int pageSize;

    public final int pageIndex;

    public final String sortField;

    public final int sortDirection;


    public Pagination(int pageIndex, int pageSize, String sortField, int sortDirection) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.sortField = sortField;
        this.sortDirection = sortDirection;
    }

    public int computeNbElementsToSkip() {
        return pageIndex * pageSize;
    }

    public Optional<String> getSortQuery() {
        if (StringUtils.isEmpty(sortField)) {
            return Optional.empty();
        }

        return Optional.of("{" + sortField + ": " + sortDirection + "}");
    }
}
