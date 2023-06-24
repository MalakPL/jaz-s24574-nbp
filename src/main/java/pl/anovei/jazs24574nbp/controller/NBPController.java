package pl.anovei.jazs24574nbp.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.anovei.jazs24574nbp.model.ApiResponse;
import pl.anovei.jazs24574nbp.model.Log;
import pl.anovei.jazs24574nbp.service.NBPService;

@RestController
public class NBPController {
    private final NBPService nbpService;

    public NBPController(NBPService nbpService) {
        this.nbpService = nbpService;
    }

    @GetMapping("/{currency}/{startDate}/{endDate}")
    public ResponseEntity<ApiResponse> getAvg(@PathVariable("currency") String currency, @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String startDate, @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String endDate) {

        ApiResponse response = new ApiResponse();
        response.isSuccess = false;

        try {
            var nbpApiResponse = nbpService.getCurrency(currency, startDate, endDate);
            double avg = nbpApiResponse.rates.stream().mapToDouble(x -> x.mid).average().getAsDouble();

            var log = new Log();
            log.currency = currency;
            log.start_date = startDate;
            log.end_date = endDate;
            log.avg = avg;

            response.isSuccess = true;
            response.message = "Wszystko git";
            response.data = log;

            nbpService.addLog(log);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception exception) {

            response.message = exception.getMessage();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}

