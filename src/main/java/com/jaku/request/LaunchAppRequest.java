package com.jaku.request;

import com.jaku.core.JakuRequestData;

public class LaunchAppRequest extends JakuRequestData {

	private String appId;
	private String conditions;

	public LaunchAppRequest(String url, String appId, String conditions) {
		super(url);
		this.appId = appId;
		this.conditions = conditions;
	}

	@Override
	public String getPath() {
		return "/launch/" + appId + conditions;
	}

	@Override
	public String getMethod() {
		return "POST";
	}
}
