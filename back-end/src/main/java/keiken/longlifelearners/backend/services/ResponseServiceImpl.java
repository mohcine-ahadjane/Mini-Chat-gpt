package keiken.longlifelearners.backend.services;

import keiken.longlifelearners.backend.config.CompletionRequestConfig;
import keiken.longlifelearners.backend.model.request.Prompt;
import keiken.longlifelearners.backend.model.request.Request;
import keiken.longlifelearners.backend.model.response.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ResponseServiceImpl implements ResponseService {
    private static RestTemplate restTemplate = new RestTemplate();

    //    Build headers
    public HttpEntity<Request> buildHttpEntity(Request request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(CompletionRequestConfig.MEDIA_TYPE));
        headers.add(CompletionRequestConfig.AUTHORIZATION, CompletionRequestConfig.BEARER + CompletionRequestConfig.API_KEY);
        return new HttpEntity<>(request, headers);
    }

    //    Generate response
    public Response getResponse(HttpEntity<Request> requestHttpEntity) {
        ResponseEntity<Response> responseEntity = restTemplate.postForEntity(
                CompletionRequestConfig.URL,
                requestHttpEntity,
                Response.class);

        return responseEntity.getBody();
    }


    @Override
    public Response getResponse(Prompt prompt) {
        return this.getResponse(
                this.buildHttpEntity(
                        new Request(
                                CompletionRequestConfig.MODEL,
                                prompt.getMessage(),
                                CompletionRequestConfig.TEMPERATURE,
                                CompletionRequestConfig.MAX_TOKEN,
                                CompletionRequestConfig.TOP_P)));
    }
}
