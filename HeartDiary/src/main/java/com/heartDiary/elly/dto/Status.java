package com.heartDiary.elly.dto;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@JsonSerialize(using = StatusSerializer.class)
public enum Status {
    GOOD(":)"),
    BAD(":("),
    UNREGISTERED_LOGIN_ID("미등록아이디"),
    PASSWORD_MISMATCH("비밀번호불일치");

    private String message;

    Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

class StatusSerializer extends StdSerializer {

    public StatusSerializer() {
        super(Status.class);
    }

    @Override
    public void serialize(Object obj, JsonGenerator gen, SerializerProvider provider) throws IOException {
        Status status = (Status) obj;
        gen.writeStartObject();
        gen.writeFieldName("code");
        gen.writeString(status.name());
        gen.writeFieldName("message");
        gen.writeString(status.getMessage());
        gen.writeEndObject();
    }
}