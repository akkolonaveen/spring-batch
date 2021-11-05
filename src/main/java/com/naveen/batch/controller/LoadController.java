package com.naveen.batch.controller;

import java.util.*;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadController {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	
	@Autowired
	private Job job;
	@RequestMapping("/load")
	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException
	{
		Map<String,JobParameter> maps=new HashMap<>();
		maps.put("time",new JobParameter(System.currentTimeMillis()));
		JobParameters parameters=new JobParameters(maps);
		JobExecution jobExceution= (JobExecution) jobLauncher.run(job, parameters);
		System.out.println("job execution "+jobExceution.getStatus());
		
		System.out.println(" batch is running");
		while(jobExceution.isRunning())
		{
			System.out.println("still ");
		}
		
		return jobExceution.getStatus();
	}

}
