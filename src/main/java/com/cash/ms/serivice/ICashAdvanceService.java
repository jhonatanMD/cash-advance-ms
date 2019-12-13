package com.cash.ms.serivice;

import com.cash.ms.model.EntityCashAdvance;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICashAdvanceService {

	Flux<EntityCashAdvance> allCashAdvance();
	Mono<EntityCashAdvance> saveCashAdvance(final EntityCashAdvance cashAdvance);
	Mono<EntityCashAdvance> updCashAdvance(final EntityCashAdvance cashAdvance);
	Mono<Void> dltCashAdvance(String id);
	Mono<EntityCashAdvance> cashAdvanceDocCli(String docCli);
}
