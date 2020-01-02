package com.cash.ms.serivice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cash.ms.model.EntityCashAdvance;
import com.cash.ms.repository.ICashAdvanceRepository;
import com.cash.ms.webclient.CallWebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CashAdvanceServiceImpl implements ICashAdvanceService {

	@Autowired
	ICashAdvanceRepository repository;
	
	@Autowired
	@Qualifier("webClient")
	CallWebClient client;
	List<String> docs;
	SimpleDateFormat format;
	
	@Override
	public Flux<EntityCashAdvance> allCashAdvance() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<EntityCashAdvance> saveCashAdvance(EntityCashAdvance cashAdvance) {
		// TODO Auto-generated method stub
		docs = new ArrayList<>();
		docs.add(cashAdvance.getCustomerEntity().getDniH());
		
		/*return client.responde(docs).flatMap(res -> {
			if(res.getMsg().equals("")) {
				*/
				return repository.save(cashAdvance);
		/*	}else {
				return Mono.empty();
			}
			
		});*/
		//
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

	@Override
	public Flux<EntityCashAdvance> findByBankAndDateOpenBetween(String bank, String dt1, String dt2)
			throws ParseException {
		format = new SimpleDateFormat("yyyy-MM-dd");
		return repository.findByBankAndDateRegBetween(bank, format.parse(dt1), format.parse(dt2));
	}

}
