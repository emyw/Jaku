package com.jaku;

import java.io.IOException;
import java.util.List;

import com.jaku.api.DeviceRequests;
import com.jaku.api.LaunchRequests;
import com.jaku.api.QueryRequests;
import com.jaku.api.SearchRequests;
import com.jaku.model.Channel;
import com.jaku.model.Device;

public class Jaku {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello, this is Jaku");

		/*
		 * byte[] data = QueryRequests.queryIconRequest("http://192.168.1.103:8060",
		 * "1457");
		 * 
		 * InputStream is = null;
		 * BufferedImage bufferedImage = null;
		 * 
		 * try {
		 * is = new ByteArrayInputStream(data);
		 * bufferedImage = ImageIO.read(is);
		 * } catch (IOException e) {
		 * e.printStackTrace();
		 * }
		 * 
		 * System.out.println(bufferedImage.getWidth());
		 * 
		 * File outputfile = new File("/Users/wseemann/Desktop/poop.jpeg");
		 * ImageIO.write(bufferedImage, "jpeg", outputfile);
		 */
		List<Device> bobby = DeviceRequests.discoverDevices();
		Device device1 = bobby.get(0);
		List<Channel> active = QueryRequests.queryActiveAppRequest(device1.getHost());
		List<Channel> channels = QueryRequests.queryAppsRequest(device1.getHost());
		Boolean activeChannel = false;
		Boolean installed = false;
		for (int i = 0; i < channels.size() - 1; i++) {
			Channel chan = channels.get(i);
			String id = chan.getId();
			if (id.equals("661735")) {
				installed = true;
			}
		}
		if (installed) {
			for (int i = 0; i < active.size() - 1; i++) {
				Channel chan = active.get(i);
				String id = chan.getId();
				if (id.equals("661735")) {
					activeChannel = true;
				}
			}
			if (activeChannel) {
				LaunchRequests.launchShowRequest(device1.getHost(),
						"?contentId=636e73ce2d20330007436488&mediaType=movie");
			} else {
				LaunchRequests.launchAppIdRequest(device1.getHost(), "661735",
						"?contentId=636e73ce2d20330007436488&mediaType=movie");
			}
		} else {
			SearchRequests.searchRequest(device1.getHost(), "Enjoy Movies Your Way");
		}
		// KeyRequests.keypressRequest("http://192.168.1.103:8060",
		// KeypressKeyValues.BACK);
		// SearchRequests.searchRequest("http://192.168.1.103:8060", "Lego", "lego",
		// null, null, 1, false, true, null, null, true);;
	}
}
