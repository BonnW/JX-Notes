package info.burahan.languages;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class LanguageController
{
    private final LanguageRepository lRepo;
    private final RabbitTemplate rt;

    public LanguageController(LanguageRepository LRepo, RabbitTemplate rt)
    {
        this.lRepo = LRepo;
        this.rt = rt;
    }

    @GetMapping("/languages")
    public List<Language> all()
    {
        return lRepo.findAll();
    }

    @GetMapping("/languages/{id}")
    public Language findOne(@PathVariable Long id)
    {
        return lRepo.findById(id)
                .orElseThrow(() -> new LanguageNotFoundException(id));
    }

    @PostMapping("/languages")
    public List<Language> newLanguage(@RequestBody List<Language> newLangs)
    {
        return lRepo.saveAll(newLangs);
    }

    @GetMapping("/languages/population")
    public ObjectNode sumPops()
    {
        List<Language> languages = lRepo.findAll();

        Long total = 0L;
        for (Language l : languages)
        {
            total = total + l.getPopulation();
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode totalPops = mapper.createObjectNode();
        totalPops.put("id", 0);
        totalPops.put("language", "total");
        totalPops.put("population", total);
        totalPops.put("comment", "Lambda School");

        LanguageLog message = new LanguageLog("Checked Total Population");
        rt.convertAndSend(LanguagesApplication.QUEUE_NAME, message.toString());
        log.info("Message sent");

        return totalPops;
    }
}
