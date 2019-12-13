package com.cash.ms.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cash.ms.model.EntityCashAdvance;
import com.cash.ms.serivice.CashAdvanceServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class CashAdvanceController {
	
	@Autowired
	CashAdvanceServiceImpl imple;
	
	@GetMapping("/getCashAdvances")
	public Flux<EntityCashAdvance> getCashAdvances() {		
		return imple.allCashAdvance();
	}
	
	@GetMapping("/getCashAdvance/{docCli}")
	public Mono<EntityCashAdvance> getCashAdvance(@PathVariable("docCli") String docCli) {		
		return imple.cashAdvanceDocCli(docCli);
	}
	
	@PostMapping("/postCashAdvance")
	public Mono<EntityCashAdvance> postCashAdvance(@RequestBody EntityCashAdvance cashAdvance){
		Date dt = new Date();
		cashAdvance.setDateRg(dt);
		return imple.saveCashAdvance(cashAdvance);
	}
	
	@PutMapping("/updCashAdvance")
	public Mono<EntityCashAdvance> updCashAdvance(@RequestBody EntityCashAdvance cashAdvance){
		
		return imple.updCashAdvance(cashAdvance);
	}
	
	@DeleteMapping("/dltCashAdvance/{id}")
	public Mono<Void> dltCashAdvance(@PathVariable final String id){
		
		return imple.dltCashAdvance(id);
	}

	@PostMapping("/retiroCashAdvance/{docCli/{cash}")
	public Mono<EntityCashAdvance> retiroCashAdvance(@PathVariable("docCli") String docCli , @PathVariable("cash")
	Double cash){
		return imple.cashAdvanceDocCli(docCli)
				.flatMap(p ->{
					if(p.getCash() >= cash) {
						p.setCash(p.getCash() - cash);
					}
			return imple.updCashAdvance(p);
			});
	}
	
}