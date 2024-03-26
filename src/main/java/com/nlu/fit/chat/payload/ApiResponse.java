package com.nlu.fit.chat.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

import static com.nlu.fit.chat.utils.HttpRequestUtil.getHttpRequestURL;


@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ApiResponse<T> {
    private Integer code;
    private String message;
    private T data;
    private Instant instant;
    private String url;

    public ApiResponse(T data) {
        this.data = data;
        this.code = HttpStatus.OK.value();
        this.message = "Success";
        this.instant = Instant.now();
        this.url = getHttpRequestURL();
    }

    public ApiResponse(T data, int code) {
        this(data);
        this.code = code;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", time=" + instant +        // modified
                ", url='" + url + '\'' +
                '}';
    }
}