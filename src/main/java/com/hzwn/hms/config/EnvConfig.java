package com.hzwn.hms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class EnvConfig 
{
    @Autowired
	Environment env;

    public String getActiveProfile()
    {
    	String[] activeProfiles = env.getActiveProfiles();

    	for (String profile : activeProfiles)
		{
			if ("DEV".equals(profile)
					|| "SIT".equals(profile)
					|| "UAT".equals(profile)
					|| "DR".equals(profile)
					|| "PROD".equals(profile)
					)
			{
				return profile;
			}
		}

    	return "DEV";
    }
    
}