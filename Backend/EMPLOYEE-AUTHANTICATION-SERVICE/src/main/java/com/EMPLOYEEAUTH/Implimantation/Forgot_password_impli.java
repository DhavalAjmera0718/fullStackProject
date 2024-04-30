package com.EMPLOYEEAUTH.Implimantation;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.EMPLOYEEAUTH.Entity.Emp_Credential;
import com.EMPLOYEEAUTH.Helper.Forgot_Password_Helper;
import com.EMPLOYEEAUTH.Repository.AUTH_REPO;


@Component
public class Forgot_password_impli {
	Integer otp;
	
	@Autowired
	private AUTH_REPO crepo;
	
	@Autowired
	private Email_Implimentation emailService;
	
	@Autowired
	private Forgot_Password_Helper forgot_Password_Helper;
	
	Random random = new Random();
	
	private String updateComponemnt = "http://localhost:4200/updatepass";
	
	
	public String sendRandomOTP(String email ,LocalDate dob ) throws MessagingException 
	{
		System.err.println("Impl email"+email);
		System.err.println("Impl Dob"+dob);
		
		 Emp_Credential byEmail = crepo.findByEmailAndDob(email ,dob);
		System.err.println("Email-->"+byEmail.getEmail());
		System.err.println("DOB==>"+byEmail.getDob());
		if (byEmail!=null) {
			System.err.println("******IF BYEMAIL********");
//			if (dob.equals(dob)) {
//				System.err.println("******* DATE OF BIRTH CHECK***********");
				otp = random.nextInt(9999);
				
				System.err.println("OTP------->" + otp);
				
				
				String subject = "OTP From Student Micro Service";
				String message = "Reset Password OTP Is  = " + otp;
				String to = email;
				Boolean sendEmail = emailService.sendEmail(subject, message, to);
				System.err.println("------->"+sendEmail);
				if (sendEmail) {
					byEmail.setOtp(otp);
					byEmail.setCreatedTime(new Date());
					crepo.save(byEmail);
					return null;
				}
			}
		return "";
		}
/*********************************************************************************************************************************************/	
	
	public String verifyOTP(String email ,Integer otp , LocalDate dob  ) throws MessagingException 
	{
		System.err.println("---------");
		
		Emp_Credential credEntityData = crepo.findByEmailAndDob(email, dob);
//		
//		System.err.println("email and DOb ---->" + byEmailAndDob);
//		
		
		if( crepo.findByEmailAndOtpAndDob(email, otp, dob)!=null)
//			if(otp.toString().equals(this.otp.toString()))
			{
			Boolean expireOtp = forgot_Password_Helper.checkExpirationOfOtp(email, credEntityData.getCreatedTime());
			if (expireOtp) {
				credEntityData.setOtp(null);
				credEntityData.setCreatedTime(null);
				crepo.save(credEntityData);
				return "OTP is Expired...!!!";
				
			}
			System.err.println("************");
			Emp_Credential byEmail = crepo.findByEmail(email);
			String password = byEmail.getPassword();
			
			String subject = "Forgot Password Detail";
			
			String randomString = "?Token="+  forgot_Password_Helper.RandomString();
			
			String mainUrl= this.updateComponemnt +  randomString;
			
			String message =   "Username -->| "+ " [ " + byEmail.getName()+" ] " + 
					"Your Old Password Is -->| "+"[ "+byEmail.getPassword()  + " ] "
					+  " If You Want to Update Password Please Update Your Password with this link "+ mainUrl;
			
			byEmail.setUrl(mainUrl);
			crepo.save(byEmail);
			
			System.err.println("Message URL***** " + message  );
			
			String to  = email;
			System.err.println("Send Password Function ********" +to);
			emailService.sendPassword(message, subject, to);
			return password;
			
		}
		return "Please Check Again..!!";	
	}

}
