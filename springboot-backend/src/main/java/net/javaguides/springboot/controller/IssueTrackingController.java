package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.IssueTracking;
import net.javaguides.springboot.repository.IssueTrackingRepository;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api/v1")
public class IssueTrackingController {
	@Autowired
	private IssueTrackingRepository issueTrackingRepository;
	
	//Get All Issues
	@GetMapping("/issues")
	public List <IssueTracking> getAllIssues(){
		return issueTrackingRepository.findAll();
	}
	
	//Create Issue
	@PostMapping("/issues")
	public IssueTracking createIssue(@RequestBody IssueTracking issueTracking) {
		return issueTrackingRepository.save(issueTracking);
	}
	
	//Get Issue By Id
	@GetMapping("/issues/{id}")
	public ResponseEntity <IssueTracking> getIssueById(@PathVariable Long id){
		IssueTracking issueTracking = issueTrackingRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Issue Not Found"+id));
		
		return ResponseEntity.ok(issueTracking);
		
	}
	
	//Update Issue
	@PutMapping("/issues/{id}")
	public ResponseEntity <IssueTracking> updateIssue(@PathVariable Long id, @RequestBody IssueTracking issueTrackingDetails ){
		IssueTracking issueTracking = issueTrackingRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Issue Not Found"+id));
		
		issueTracking.setId(issueTrackingDetails.getId());
		issueTracking.setTitle(issueTrackingDetails.getTitle());
		issueTracking.setDescription(issueTrackingDetails.getDescription());
		issueTracking.setStatus(issueTrackingDetails.getStatus());
		issueTracking.setPriority(issueTrackingDetails.getPriority());
		issueTracking.setAssignee(issueTrackingDetails.getAssignee());
		issueTracking.setCreatedDate(issueTrackingDetails.getCreatedDate());
		issueTracking.setDueDate(issueTrackingDetails.getDueDate());
		
		IssueTracking updatedIssueTracking = issueTrackingRepository.save(issueTracking);
		
		return ResponseEntity.ok(updatedIssueTracking);
	}
	 
	//Delete Issue 
	@DeleteMapping("/issues/{id}")
	public ResponseEntity <Map<String,Boolean>> deleteIssue (@PathVariable Long id){
		IssueTracking issueTracking = issueTrackingRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Issue Not Found"+id));
		
		issueTrackingRepository.delete(issueTracking);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	
	
}


