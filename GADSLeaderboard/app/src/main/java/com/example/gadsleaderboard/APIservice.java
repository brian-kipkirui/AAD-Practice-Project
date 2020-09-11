package com.example.gadsleaderboard;

import javax.xml.namespace.QName;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIservice {
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<Submission> createSubmission(
            @Field("entry.1824927963") String email,
            @Field("entry.1877115667") String name,
            @Field("entry.2006916086") String lastname,
            @Field("entry.284483984") String link

    );
}
