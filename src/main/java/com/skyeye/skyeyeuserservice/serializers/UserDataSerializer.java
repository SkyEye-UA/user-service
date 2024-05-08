package com.skyeye.skyeyeuserservice.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.skyeye.skyeyeuserservice.model.Response;
import com.skyeye.skyeyeuserservice.model.UserDataRecord;
import java.io.IOException;

public class UserDataSerializer extends StdSerializer<Response<UserDataRecord>> {

    public UserDataSerializer() {
        this(null);
    }

    public UserDataSerializer(Class<Response<UserDataRecord>> t) {
        super(t);
    }

    @Override
    public void serialize(Response<UserDataRecord> value,
        JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        jgen.writeStartObject();
        jgen.writeObjectField("data", value.getData());
        jgen.writeStringField("code", String.valueOf(value.getCode().value()));
        jgen.writeEndObject();
    }
}