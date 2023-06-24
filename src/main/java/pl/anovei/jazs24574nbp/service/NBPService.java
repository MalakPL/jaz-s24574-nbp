package pl.anovei.jazs24574nbp.service;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.anovei.jazs24574nbp.model.Log;
import pl.anovei.jazs24574nbp.model.Root;
import pl.anovei.jazs24574nbp.repository.NBPRepository;

@Service
public class NBPService {
    public RestTemplate restTemplate;
    public NBPRepository nbpRepository;

    public NBPService(RestTemplate restTemplate, NBPRepository nbpRepository) {
        this.restTemplate = restTemplate;
        this.nbpRepository = nbpRepository;
    }

    public Root getCurrency(String currency, String startDate, String endDate) {
        return restTemplate.getForObject("https://api.nbp.pl/api/exchangerates/rates/a/{currency}/{startDate}/{endDate}/?format=json", Root.class, currency, startDate, endDate);
    }

    public void addLog(Log log) {
        nbpRepository.save(log);
    }
}
