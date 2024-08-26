package com.hzwn.hms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceUrlConfig {

	@Value("${service.patient.url}")
	private String patientServiceUrl;

	@Value("${service.doctor.url}")
	private String doctorServiceUrl;

	@Value("${service.appointment.url}")
	private String appointmentServiceUrl;

	@Value("${service.lab.url}")
	private String labServiceUrl;

	@Value("${service.notification.url}")
	private String notificationServiceUrl;

	@Value("${service.prescription.url}")
	private String prescriptionServiceUrl;

	public String getPatientServiceUrl() {
		return patientServiceUrl;
	}

	public String getDoctorServiceUrl() {
		return doctorServiceUrl;
	}

	public String getAppointmentServiceUrl() {
		return appointmentServiceUrl;
	}

	public String getLabServiceUrl() {
		return labServiceUrl;
	}

	public String getNotificationServiceUrl() {
		return notificationServiceUrl;
	}

	public String getPrescriptionServiceUrl() {
		return prescriptionServiceUrl;
	}
}
