package com.example.api.v1;

import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

public interface Utils {
    static OperationRequestPreprocessor getRequestPreProcessor() {
        return preprocessRequest(prettyPrint());
    }

    static OperationResponsePreprocessor getResponsePreProcessor() {
        return preprocessResponse(prettyPrint());
    }
}
