package com.jaku.request;

import com.jaku.core.JakuRequestData;

public class LaunchShowRequest extends JakuRequestData {

	private String conditions;

	public LaunchShowRequest(String url, String conditions) {
		super(url);
		this.conditions = conditions;
	}

	@Override
	public String getPath() {
		return "/input" + conditions;
	}

	@Override
	public String getMethod() {
		return "POST";
	}
}
