package com.dci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletConfigAware;

import javax.servlet.ServletConfig;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;


@SpringBootApplication
@RestController
public class Application {

	@RequestMapping("/")
	public String home() {
		//to lookup in DNS
		//InetAddress[] ipAddress = DNSNameService.lookupAllHostAddr("hostName");

		StringBuilder sb = new StringBuilder(2048);
		sb.append("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">");
		sb.append("<HTML>");
		sb.append("<HEAD>");
		sb.append("<TITLE>");
		sb.append("Spring Boot Service");
		sb.append("</TITLE>");
		sb.append("</HEAD>");
		sb.append("<BODY>");
		sb.append("<pre>" + getMessage() + "</pre>");
		sb.append("</BODY>");
		sb.append("</HTML>");

		return sb.toString();
	}

	private String getMessage() {
		final String ls = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder(2048);
		sb.append("Example spring boot service" + ls);
		sb.append("=================================================" + ls + ls);
		Date date = new Date();
		sb.append(date.toString() + ls);

		InetAddress ip;
		String hostname;
		try {
			ip = InetAddress.getLocalHost();
			hostname = ip.getHostName();
			sb.append("This service is executing on the following server:" + ls);
			sb.append("  IP address : " + ip + ls);
			sb.append("  Hostname : " + hostname + ls + ls);
		} catch (UnknownHostException e) {
			sb.append(e.getMessage() + ls);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
