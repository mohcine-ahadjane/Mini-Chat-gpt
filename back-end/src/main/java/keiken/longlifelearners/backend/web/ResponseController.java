package keiken.longlifelearners.backend.web;

import keiken.longlifelearners.backend.model.request.Prompt;
import keiken.longlifelearners.backend.model.response.Response;
import keiken.longlifelearners.backend.services.ResponseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin("*")
public class ResponseController {
    private ResponseService responseService;
    @PostMapping("/request")
    public Response sendRequest(@RequestBody Prompt prompt){
        return responseService.getResponse(prompt);
    }
}