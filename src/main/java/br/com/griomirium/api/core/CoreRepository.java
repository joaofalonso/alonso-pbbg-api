package br.com.griomirium.api.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoreRepository extends JpaRepository<CoreBase, Long> {

    Page<CoreBase> findAllByActiveTrue(Pageable pageable);
}
