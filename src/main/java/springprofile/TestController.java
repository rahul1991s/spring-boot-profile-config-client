package springprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("test")
@RefreshScope
public class TestController {
	
	@Value("${app.name}")
	private String msg;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/greeting")
	public String greeting(){
		return msg+" Test Controller";
	}
	@RequestMapping("/envDetails")
	public String getEnvDetails(){
		return env.getActiveProfiles()[0];
	}
}
