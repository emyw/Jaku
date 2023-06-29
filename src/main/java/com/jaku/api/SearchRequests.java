package com.jaku.api;

import java.io.IOException;

import com.jaku.core.JakuRequest;
import com.jaku.core.SearchTypeValues;
import com.jaku.request.SearchRequest;

public class SearchRequests {

	private SearchRequests() {

	}

	public static final void searchRequest(String url, String keyword) throws IOException {
		SearchRequest searchRequest = new SearchRequest(url, keyword);

		JakuRequest request = new JakuRequest(searchRequest, null);
		request.send();
	}
}
