package com.EMPLOYEEAUTH.Helper;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Forgot_Password_Helper {

	public Boolean checkExpirationOfOtp(String otp, Date createdTime) {
		Timestamp timestamp1 = new Timestamp(createdTime.getTime());
		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
		Long res = (timestamp2.getTime() - timestamp1.getTime()) / (60 * 1000);
		System.err.println("Timestamp === "+res);
		if(res >= 2) {
			return true;
		}
		return false;
	}
/**********************************************************************************************************************************************/
	public String RandomString() 
	{
		Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        // Generate random characters until the string length is at least 50
        while (stringBuilder.length() < 50) {
            char randomChar = (char) (random.nextInt(26) + 'a'); // Generating random lowercase characters
            stringBuilder.append(randomChar);
        }
        
        
        return stringBuilder.toString();
	}
	
}
