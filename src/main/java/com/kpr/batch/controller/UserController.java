/**
 * 
 */
package com.kpr.batch.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PushkarRajuKoppanath
 *
 */
@RestController
@RequestMapping("/load")
public class UserController {
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@GetMapping
	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException{
		
		@SuppressWarnings("rawtypes")
		Map<String, JobParameter> params = new HashMap();
		params.put("time", new JobParameter(System.currentTimeMillis()));
		
		JobParameters jobParameters = new JobParameters(params);
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		
		System.out.println("Job Status :"+jobExecution.getStatus());
		while(jobExecution.isRunning()) {
			System.out.println("..");
		}
		
		return jobExecution.getStatus();
	}
	
}
