package com.jaku.api;

import java.io.IOException;

import com.jaku.core.JakuRequest;
import com.jaku.request.LaunchAppRequest;
import com.jaku.request.LaunchShowRequest;

public class LaunchRequests {

	private LaunchRequests() {

	}

	public static final void launchAppIdRequest(String url, String appId, String conditions) throws IOException {
		LaunchAppRequest launchAppIdRequest = new LaunchAppRequest(url, appId, conditions);

		JakuRequest request = new JakuRequest(launchAppIdRequest, null);
		request.send();
	}

	public static final void launchShowRequest(String url, String conditions) throws IOException {
		LaunchShowRequest launchShowRequest = new LaunchShowRequest(url, conditions);

		JakuRequest request = new JakuRequest(launchShowRequest, null);
		request.send();
	}
}
