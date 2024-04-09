package com.springapi.donatecharity.service.log;

import com.springapi.donatecharity.utils.GsonParserUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class LoggingServiceImpl implements LoggingService {

    private static final String REQUEST_ID = "request_id";

    @Override
    public void logRequest(HttpServletRequest request, Object body) {
        if (request.getRequestURI().contains("medias")){
            return;
        }
        Object requestId = request.getAttribute(REQUEST_ID);
        StringBuilder data = new StringBuilder();
        data.append("["+requestId+"] ")
                .append("["+request.getServerName()+"] ")
                .append("Request: ")
                .append(GsonParserUtils.parseObjectToString(body))
                .append("\n");
        log.info(data.toString());
    }

    @Override
    public void logResponse(HttpServletRequest request, HttpServletResponse response, Object body) {

    }
}
