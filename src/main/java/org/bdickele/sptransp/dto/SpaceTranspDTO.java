package org.bdickele.sptransp.dto;

import org.bdickele.sptransp.dto.converter.LocalDateTimeConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by bdickele
 */
public interface SpaceTranspDTO {

    DateTimeFormatter DATE_TIME_FORMATTER_FOR_COMPARISON = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");


    default String formatDate(LocalDateTime date) {
        return date.format(LocalDateTimeConverter.DATE_TIME_FORMATTER);
    }

    default String formatDateForComparison(LocalDateTime date) {
        return date.format(DATE_TIME_FORMATTER_FOR_COMPARISON);
    }
}
