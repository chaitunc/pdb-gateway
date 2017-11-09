package org.test;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

	@Value("${info.foo2}")
	private String infoProperty;

	@Autowired
	OAuth2RestOperations template;

	@RequestMapping("/")
	public PropertyModel home() {
		PropertyModel i = new PropertyModel();
		i.setInfoProp("Hello " + infoProperty);
		return i;
	}

	@RequestMapping("/user")
	public Map<String, Object> actuatorUser(Principal principal) {
		OAuth2Authentication auth = (OAuth2Authentication) principal;
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("userName", principal.getName());
		user.put("details", auth.getDetails());

		return user;
	}

	@RequestMapping("/user/driveInfo")
	public Object driveInfo() {
		Object orgs = template.getForObject(
				"https://www.googleapis.com/drive/v3/about?fields=storageQuota/limit&key=AIzaSyB1qJ27jg8WVlNvMJlnrnMZandHi8fHArI",
				Object.class);
		return orgs;
	}

}
