package com.barath.customer.app.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryController {
	
	private final DiscoveryClient discoveryClient;
	
	private final LoadBalancerClient loadBalancerClient;

	public DiscoveryController(DiscoveryClient discoveryClient,  LoadBalancerClient loadBalancerClient) {
		super();
		this.discoveryClient = discoveryClient;
		this.loadBalancerClient= loadBalancerClient;
	}
	
	@GetMapping("/discovery/services")
	public List<String> services() {
		return this.discoveryClient.getServices();
	}
	
	
	@GetMapping("/discovery/services/{serviceId}")
	public List<ServiceInstance> services(@PathVariable String serviceId) {
		return this.discoveryClient.getInstances(serviceId);
	}
	
	@GetMapping("/loadbalancer/discovery/services/{serviceId}")
	public String getLoadBalancerIp(@PathVariable String serviceId) {
		
		return Objects.toString(loadBalancerClient.choose(serviceId).getUri());
	}

}
