package com.example.gadsleadershipboardapp.services;

import androidx.annotation.Nullable;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SubmitToGoogleFormsService {
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    @Nullable
    Call<Void> submitProject(
            @Field("entry.1877115667") @Nullable String firstName,
            @Field("entry.2006916086") @Nullable String lastName,
            @Field("entry.284483984") @Nullable String githubLink,
            @Field("entry.1824927963") @Nullable String emailAddress);
}
