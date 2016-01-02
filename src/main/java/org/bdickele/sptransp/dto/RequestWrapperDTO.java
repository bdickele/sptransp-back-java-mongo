package org.bdickele.sptransp.dto;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
@Getter
public class RequestWrapperDTO implements Serializable {

    private static final long serialVersionUID = 4651505999077235127L;

    private int totalNumberOfRequests;

    private int totalNumberOfPages;

    private int numberOfElementsPerPage;

    private int currentPageIndex;

    private int numberOfElementsDisplayed;

    private List<RequestDTO> requests;

    public RequestWrapperDTO(List<RequestDTO> requests, int pageIndex, int pageSize, int totalNumberOfElements) {
        this.requests = requests;
        this.numberOfElementsPerPage = pageSize;
        this.currentPageIndex = pageIndex;
        this.totalNumberOfRequests = totalNumberOfElements;

        this.totalNumberOfPages = totalNumberOfElements / pageSize;
        if ((totalNumberOfElements % pageSize) > 0) {
            this.totalNumberOfPages++;
        }

        this.numberOfElementsDisplayed = requests.size();
    }
}
