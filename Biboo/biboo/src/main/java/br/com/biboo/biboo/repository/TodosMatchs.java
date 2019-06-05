package br.com.biboo.biboo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biboo.biboo.domain.Match;

public interface TodosMatchs extends JpaRepository<Match, Integer> {
	
}
