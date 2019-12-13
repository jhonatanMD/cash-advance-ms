package com.cash.ms.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.cash.ms.model.EntityCashAdvance;

import reactor.core.publisher.Mono;

@Repository
public interface ICashAdvanceRepository  extends ReactiveMongoRepository<EntityCashAdvance,String>{
	Mono<EntityCashAdvance> findByDocCli(String docCli);

}
