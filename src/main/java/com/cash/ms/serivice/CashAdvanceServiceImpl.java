package com.cash.ms.serivice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cash.ms.model.EntityCashAdvance;
import com.cash.ms.repository.ICashAdvanceRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CashAdvanceServiceImpl implements ICashAdvanceService {

	@Autowired
	ICashAdvanceRepository repository;
	
	@Override
	public Flux<EntityCashAdvance> allCashAdvance() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<EntityCashAdvance> saveCashAdvance(EntityCashAdvance cashAdvance) {
		// TODO Auto-generated method stub
		return repository.save(cashAdvance);
	}

	@Override
	public Mono<EntityCashAdvance> updCashAdvance(EntityCashAdvance cashAdvance) {
		// TODO Auto-generated method stub
		return repository.save(cashAdvance);
	}

	@Override
	public Mono<Void> dltCashAdvance(String id) {
		// TODO Auto-generated method stub
		return repository.deleteById(id);
	}

	@Override
	public Mono<EntityCashAdvance> cashAdvanceDocCli(String docCli) {
		// TODO Auto-generated method stub
		return repository.findByCashByDoc(docCli);
	}

}
