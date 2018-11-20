package com.example.sky0621.fs2.worker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class MyWorker01Param {

    private String workerId;
    private String memo;

    public MyWorker01Param() {
    }

    public MyWorker01Param(String workerId, String memo) {
        this.workerId = workerId;
        this.memo = memo;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String toJson() throws IOException {
        ObjectMapper om = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return om.writeValueAsString(this);
    }

    public void toObject(String json) throws IOException {
        ObjectMapper om = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MyWorker01Param result = om.readValue(json, this.getClass());

        this.setWorkerId(result.workerId);
        this.setMemo(result.memo);
    }

}
