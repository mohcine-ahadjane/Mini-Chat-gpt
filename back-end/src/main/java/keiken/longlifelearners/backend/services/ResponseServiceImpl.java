package keiken.longlifelearners.backend.services;

import keiken.longlifelearners.backend.config.RequestConfig;
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
        headers.setContentType(MediaType.parseMediaType(RequestConfig.MEDIA_TYPE));
        headers.add(RequestConfig.AUTHORIZATION, RequestConfig.BEARER + RequestConfig.API_KEY);
        return new HttpEntity<>(request, headers);
    }

    //    Generate response
    public Response getResponse(HttpEntity<Request> requestHttpEntity) {
        ResponseEntity<Response> responseEntity = restTemplate.postForEntity(
                RequestConfig.URL,
                requestHttpEntity,
                Response.class);

        return responseEntity.getBody();
    }


    @Override
    public Response getResponse(Prompt prompt) {
        return this.getResponse(
                this.buildHttpEntity(
                        new Request(
                                RequestConfig.MODEL,
                                prompt.getMessage(),
                                RequestConfig.TEMPERATURE,
                                RequestConfig.MAX_TOKEN,
                                RequestConfig.TOP_P)));
    }
}