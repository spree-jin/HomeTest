package com.spree.hometest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.spree.hometest.constants.Constants;
import com.spree.hometest.instance.RetrofitClientInstance;
import com.spree.hometest.models.Attributes;
import com.spree.hometest.models.Data;
import com.spree.hometest.models.Links;
import com.spree.hometest.models.Meta;
import com.spree.hometest.models.Result;
import com.spree.hometest.service.MainService;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.*;

public class ResponseUnitTest {

    @Before
    public void init(){
        System.out.println("init");
    }

    @Test
    public void responseAllCheck(){
        String url = Constants.URL_FIRST;
        do{
            String nextUrl = responseUrl(url);
            url = nextUrl;
        } while(url != null);
    }

    public String responseUrl(String url) {
        MainService mainService = RetrofitClientInstance.getRetrofitInstance().create(MainService.class);
        Call<Result> call = mainService.getProducts(url);
        try{
            Response<Result> response = call.execute();
            Result result = response.body();

            assertTrue(response.isSuccessful());
            assertNotNull(result);

            List<Data> datas = result.getData();
            assertNotNull(result.getData());

            for(Data data : datas) {
                assertNotNull(data.getId());

                Attributes attributes = data.getAttributes();
                assertNotNull(attributes);

                assertNotNull(attributes.getName());
                assertNotNull(attributes.getPrice());
                assertNotNull(attributes.getRating());
                assertTrue(attributes.getDefaultImageUrls().size() > 0);
                assertTrue(attributes.getImageUrls().size() > 0);
            }

            Meta meta = result.getMeta();
            assertNotNull(meta);

            assertTrue(meta.getTotalItems() > 0);

            Links links = result.getLinks();
            assertNotNull(links);

            System.out.println("Items Count : " + datas.size());
            System.out.println(links.getSelf() + " responseUrl not error");
            System.out.println();

            return links.getNext();
        } catch (IOException ie){
            ie.printStackTrace();
            assertTrue(ie.getMessage(), false);
        }

        return null;
    }
}
