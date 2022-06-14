package com.example.model;

import java.util.List;

public class GiphyApiResult {

	private List<GifMetadata> data;
	
	public List<GifMetadata> getData() {
		return data;
	}
	
	public void setData(List<GifMetadata> data) {
		this.data = data;
	}
}