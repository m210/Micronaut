package com.example.service;

import com.example.client.GifDataClient;
import com.example.client.GiphyClient;
import com.example.model.GifMetadata;
import com.example.model.GiphyApiResult;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Bean
public class GifSearchServiceImpl implements GifSearchService {

    private final GiphyClient client;
    private final GifDataClient dataClient;
    
    private final Logger logger = LoggerFactory.getLogger(GifSearchServiceImpl.class);
    
    @Value("${gif-client.api_key}")
    private String api_key;

    public GifSearchServiceImpl(GiphyClient client, GifDataClient dataClient) {
    	this.client = client;
    	this.dataClient = dataClient;
    }

	@Override
	public byte[] findGif(String query) {
		GiphyApiResult res = client.search(api_key, query, 100);
    	List<GifMetadata> list = res.getData();
    	
    	logger.debug("Calling findGif({})", query);
        return dataClient.getGifData(list.stream().skip((int) (list.size() * Math.random())).findAny().get().getId());
    }
}
