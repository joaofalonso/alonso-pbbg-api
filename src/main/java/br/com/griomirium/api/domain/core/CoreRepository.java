package br.com.griomirium.api.domain.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoreRepository extends JpaRepository<CoreBase, Long> {

    Page<CoreBase> findAllByActiveTrue(Pageable pageable);
}
