package keiken.longlifelearners.backend.services;

import keiken.longlifelearners.backend.model.request.Prompt;
import keiken.longlifelearners.backend.model.response.Response;

public interface ResponseService {
    Response getResponse(Prompt prompt);
}