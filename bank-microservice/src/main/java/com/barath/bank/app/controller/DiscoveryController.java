package com.barath.bank.app.controller;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryController {
	
	private DiscoveryClient discoveryClient;

	public DiscoveryController(DiscoveryClient discoveryClient) {
		super();
		this.discoveryClient = discoveryClient;
	}
	
	@GetMapping("/discovery/services")
	public List<String> services() {
		return this.discoveryClient.getServices();
	}
	
	
	@GetMapping("/discovery/services/{serviceId}")
	public List<ServiceInstance> services(@PathVariable String serviceId) {
		return this.discoveryClient.getInstances(serviceId);
	}

}
