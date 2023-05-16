package telran.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FixerDTO {
    boolean success;
    long timestamp;
    String base;
    LocalDate date;
    Map<String, Double> rates;
}
